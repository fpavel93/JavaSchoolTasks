package real_spring.quoter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(ShakeSpearQuoter.class).seyQuote();
        context.getBean(TerminatorQuoter.class).seyQuote();
    }
}
