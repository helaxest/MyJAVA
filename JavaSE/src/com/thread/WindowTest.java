package com.thread;

/**
 * Description:窗口卖票 ①继承 ② Runnable（优先） 两种方法都需要重写run（）
 * 问题：重票 错票
 * 解决方法：同步机制
 * 方式一：同步代码块
 * synchronized(同步监视器){
 *
 *   //需要被同步的代码
 *
 * }
 * 操作共享数据的代码
 *
 * 同步监视器（锁）任何一个类的对象都可以作为锁
 *
 *
 *
 * 方式二：同步方法
 * 如果操作共享数据的代码完整的写在一个方法中，不妨将此方法声明为同步的
 *
 * 1.同步方法仍然涉及同步监视器，只是不需要显示的声明
 * 2.非静态的同步方法，同步监视器：this
 *   静态同步方法，同步监视器为当前类本身
 * ----------------------------------------------
 * Runnable
 * 1.实现创建Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run（）
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread的类的对象调用start（）
 *
 * date:2020-08-11 9:23
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
class myWindow implements Runnable{
    private  int ticket = 500;

    @Override
    public void run() {
        while (true) {

            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖票" + "，号码为" +ticket);
                ticket--;

            } else {
                break;
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        myWindow w=new myWindow();
        Thread m1=new Thread(w);
        Thread m2=new Thread(w);
        Thread m3=new Thread(w);
        m1.setName("窗口1");
        m2.setName("窗口2");
        m3.setName("窗口3");
        m1.start();
        m2.start();
        m3.start();

    }


}
