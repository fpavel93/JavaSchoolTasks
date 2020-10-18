package EmployeeUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class EmployeeUtilsTest {

    @Test
    public void salariesSum() {
        List<Employee> list = asList(new Employee(),new Employee(),new Employee());
        list.get(0).setSalary(10);
        list.get(1).setSalary(20);
        list.get(2).setSalary(30);

        int sum = EmployeeUtils.salariesSum(list);
        Assert.assertEquals(60,sum);
    }
}