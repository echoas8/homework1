package Sale;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class cglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object o) {
        this.target = o;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Providing pre-sales service,售前服务");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("Providing after-sales services,售后服务");
        return result;
    }
}
