package mostPopularWordInText;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class textUtils {
    public static String mostPopularWordInText(String text){
        Optional<Map.Entry<String, Long>> max = Stream.of(text.split("\\W+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        if(max.isEmpty()){
            return "";
        }
        return max.get().getKey();
    }
}
