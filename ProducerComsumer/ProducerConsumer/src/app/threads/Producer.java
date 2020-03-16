package app.threads;

import java.util.Random;

public class Producer extends Thread {
    private Buffer buf;
    private String name;
    Random ran = new Random();
    int quantity;

    public Producer(String name) {
        this.name = name;
    }

    public Producer(String name, Buffer buf) {
        this.name = name;
        this.buf = buf;
    }

    @Override
    public void run() {
        // for (int i = 1 ;i< 50; i++) {

        while (true) {
            do{
                quantity = ran.nextInt(5);
            }while(quantity<=0);
            buf.produceMask(quantity);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}