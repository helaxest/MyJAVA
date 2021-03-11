package com.thread;

/**
 * Description:方式一 继承Threa类
 * 1.创建thread类子类
 * 2.重写thread类的run（）
 * 3.创建thread类子类的对象
 * 4.通过此对象调用start（）
 * date:2020-08-11 7:34
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
    class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
    class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                if (i % 2 == 1) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }
    }

    public class ThreadTest {
        public static void main(String[] args) {
            MyThread t1 = new MyThread();
            MyThread2 t2 = new MyThread2();
            t2.start();
// 问题一我们不能通过直接调用run（）的方式调用
// 问题二 不能让以启动的线程start（），会报异常Exception in thread "main" java.lang.IllegalThreadStateException

            for (int i = 0; i < 30; i++) {
                if (i % 2 == 0) {
                    System.out.println( "......main().......");
                }
            }
            t1.start();//①启动当前线程 ②运行当前线程
//            t1.run();造完对象调用方法 ，不能通过run（）的方式启动线程

            //创建Thread匿名子对象
            new Thread(){
                @Override
                public void run() {

                }
            }.start();

        }
}
