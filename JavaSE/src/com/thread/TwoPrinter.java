package com.thread;

/**
 * Description:交替打印 用Runnable
 * date:2020-08-12 9:25
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
class Print implements Runnable {
    private static int num = 100;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notify();
                if (num>0) {

                    System.out.println(Thread.currentThread().getName() + "说" + num);
                    num--;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }

}

public class TwoPrinter{
    public static void main(String[] args) {
        Print print = new Print();
        Thread m1 = new Thread(print);
        Thread m2 = new Thread(print);
        m1.start();
        m2.start();


    }


}

