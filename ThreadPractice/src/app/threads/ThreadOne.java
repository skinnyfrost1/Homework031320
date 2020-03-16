package app.threads;

import java.lang.Math;

import app.Something;

public class ThreadOne implements Runnable {
    // public ThreadOne(String name){
    // super(name);
    // }
    private String name;
    private Object pre;
    private Object own;

    public ThreadOne(String name, Object pre, Object own) {
        this.name = name;
        this.pre = pre;
        this.own = own;
    }

    @Override
    public void run() {
        int range = 10;
        int rand;

        while (true) {
            // System.out.println("------------[ThreadOne]-------------------------------");
            System.out.println("[One] BEGIN of the while.");
            synchronized (pre) {
                System.out.println("[One] BEGIN of pre");
                synchronized (own) {
                    System.out.println("[One] BEGIN of own");
                    rand = (int) (Math.random() * range);
                    Something.setRand(rand);
                    System.out.println("[One] The random Number is: " + Something.getRand());
                    own.notify();
                    System.out.println("[One] END of own");
                }
                try {
                    pre.wait();
                    System.out.println("[One] END of wait");

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("[One] END of the pre.");
            }
        }
    }
}