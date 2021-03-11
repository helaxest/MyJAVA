package com.Project2;

/**
 * Description:
 * date:2020-08-17 11:26
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */
//    Customer[] customers：用来保存客户对象的数组
//    int total = 0                 ：记录已保存客户对象的数量


public class CustomerList {
    int total = 0;//记录已保存客户对象的数量
    Customer[] customers;//声明数组

    public CustomerList() {
    }

    public CustomerList(Customer[] customers) {
        this.customers = customers;
    }


    public CustomerList(int totalCustomer){//初始化数组
//        Customer[] customers=new Customer[totalCustomer];  错误写法
         customers=new Customer[totalCustomer];

    }
    public boolean addCustomer(Customer customer){//添加用户到数组
        if(total<customers.length) {
            customers[total] = customer;
            total++;
            return true;
        }
        return false;
    }

    public boolean replaceCustomer(int index, Customer cust){//修改数组指定位置上的用户
        if(index<0||index>total){
            return false;
        }else
        {
            customers[index]=cust;
            return true;
        }



    }
    public boolean deleteCustomer(int index) {//删除数组指定位置的用户
        if (index < 0 || index >=total) {//数组越界异常
            return false;
        }
        else  {//index在[0,total]之间 ,包括total=0

            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[--total] = null;//①total减1  ②最后一个元素要赋值为null
            return true;
            }


    }
    public Customer[] getAllCustomers(){//遍历用户数组
//        int i;
//        for ( i = 0; i <total ; i++) {
//            System.out.println(customers[i]);
//
//        }
//        return new Customer[]{customers[i]};
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }
    public Customer getCustomer(int index){//查询数组指定位置的用户

//        System.out.println(customers[index]);
        return customers[index];
    }
    public int getTotal(){//当前存了多少数组
            return total;
    }




}
