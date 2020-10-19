package EmployeeUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class EmployeeUtils {
    public static int salariesSum(List<Employee> employees)
    {
        return employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public static List<String> getNames(List<Employee> employees)
    {
        return employees.stream()
                .map(Employee::getName)
                .sorted(comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static void groupBySeniority(List<Employee> employees){
        Map<Seniority, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(employee -> (Seniority.findBySalary(employee.getSalary()))));
        System.out.println(map);
    }
}
