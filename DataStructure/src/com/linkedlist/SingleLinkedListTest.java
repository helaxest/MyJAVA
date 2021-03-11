package com.linkedlist;

import java.util.Stack;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/03/10  15:17
 * @mail:
 * @since JDK 1.8
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");


        SingleLinkList singleLinkList = new SingleLinkList();
//        singleLinkList.addNode(hero1);
//        singleLinkList.addNode(hero2);
//        singleLinkList.addNode(hero3);
//        singleLinkList.addNode(hero4);
        singleLinkList.addNodeByOrder(hero2);
        singleLinkList.addNodeByOrder(hero3);
        singleLinkList.addNodeByOrder(hero4);
        singleLinkList.addNodeByOrder(hero1);

        singleLinkList.list();
        HeroNode newNode = new HeroNode(2, "小卢", "玉麒麟~~~~");
        System.out.println("==============修改后===========");
        singleLinkList.update(newNode);


//        singleLinkList.delete(2);
//        singleLinkList.delete(1);
//        singleLinkList.delete(3);
//        singleLinkList.delete(4);
        //获取单链表的有效节点，除掉头结点
        System.out.println("链表的有效节点为" + singleLinkList.getNodes());
        //反转链表
        singleLinkList.reverseLinkList();

        //倒数第index个节点
        singleLinkList.list();
        System.out.println(singleLinkList.getLastIndexNode(3));

        //反向遍历（栈操作）
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode headNode = singleLinkList.getLastIndexNode(singleLinkList.getNodes() + 1);//得到头结点
        HeroNode temp=headNode.next;
        while (true){
            if(temp==null){
                break;
            }
            stack.push(temp);
            temp=temp.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
        //合并两个单链表
        //个人思路 若单链表无需按特定要求，则将其中的一个链表节点的next为空的节点之乡另一个节点头部的next


    }
}

class SingleLinkList {
    private HeroNode head = new HeroNode(0, "", "");//头结点,不存数据

    //不考虑编号顺序
    //1.找到当前链表的最后节点
    //2.最后的节点指向性的节点
    public void addNode(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //第二种方式添加英雄,根据排名将英雄插入到指定位置
    //如果有排名的，则添加失败，并提示
    //因为单链表,temp位于添加为的前一个节点 否则插入不了
    public void addNodeByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;//标识加的编号是否存在，默认为false
        while (true) {
            if (null == temp.next) {//temp为链表最后
                break;
            }
            if (node.id < temp.next.id) {//找到
                break;
            } else if (node.id == temp.next.id) {
                flag = true;//已有编号
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备插入的英雄编号已经存在\n", node.id);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }


    public void update(HeroNode node) {
        if (null == head.next) {
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (null == temp) {
                break;
            }
            if (node.id == temp.id) {
                flag = true;
                break;//找到了
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.printf("没有找到编号为%d的节点\n", node.id);
        }

    }

    public void delete(int id) {

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (null == temp.next) {
                break;
            }
            if (id == temp.next.id) {
                flag = true;
                break;//找到了
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号为%d的节点\n", id);
        }

    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    public int getNodes() {
        HeroNode temp = head;
        int count = 0;//计数器
        if (temp.next == null) {
            return count;
        }

        while (true) {
            if (temp.next == null) {
                break;//最后一个节点
            }
            temp = temp.next;
            count++;
        }
        return count;

    }

    //反转链表
    public void reverseLinkList() {
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(-1, "", "");//新链表的头
        if (cur.next == null || cur == null) {
            return;//此链表为空链表或者只有一个有效节点
        }
        while (cur != null) {//遍历原来的链表  cur为原链表的当前节点
            next = cur.next;//保存起来，用于在原链表上继续移动
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;//将原来的头节点

    }

    public HeroNode getLastIndexNode(int index) {
        if (head.next == null) {
            return null;
        }
        int count = this.getNodes();//当前节点的数量，不包括头结点

        if (index <=0 && index > count){//index需要校验 是否越界
            return null;
        }
            System.out.println(count);
        HeroNode temp = head;
        for (int i = 0; i < count - index + 1; i++) {
            temp = temp.next;
        }
        return temp;

//        if(head.next == null) {
//            return null;//没有找到
//        }
//        //第一个遍历得到链表的长度(节点个数)
//        int size = this.getNodes();
//        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
//        //先做一个index的校验
//        if(index <=0 || index > size) {
//            return null;
//        }
//        //定义给辅助变量， for 循环定位到倒数的index
//        HeroNode cur = head.next; //3 // 3 - 1 = 2
//        for(int i =0; i< size - index; i++) {
//            cur = cur.next;
//        }
//        return cur;
    }
}


class HeroNode {
    public int id;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
