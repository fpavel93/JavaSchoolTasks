package design_patterns.iRobot;

public interface Config {
    public <T> Class getImplClass(Class<T> type);
}
