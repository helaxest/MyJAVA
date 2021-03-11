package com.thread;

class Clerk {
    private int production = 0;//公共资源

    public synchronized void ProduceProduct() {
        notify();
        if (production < 20) {
            production++;
            System.out.println(Thread.currentThread().getName() + "正在生产产品" + production);

        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void ConsumerProduct() {
        notify();
        if (production > 0) {

            System.out.println(Thread.currentThread().getName() + "正在消费产品" + production);
            production--;

        } else {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}


class Produce extends Thread {
    private Clerk clerk;

    public Produce(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产");
        while (true) {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.ProduceProduct();
        }

    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName() + "开始消费");
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.ConsumerProduct();
        }
    }
}


public class JavaTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Produce product = new Produce(clerk);
        Consumer consume1 = new Consumer(clerk);
        Consumer consume2 = new Consumer(clerk);
        product.setName("生产者");
        consume1.setName("消费者1");
        consume2.setName("消费者2");
        product.start();
        consume1.start();
        consume2.start();
    }
}
