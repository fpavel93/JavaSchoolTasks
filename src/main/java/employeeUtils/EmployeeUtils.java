package employeeUtils;

import java.util.List;
import java.util.Map;

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
}
