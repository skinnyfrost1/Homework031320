package app.threads;

public class Consumer extends Thread {
    private Buffer buf;
    private String name;

    public Consumer(String name, Buffer buf) {
        this.buf = buf;
        this.name = name;
    }

    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            buf.consumeMask(1);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}