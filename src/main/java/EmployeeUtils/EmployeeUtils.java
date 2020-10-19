package EmployeeUtils;

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

    public static Map<Seniority,List<Employee>> groupBySeniority(List<Employee> employees){
        return employees.stream()
                .collect(Collectors.groupingBy(employee -> Seniority.findBySalary(employee.getSalary())));
    }
}
