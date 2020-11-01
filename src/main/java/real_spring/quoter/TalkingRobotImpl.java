package real_spring.quoter;

import lombok.Data;
import my_spring.iRobot.InjectRandomInt;

import javax.annotation.PostConstruct;
import java.util.List;

@Data
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::seyQuote);
    }
}
