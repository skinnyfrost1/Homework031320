package app.threads;

import app.Something;

public class ThreadTwo implements Runnable {
    // public ThreadTwo(String name) {
    // super(name);
    // }
    private String name;
    private Object pre;
    private Object own;

    public ThreadTwo(String name, Object pre, Object own) {
        this.name = name;
        this.pre = pre;
        this.own = own;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("[Two] BEGIN of the while.");

            synchronized (pre) {
                System.out.println("[Two] BEGIN of the pre.");

                synchronized (own) {
                    System.out.println("[Two] BEGIN of the own.");

                    // System.out.println("------------[ThreadTwo]-------------------------------");
                    int rand = Something.getRand();
                    Something.setSquare(rand * rand);
                    System.out.println(
                            "[TWO] The square of " + Something.getRand() + " is " + Something.getSquare());
                    own.notify();
                    System.out.println("[Two] END of the own.");

                }
                try {
                    pre.wait();
                    System.out.println("[Two] END of the wait.");

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("[Two] END of the pre.");

            }

        }
    }
}