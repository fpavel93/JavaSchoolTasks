package my_spring.iRobot;

import design_patterns.heroesGame.RandomUtil;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type, field -> field.isAnnotationPresent(InjectByType.class));
        for (Field field : fields) {
            Class<? extends Field> aClass = field.getClass();
            field.setAccessible(true);
            field.set(t, ObjectFactory.getInstance().createObject(aClass));
        }
    }
}
