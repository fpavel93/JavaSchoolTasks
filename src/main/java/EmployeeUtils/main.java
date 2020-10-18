package EmployeeUtils;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class main {
    public static void main(String[] args) {
        List<Employee> list = asList(new Employee(),new Employee());
        list.get(0).setSalary(50);
        list.get(1).setSalary(30);
        int sum = EmployeeUtils.salariesSum(list);
        System.out.println(sum);
    }
}
