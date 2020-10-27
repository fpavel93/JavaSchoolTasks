package my_spring.iRobot;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> Object wrapWithProxy(Object t, Class<T> type) {
        if(type.isAnnotationPresent(Benchmark.class)){
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("*****BENCHMARK from method "+method.getName()+" started");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end-start);
                    System.out.println("*****BENCHMARK from method "+method.getName()+" finished");
                    return retVal;
                }
            });
        }
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Benchmark.class)){
                return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object retVal;
                        String name = method.getName();
                        if(type.getMethod(name).isAnnotationPresent(Benchmark.class)) {
                            System.out.println("*****BENCHMARK from method " + method.getName() + " started");
                            long start = System.nanoTime();
                            retVal = method.invoke(t, args);
                            long end = System.nanoTime();
                            System.out.println(end - start);
                            System.out.println("*****BENCHMARK from method " + method.getName() + " finished");
                        }
                        else {
                            retVal = method.invoke(t, args);
                        }
                        return retVal;
                    }
                });
            }
        }
        return t;
    }
}
