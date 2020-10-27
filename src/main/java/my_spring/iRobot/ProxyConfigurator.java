package my_spring.iRobot;

public interface ProxyConfigurator {
    <T> Object wrapWithProxy(Object t,Class<T> type);
}
