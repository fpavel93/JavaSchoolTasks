package design_patterns.iRobot;

import lombok.SneakyThrows;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory(){

    }
    
    @SneakyThrows
    public <T> T createObject(Class<T> type){
        if(type.isInterface()){
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();
        return t;
    }
}
