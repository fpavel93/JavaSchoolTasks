package real_spring.quoter;

import my_spring.iRobot.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;

@Book
public class ShakeSpearQuoter implements Quoter {
    @InjectRandomInt(min = 3,max = 5)
    private int repeat;
    @Value("${shake}")
    private String message;

    @Override
    public void seyQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
