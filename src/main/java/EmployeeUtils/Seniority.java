package EmployeeUtils;

import Enums.enums.MailHttpCodes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Seniority {
    JUNIOR(0,10),
    MIDDLE(11,20),
    SENIOR(21,100);

    private final int min;
    private final int max;

    public static Seniority findBySalary(int salary){
        Seniority[] Seniority = values();
        List<Seniority> collect = Arrays.stream(Seniority)
                .filter(seniority -> (seniority.min <= salary && seniority.max >= salary))
                .collect(Collectors.toList());
        return collect.get(0);
    }
}
