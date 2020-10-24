package my_spring.iRobot;

public interface Config {
    public <T> Class getImplClass(Class<T> type);
}
