package EmployeeUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Seniority {
    JUNIOR(0,10),
    MIDDLE(11,20),
    SENIOR(21,Integer.MAX_VALUE);

    private final int min;
    private final int max;

    public static Seniority findBySalary(int salary){
        return Arrays.stream(values())
                .filter(seniority -> seniority.min <= salary)
                .filter(seniority -> seniority.max >= salary)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Salary cannot be negative"));
    }
}
