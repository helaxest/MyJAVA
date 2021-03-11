package com.Project2;

/**
 * Description: 用户管理系统
 * 添加，修改，删除 功能基本完成，特许情况考虑不够， 有待改进
 * date:2020-08-17 11:43
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
public class CustomerView {

    private CustomerList customerList=new CustomerList(9);

    public CustomerView() {
        Customer customer=new Customer("小明",'男',15,"123456","123@456");
       customerList.addCustomer(customer);
    }

    public void enterMainMenu(){
            boolean IsFlag=true;
            do{

                System.out.println("-----------------客户信息管理软件-----------------\n");
                System.out.println("                1 添 加 客 户\n");
                System.out.println("                2 修 改 客 户\n");
                System.out.println("                3 删 除 客 户\n");
                System.out.println("                4 客 户 列 表\n");
                System.out.println("                5 退     出 \n");
                System.out.println();
                System.out.print("请选择(1-5)：");
                char selection=CMUtility.readChar();

                switch (selection){
                    case '1':
                       addNewCustomer();
                        break;
                    case '2':
                        modifyCustomer();
                        break;
                    case '3':
                        deleteCustomer();
                        break;
                    case '4':
                        listAllCustomers();
                        break;
                    case '5': {
                        System.out.print("是否要退出系统，请输入(Y/N):");
                        char confirm = CMUtility.readConfirmSelection();
                        if (confirm == 'Y') {
                            IsFlag = false;
                        }
                    }

                        break;
                }

            }while (true);

        }


    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------\n");
        System.out.print("姓名:");
        String name=CMUtility.readString(10);
        System.out.print("性别:");
        char gender=CMUtility.readChar();
        System.out.print("年龄:");
        int age=CMUtility.readInt();
        System.out.print("电话:");
        String phone=CMUtility.readString(11);
        System.out.print("邮箱:");
        String mail=CMUtility.readString(15);
        Customer customer=new Customer(name,gender,age,phone,mail);
        customerList.addCustomer(customer);
        System.out.println("---------------------添加成功---------------------\n");

    }

    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------\n");


        System.out.print("请输入修改的用户索引"+",索引号(最大为："+(customerList.getTotal()-1)+")");
        int index=CMUtility.readInt();
        System.out.print("姓名:");
        String name=CMUtility.readString(10);
        System.out.print("性别:");
        char gender=CMUtility.readChar();
        System.out.print("年龄:");
        int age=CMUtility.readInt();
        System.out.print("电话:");
        String phone=CMUtility.readString(11);
        System.out.print("邮箱:");
        String mail=CMUtility.readString(15);
        Customer customer=new Customer(name,gender,age,phone,mail);
        customerList.replaceCustomer(index,customer);
        System.out.println(customerList.getCustomer(index));
        System.out.println("---------------------修改成功---------------------\n");

    }
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------\n");

        System.out.print("请输入要删除的索引号(最大为："+(customerList.getTotal()-1)+")");

        int index=CMUtility.readInt();
        System.out.println(customerList.getCustomer(index)+"已删除");
        customerList.deleteCustomer(index);
    }
    private void listAllCustomers(){
        System.out.println("---------------------客户列表---------------------\n");

        Customer[] cust=customerList.getAllCustomers();
        for(Object obj:cust){
            System.out.println(obj);
        }
        System.out.println("--------------------------------------------------\n");

    }


    public static void main(String[] args) {
        CustomerView cusView = new CustomerView();
        cusView.enterMainMenu();
    }

}






