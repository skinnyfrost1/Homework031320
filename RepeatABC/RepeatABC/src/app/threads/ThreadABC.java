package app.threads;

public class ThreadABC extends Thread {
    private String name;
    private Object pre;
    private Object own;

    public ThreadABC(String name, Object pre, Object own) {
        this.name = name;
        this.pre = pre;
        this.own = own;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (pre) {
                synchronized (own) {
                    System.out.print(name);
                    
                    own.notify();
                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
        }

    }

}