package com.linkedlist;

/**
 * Description
 * Josephu(约瑟夫、约瑟夫环)  问题
 * Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 * <p>
 * 提示：用一个不带头结点的循环链表来处理Josephu 问题：先构成一个有n个结点的单循环链表，然后由k结点起从1开始计数，
 * 计到m时，对应结点从链表中删除，然后再从被删除结点的下一个结点又从1开始计数，直到最后一个结点从链表中删除算法结束。
 *
 * @author helaxest
 * @date 2021/03/11  6:56
 * @since
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();
        circleSingleLinkList.addBoy(5546);
        circleSingleLinkList.list();
        circleSingleLinkList.countBoy(125,89,458);
    }

}

//创建一个boy类
class Boy {
    private int no;
    private Boy next;

    public Boy() {
    }

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}


//创建一个单向循环链表
class CircleSingleLinkList {
    //先创建一个没有编号的first节点
    Boy first = new Boy(-1, null); //first节点用于指向第一个节点
    //添加boy,构建链表

    /**
     * @param nums 添加boy的数量
     */
    public void addBoy(int nums) {
        //验证nums数字
        if (nums <= 0) {
            System.out.println("添加的数字必须大于1");
            return;
        }
        Boy curBoy = new Boy();//辅助创建环形链表

        for (int i = 1; i <= nums; i++) {//从第一个开始设置
            Boy boy = new Boy(i, null);
            if (i == 1) {
                first = boy;
                first.setNext(first);//此时first成为第一个boy
                curBoy = first;//辅助
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);//于第一个节点成环
                curBoy = boy;
            }
        }
    }

    public void list() {
        if (first == null) {
            System.out.println("链表为空");
        }
        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy.getNo());//输出语句位置有影响
            if (curBoy.getNext() == first) {//curBoy.getNext()返回值为boy,对自身进行了操作
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     * @param startNo  开始人的编号
     * @param countNum 数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {

        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        Boy help = first.getNext();//始终在first前面一个位置
        while (true) {
            if (help.getNext() == first) {
                break;
            }
            help = help.getNext();
        }
        //报数前处理first和help位置
        for (int i = 0; i < startNo - 1; i++) {//startNo-1 若从1开始,无需处理
            first = first.getNext();
            help = help.getNext();
        }
        //开始数
        while (true) {
            //圈内只有一个节点,终止循环
            if (help == first) {
                break;
            }
            for (int i = 0; i < countNum-1; i++) {//数数代表着first和help开始移动
                first=first.getNext();
                help=help.getNext();
            }
            //移动完毕后 first就为出圈的人
            System.out.println("出圈节点"+first.getNo());
            first=first.getNext();//重置first的位置
            help.setNext(first);//help始终在first后面

        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }

}