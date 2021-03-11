package com.messge;

/**
 * Description:静态代理举例
 * date:2020-08-16 10:45
 *
 * @Author helaxest  @mail:
 * @Version
 * @Since JDK 1.8
 */

interface ClothFactory{
    void produceCloth();

}

//代理类
class ProxyClothFactory implements ClothFactory{

    private  ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");

    }

}
//被代理类
class NikeClothFactory implements ClothFactory{
    public class staticProxyTest{

    }

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂正在生产一批产品");

    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
//        创建被代理对象
        NikeClothFactory nike=new NikeClothFactory();
//        创建代理类的对象
      ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

      proxyClothFactory.produceCloth();

    }

}