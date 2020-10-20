package findAllFriday13th;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Long> allFriday13th = Friday13th.findAllFriday13th(2000, 2020);
        System.out.println(allFriday13th);
    }
}
