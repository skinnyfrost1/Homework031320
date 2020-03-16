package app.threads;

public class Buffer {
    // private Producer producer;
    // private Consumer consumer;
    // private String name;
    int mask = 0;
    boolean isEmpty = true;
    // private static int surface = 0;
    private final static int MAX_STORAGE = 80;
    private final static int MIN_STORAGE = 0;

    // public Buffer(String name, Producer producer, Consumer consumer) {
    // this.producer = producer;
    // this.consumer = consumer;
    // this.name = name;
    // }

    // public Buffer(String name) {
    // this.name = name;
    // }

    public synchronized void produceMask(int quantity) {
        if (quantity + mask >= MAX_STORAGE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            mask += quantity;
            isEmpty = false;
            System.out.println("[p] have been make " + quantity + " masks. stay health." + mask);
            notify();
        }

    }

    public synchronized void consumeMask(int quantity) {
        if (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            mask -= quantity;
            if (mask <= MIN_STORAGE)
                isEmpty = true;
            System.out.println("[c] have been Consume " + quantity + " masks. stay health." + mask);
            notify();
        }

    }
}