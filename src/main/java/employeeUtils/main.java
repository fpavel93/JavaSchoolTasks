package employeeUtils;

import java.util.List;

import static java.util.Arrays.asList;

public class main {
    public static void main(String[] args) {
        List<Employee> list = asList(
                Employee.builder().salary(50).build(),
                Employee.builder().salary(30).build());
        int sum = EmployeeUtils.salariesSum(list);
        System.out.println(sum);
    }
}
