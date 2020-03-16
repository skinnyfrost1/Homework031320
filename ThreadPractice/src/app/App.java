package app;

import app.threads.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Object a = new Object();
		Object b = new Object();
		Object c = new Object();

        Thread t1 = new Thread(new ThreadOne("A", c, a));
        Thread t2 = new Thread(new ThreadTwo("B", a, b));
        Thread t3 = new Thread(new ThreadThree("C", b, c));

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();
        Thread.sleep(100);

      
  
        

            

    }
}

