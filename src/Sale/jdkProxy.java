package Sale;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class jdkProxy implements InvocationHandler {
    private Object target;

    public jdkProxy(Object o) {
        super();
        this.target = o;
    }

    public Object getProxy() throws Throwable{
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("Providing pre-sales service,售前服务");
        result=method.invoke(target,args);
        System.out.println("Providing after-sales services,售后服务");
        return result;
    }
}
