package findAllFriday13th;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toMap;


public class Friday13th {
    public static Map<Integer, Long> findAllFriday13th(int start, int end) {
        LocalDate startDate = LocalDate.of(start, 1, 13);
        LocalDate endDate = LocalDate.of(end,12,14);
        return Stream.iterate(startDate,localDate -> localDate.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(startDate,endDate))
                .filter(localDate -> localDate.getDayOfWeek()==(DayOfWeek.FRIDAY))
                .collect(Collectors.groupingBy(LocalDate::getYear,counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> (int) (o2.getValue()-o1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
