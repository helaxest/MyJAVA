package com.messge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:反射的应用动态代理
 * date:2020-08-16 11:00
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */

interface Human{

    String getBelief();
    void eat(String food);

}
class SuperMan implements Human{


    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }


}
/*
    问题：1.如何根据加载到内存中被代理的类，动态的创建一个代理类
    问题：2.当通过代理类的对象调用方法时，如何动态的去调用被代理类中同名方法

 */
class ProxyFactory{
//    调用此方法，返回一个代理类的对象，解决问题一
    public static Object getProxyInstance(Object obj){//obj :被代理的对象
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), handler);

    }
}
class MyInvocationHandler implements InvocationHandler{
    private  Object obj;//需要被代理类的对象赋值
    public void bind(Object obj){
        this.obj=obj;
    }

//      当我们通过代理类的对象，调用方法a时，就会自动调用如下方法：invoke()
//    将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method 即为代理类对象调用的方法，此方法也就作为了被代理对象要调用的方法
        //obj ：被代理的对象
        Object returnVal=method.invoke(obj,args);
        //上述方法的返回值就作为当前类中invoke()的返回值
        return returnVal;
    }
}



public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan=new SuperMan();
//        proxyInstance:为代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
//        当通过代理类对象调用方法时，会自动调用被代理类的同名方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("四川麻辣烫");
        System.out.println("***********************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();

    }
}
