package app;

import app.threads.*;
import app.threads.Number;

public class App {
    public static void main(String[] args) throws Exception {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Number t1 = new Number("number",obj2,obj1);
        Letter t2 = new Letter("letter",obj1,obj2);
        t1.start();
        t2.start();
    }
}