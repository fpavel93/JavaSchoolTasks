package forEachWithDelay;

import java.util.List;

import static java.util.Arrays.asList;

public class main {
    public static void main(String[] args) {
        List<Integer> list = asList(1, 2, 3);
        ForEachWithDelay.forEachWithDelay(list, 1000, x -> System.out.println(x));
    }
}
