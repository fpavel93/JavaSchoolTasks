package employeeUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class EmployeeUtilsTest {

    @Test
    public void salariesSum() {
        List<Employee> list = asList(
                Employee.builder().salary(10).build(),
                Employee.builder().salary(20).build(),
                Employee.builder().salary(30).build());

        int sum = EmployeeUtils.salariesSum(list);
        Assert.assertEquals(60,sum);
    }

    @Test
    public void groupBySeniority() {
        List<Employee> list = asList(
                Employee.builder().salary(10).build(),
                Employee.builder().salary(20).build(),
                Employee.builder().salary(30).build(),
                Employee.builder().salary(5).build(),
                Employee.builder().salary(15).build(),
                Employee.builder().salary(25).build());

        Map<Seniority, List<Employee>> map = EmployeeUtils.groupBySeniority(list);
        System.out.println(map);
    }

    @Test
    public void mapNameToSalary() {
        List<Employee> list = asList(
                Employee.builder().name("A").salary(10).build(),
                Employee.builder().name("B").salary(20).build(),
                Employee.builder().name("A").salary(30).build());

        Map<String, Integer> map = EmployeeUtils.mapNameToSalary(list);
        System.out.println(map);
    }

    @Test
    public void groupNamesBySalary() {
        List<Employee> list = asList(
                Employee.builder().name("A").salary(10).build(),
                Employee.builder().name("B").salary(20).build(),
                Employee.builder().name("C").salary(30).build(),
                Employee.builder().name("D").salary(20).build(),
                Employee.builder().name("E").salary(10).build(),
                Employee.builder().name("F").salary(10).build());

        Map<Integer,List<String>> map = EmployeeUtils.groupNamesBySalary(list);
        System.out.println(map);
    }
}