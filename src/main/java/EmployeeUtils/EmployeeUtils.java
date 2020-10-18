package EmployeeUtils;

import java.util.List;

public class EmployeeUtils {
    public static int salariesSum(List<Employee> list)
    {
        return list.stream().mapToInt(Employee::getSalary).sum();
    }
}
