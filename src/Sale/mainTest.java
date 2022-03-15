package Sale;

public class mainTest {
    public static void main(String[] args) {
        SalesService salesService = new SalesService();
        System.out.println("静态代理内容:");
        staticProxy staticproxy = new staticProxy(salesService);
        staticproxy.sell();
        System.out.println("JDK动态代理内容:");
        jdkProxy jdkproxy = new jdkProxy(salesService);
        SellInterface jdkSale;
        try {
            jdkSale = (SellInterface) jdkproxy.getProxy();
            jdkSale.sell();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("cglib代理内容:");
        cglibProxy cglibproxy = new cglibProxy();
        SalesService cglibSale = (SalesService) cglibproxy.getInstance(salesService);
        cglibSale.sell();
    }
}
