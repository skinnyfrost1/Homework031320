package app;

import app.threads.*;

public class App {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer();
        Producer producer = new Producer("producer", buffer);
        Consumer consumer = new Consumer("consumer", buffer);
        producer.start();
        consumer.start();
    }
}