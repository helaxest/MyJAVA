package com.sparsearray;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/03/10  11:55
 * @mail:
 * @since JDK 1.8
 */
public class SparesArray {
    public static void main(String[] args) {
        //创建一个二维数组 11*11
        //0 表示黑子 1 表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[4][3] = 2;
        System.out.println("二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("妻子个数:" + sum);

        int sparesArr[][] = new int[sum + 1][3];
        sparesArr[0][0] = chessArr1.length;
        sparesArr[0][1] = chessArr1.length;
        sparesArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparesArr[count][0] = i;
                    sparesArr[count][1] = j;
                    sparesArr[count][2] = chessArr1[i][j];
                }
            }

        }
        System.out.println();
        for (int[] row : sparesArr) {
            for (int data : row) {
                System.out.printf("%d \t", data);
            }
            System.out.println();
        }

        System.out.println();
        int chessArr2[][] = new int[sparesArr[0][0]][sparesArr[0][1]];
        for (int i = 0; i < sparesArr[0][0]; i++) {
            for (int j = 0; j < sparesArr[0][1]; j++) {
                System.out.printf("%d \t", chessArr2[i][j]);
            }
            System.out.println();
        }
        for (int i = 1; i < sparesArr.length; i++) {
            chessArr2[sparesArr[i][0]][sparesArr[i][1]] = sparesArr[i][2];
        }
        System.out.println("回复");
        for (int i = 0; i < sparesArr[0][0]; i++) {
            for (int j = 0; j < sparesArr[0][1]; j++) {
                System.out.printf("%d \t", chessArr2[i][j]);
            }
            System.out.println();
        }


    }
    //补充将稀疏数组保存到磁盘 ，读取数据恢复

}

