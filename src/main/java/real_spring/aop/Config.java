package real_spring.aop;

import org.springframework.context.annotation.*;
import real_spring.aop.business.DBException;
import real_spring.aop.business.SomeService;

@Configuration
@ComponentScan
@ImportResource("classpath:aop.xml")
@PropertySource("classpath:mail.properties")
@EnableAspectJAutoProxy
public class Config {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SomeService someService = context.getBean(SomeService.class);

        try {
            someService.work();
        } catch (Exception e){
            System.out.println("There is a problem!");
        }

    }
}
