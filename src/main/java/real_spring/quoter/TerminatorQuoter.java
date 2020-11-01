package real_spring.quoter;

import lombok.Data;

import java.util.List;

@Data
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    @Override
    public void seyQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
