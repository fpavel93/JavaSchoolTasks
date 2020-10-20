package findAllFriday13th;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;


public class Friday13th {
    public static Map<Integer, Long> findAllFriday13th(Integer year1, Integer year2) {
        return IntStream.range(year1, year2)
                .boxed()
                .collect(toMap(Function.identity(), year -> IntStream.range(1, LocalDate.of((Integer) year, 12, 31).getDayOfYear())
                        .mapToObj(day -> LocalDate.ofYearDay((Integer) year, day))
                        .filter(localDate -> localDate.getDayOfMonth() == 13)
                        .filter(localDate -> localDate.getDayOfWeek() == DayOfWeek.FRIDAY)
                        .count()));
    }
}
