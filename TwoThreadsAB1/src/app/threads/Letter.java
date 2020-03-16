package app.threads;

public class Letter extends Thread {
    private String name;
    private Object pre;
    private Object own;

    public Letter(String name, Object pre, Object own) {
        this.name = name;
        this.pre = pre;
        this.own = own;
    }

    @Override
    public void run() {
        for (int i = 0; i < 26; i++) {
            synchronized (pre) {
                synchronized (own) {
                    System.out.print((char)(i+'A')+" ");
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