package real_spring.quoter;

import lombok.Data;

import java.util.List;

@Data
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    @Override
    public void talk() {
        quoters.forEach(Quoter::seyQuote);
    }
}
