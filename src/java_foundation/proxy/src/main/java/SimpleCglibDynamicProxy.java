import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SimpleCglibDynamicProxy {
    static class RealService {
        public void sayHello() {
            System.out.println("Hello");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("entering" + method.getName());
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("leaving" + method.getName());
            return result;
        }
    }

    private static<T> T getProxy(Class<T> tClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(new SimpleInterceptor());

        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService proxy = getProxy(RealService.class);
        proxy.sayHello();
    }
}
