package real_spring.quoter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Book
    private List<Quoter> quoters;

    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::seyQuote);
    }
}
