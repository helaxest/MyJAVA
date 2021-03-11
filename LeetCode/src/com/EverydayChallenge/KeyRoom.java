package com.EverydayChallenge;

/**
 * Description  钥匙和房间   dfs
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，
 * 并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，
 * 每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。
 * 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * ---你可以自由地在房间之间来回走动。如果能进入每个房间返回 true，否则返回 false。
 *
 *
 * @author helaxest
 * @date 2020_08_31 8:34
 * @mail:
 * @since JDK 1.8
 */
public class KeyRoom {


//    int [][] rooms={{2},{3,0,1},{2},{0}};
////  int[][] rooms = {{1}, {2}, {3}, {0}};
//    boolean Isflag=true;
//    int i;//房间号
//    @Test
//    public void test() {
//
//        for ( i = 0; i < rooms.length; i++) {//进入第N个房间
//
//            for (int j = 0; j < rooms[i].length; j++) {//在第i个房间拿钥匙j
//                if(rooms[i][j]==i+1){
//                    System.out.println("进入第 "+(i+1)+" 号房间");
//                        Isflag=true;
//                }
//                else{
//                    if (i<rooms.length-1) {//判断是否为最后一个房间
//                        Isflag = false;
//                        System.out.println(i);
//                    }
//                }
//            }
//        }
//        System.out.println(Isflag);
//
//    }
}
