package app.threads;

public class Number extends Thread {
    private String name;
    private Object pre;
    private Object own;

    public Number(String name, Object pre, Object own) {
        this.name = name;
        this.pre = pre;
        this.own = own;
    }

    @Override
    public void run() {
        for (int i = 1; i < 53; i++) {
            synchronized (pre) {
                synchronized (own) {
                    System.out.print(i);
                    System.out.print(++i);
                    own.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}