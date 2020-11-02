package real_spring.bpp;

import my_spring.iRobot.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InjectRandomIntAnnotationBeanPostProcessor extends InjectRandomIntAnnotationObjectConfigurator implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        configure(bean);
        return bean;
    }
}
