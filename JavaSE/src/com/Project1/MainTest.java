package com.Project1;

import java.util.Scanner;

/**
 * Description:
 * date:2020-08-17 8:04
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class MainTest {
    public static void main(String[] args) {

        int balance=10000;

       
        String detail = "收支\t\t账户金额\t\t\t 收支金额\t\t说 明"+"\n";

        Scanner scan=new Scanner(System.in);
        boolean IsFlag=true;


        while (IsFlag) {
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println("");
            System.out.println("\t\t\t\t1 收支明细");
            System.out.println("\t\t\t\t2 登记收入");
            System.out.println("\t\t\t\t3 登记支出");
            System.out.println("\t\t\t\t4 退 出");
            System.out.println("");
            System.out.print("请选择(1-4)：");
            int num;
            num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.print(detail);
                    System.out.println("------------------------------------------------");
                    break;
                case 2:
                    System.out.print("本次收入金额：");
                    int earn= Utility.readNumber();
                    System.out.print("本次收入说明：");
                    balance=balance+earn;
                    String explain1= Utility.readString();
                    detail+="收入"+"\t\t"+balance+"\t\t\t "+earn+"\t\t\t"+explain1+"\n";//字符串用'+'来连接每条记录
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(detail);
                    System.out.println("----------------------登记完成----------------------");

                    break;
                case 3:

                    System.out.print("本次收入金额：");
                    int pay= Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String explain2= Utility.readString();

                    if(balance-pay>0) {
                        balance = balance - pay;
                        detail+="支出"+"\t\t"+balance+"\t\t\t "+pay+"\t\t\t"+explain2+"\n";
                        System.out.println("-----------------当前收支明细记录-----------------");
                        System.out.println(detail);
                        System.out.println("----------------------登记完成----------------------");

                    }
                    else{
                        System.out.println("支出金额大于总金额，支付失败");
                    }

                    break;
                case 4:
                    System.out.print("是否要退出，请输入(Y/N)：");
                    char confirm= Utility.readConfirmSelection();
                    if(confirm=='Y'){
                        IsFlag=false;
                    }
                    break;
            }
        }
    }
}
