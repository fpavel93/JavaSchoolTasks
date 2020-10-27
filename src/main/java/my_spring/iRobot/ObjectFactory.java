package my_spring.iRobot;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    private Reflections scanner = new Reflections("my_spring.iRobot");
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : classes) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
        Set<Class<? extends ProxyConfigurator>> set = scanner.getSubTypesOf(ProxyConfigurator.class);
        for (Class<? extends ProxyConfigurator> aClass : set) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);
        T t = create(type);
        configure(t);
        invokeInit(t);
        t = wrapWithProxyIfNeeded(type, t);
        //Enhancer
        return t;
    }

    private <T> T wrapWithProxyIfNeeded(Class<T> type, T t) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            t = (T) proxyConfigurator.wrapWithProxy(t, type);
        }
        return t;
    }

    @SneakyThrows
    private <T> void invokeInit(T t) {
        Class<?> type = t.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if(method.getName().equals("init")){
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configurator -> configurator.configure(t));
    }

    @SneakyThrows
    private <T> T create(Class<T> type) {
        T t = type.getDeclaredConstructor().newInstance();
        return t;
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if(implClass == null){
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if(classes.size() != 1){
                    throw new RuntimeException("0 or more than one impl of "+type+" was found please update your config");
                }
                type = (Class<T>) classes.iterator().next();
            }
            else {
                type = implClass;
            }
        }
        return type;
    }
}
