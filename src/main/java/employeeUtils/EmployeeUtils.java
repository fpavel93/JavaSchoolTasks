package employeeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

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
                .collect(toList());
    }

    public static Map<Seniority,List<Employee>> groupBySeniority(List<Employee> employees){
        return employees.stream()
                .collect(groupingBy(employee -> Seniority.findBySalary(employee.getSalary())));
    }

    public static Map<String,Integer> mapNameToSalary(List<Employee> employees){
        return employees.stream()
                .collect(toMap(Employee::getName,Employee::getSalary, Integer::sum));
    }

    public static Map<Integer,List<String>> groupNamesBySalary (List<Employee> employees){
        return employees.stream()
                .collect(groupingBy(Employee::getSalary, mapping(Employee::getName, toList())));
    }
}
