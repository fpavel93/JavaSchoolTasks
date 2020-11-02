package real_spring.quoter;

import lombok.Data;

import javax.annotation.PreDestroy;
import java.util.List;

@Data
@DeprecatedClass(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

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
