package com.stack;

import java.util.Scanner;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/03/11  7:38
 * @since
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(2);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }

}


class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    boolean isEmpty() {
        return top == -1;
    }

    //入栈
    void push(int data) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = data;//将数据放在栈顶
    }

    //出栈
    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~");
        }
        int data = stack[top];
        top--;
        return data;
    }

    //遍历栈
    void showStack() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        while (true) {
            if (top == -1) {
                break;
            }
            System.out.println(stack[top]);
            top--;

        }
    }
}