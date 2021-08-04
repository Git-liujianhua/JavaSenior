package com.java.test;


//线程通信
class Number implements Runnable{
    private int i = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                //使得调用notift()唤醒阻塞的线程
                notify();
                if (i <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        //使得调用wait()方法的线程阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}


public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
