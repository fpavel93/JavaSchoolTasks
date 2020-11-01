package real_spring.quoter;

import lombok.Data;
import my_spring.iRobot.InjectRandomInt;

@Data
public class ShakeSpearQuoter implements Quoter {
    @InjectRandomInt(min = 3,max = 5)
    private int repeat;
    private String message;

    @Override
    public void seyQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
