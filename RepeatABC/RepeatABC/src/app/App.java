package app;

import app.threads.ThreadABC;

public class App {
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ThreadABC t1 = new ThreadABC("A",c,a);
        ThreadABC t2 = new ThreadABC("B",a,b);
        ThreadABC t3 = new ThreadABC("C",b,c);


        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();

    }
}