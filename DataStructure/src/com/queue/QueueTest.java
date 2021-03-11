package com.queue;

import java.util.Scanner;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/03/10  12:54
 * @mail:
 * @since JDK 1.8
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        char key = ' ';//用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show) :显示队列");
            System.out.println("e(exit) :退出队列");
            System.out.println("a(add) :添加数据");
            System.out.println("g(get) :取出数据");
            System.out.println("h(headQueue) :查看对猎头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':

                    try {
                        int res = queue.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.HeadQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }


}

class Queue {
    private int maxSize;//表示数组的最大容量
    private int front;//头部
    private int rear;//尾部
    int[] arr;

    public Queue(int arrMaxSize) {
        maxSize = arrMaxSize;
        // this.front = -1;
        // this.rear = -1;
        arr = new int[maxSize];
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
//     return   rear=maxSize-1;
        return (rear+1)%maxSize == front ;
    }

    void addQueue(int data) {

        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
//        rear++;
//        arr[rear] = data;
        arr[rear]=data;
        rear=(rear+1)%maxSize;

    }

    int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

//        front++;//front后移
//        return arr[front];
//

        //1.先把front 对应的值保存到临时变量
        //front后移
        //将临时变量返回
        int v=arr[front];
        front=(front+1)%maxSize;
        return v;
    }

    void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("arr[%d]=%d\n", i, arr[i]);
//        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }

    }

    int HeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front];
    }

    //求出当前队列有效数据
    public int size(){
        return (rear-front+maxSize)%maxSize;
    }
}
