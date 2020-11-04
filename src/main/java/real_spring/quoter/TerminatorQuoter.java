package real_spring.quoter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Film
//@DeprecatedClass(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }

    @Override
    public void seyQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    @PreDestroy
    public void killAll(){
        System.out.println("Everybody is dead!");
    }
}
