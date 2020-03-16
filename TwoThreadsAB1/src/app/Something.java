package app;

public class Something {
    boolean isLetter = false;
    int numbers = 0;

    public synchronized void printLetter(String str) {
        if (!isLetter)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        else {
            System.out.print(str);
            isLetter = false;
            notify();
        }
    }

    public synchronized void printNumber(String str) {
        if (isLetter)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        else {
            System.out.print(str);
            if (numbers < 1)
                numbers++;
            else {
                numbers--;
                isLetter = true;
            }
        }
    }

}