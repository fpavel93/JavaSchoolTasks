package my_spring.iRobot;

import net.sf.cglib.proxy.Enhancer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {

    private BenchmarkToggle benchmarkToggle = new BenchmarkToggle();

    @Override
    public <T> Object wrapWithProxy(Object t, Class<T> type) {
        if(type.isAnnotationPresent(Benchmark.class)|| Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class))){
            if(type.getInterfaces().length == 0){
                return Enhancer.create(type, new net.sf.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return getInvocationHandlerLogoc(method, args, (Class<T>) type, t);
                    }
                });
            }
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return getInvocationHandlerLogoc(method, args, type, t);
                }
            });
        }
        return t;
    }

    private <T> Object getInvocationHandlerLogoc(Method method, Object[] args, Class<T> type, Object t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (benchmarkToggle.isEnabled()&&(type.isAnnotationPresent(Benchmark.class) || classMethod.isAnnotationPresent(Benchmark.class))) {
            System.out.println("*****BENCHMARK from method " + method.getName() + " started");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("*****BENCHMARK from method " + method.getName() + " finished");
            return retVal;
        } else {
            return method.invoke(t, args);
        }
    }
}
