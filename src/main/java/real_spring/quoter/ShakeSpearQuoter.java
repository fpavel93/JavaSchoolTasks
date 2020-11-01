package real_spring.quoter;

import lombok.Data;

@Data
public class ShakeSpearQuoter implements Quoter {
    private String message;

    @Override
    public void seyQuote() {
        System.out.println(message);
    }
}
