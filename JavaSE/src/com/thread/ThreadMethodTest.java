package com.thread;

/**
 * Description:串口卖票
 * 测试thread常用方法
 * 1.start（）
 * 2.run()需要重写thread里此方法
 * 3.currentThread（）静态方法
 * 4.getName（）获取当前线程名字
 * 5.setName（）设置当前线程名字
 * 6.yield():释放当前cpu的执行权
 * 7.join（）在线程a中调用线程b的join，此时线程a就进入阻塞状态，直到线程b执行完，a结束阻塞状态
 * 8.stop（）（已过时）结束线程
 * 9.sleep（）会报异常 需要try catch 使当前线程睡眠，线程为阻塞状态
 *     此方法同时会使几率较小的结果异常 以更大的几率的暴露出来
 * 10.isAlive（）判断当前线程是否存活
 * <p>
 * 线程的优先级
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NOR_PRIORITY:5
 * 获取和设置当前线程优先级
 * getPriority（）
 * setPriority（int p）
 * <p>
 * 说明：高优先级只会抢占低优先级的执行权
 * date:2020-08-11 8:30
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */

class window extends Thread {
    private static int ticket = 99;

    @Override
    public void run() {


        while (true) {
//            try {
//                sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (ticket > 0) {
                    System.out.println(getName()+"卖票" + "，号码为" +ticket);
                    ticket--;

            } else {
                break;
            }
        }
    }
}
// 仍存在缺陷，可能会出现错票 ，重票
//线程同步安全

    public class ThreadMethodTest {
        public static void main(String[] args) {

            window t1=new window();
            window t2=new window();
            window t3=new window();
            t1.setName("窗口1");
            t2.setName("窗口2");
            t3.setName("窗口3");
            t1.start();
            t2.start();
            t3.start();

        }

    }



