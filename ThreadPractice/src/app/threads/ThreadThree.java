package app.threads;

import app.Something;

public class ThreadThree implements Runnable {
    // public ThreadTwo(String name) {
    // super(name);
    // }
    private String name;
    private Object pre;
    private Object own;

    public ThreadThree(String name, Object pre, Object own) {
        this.name = name;
        this.pre = pre;
        this.own = own;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("[Three] BEGIN of the while.");
            synchronized (pre) {
                System.out.println("[Three] BEGIN of the pre.");
                synchronized (own) {
                    System.out.println("[Three] BEGIN of the own.");
                    // System.out.println("------------[ThreadTwo]-------------------------------");
                    int rand = Something.getRand();
                    Something.setCube(rand * rand * rand);
                    System.out
                            .println("[ThreadThree] The cube of " + Something.getRand() + " is " + Something.getCube());
                    try {
                        System.out.println("[Three] BEGIN of SLEEP.");

                        Thread.sleep(5000);
                        System.out.println("[Three] END of the SLEEP.");

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    own.notify();
                    System.out.println("[Three] END of the own.");
                }
                try {
                    pre.wait();
                    System.out.println("[Three] END of the wait.");

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("[Three] END of the pre.");

            }

        }
    }
}