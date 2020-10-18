package EmployeeUtils;

import java.util.List;
import java.util.stream.IntStream;

public class EmployeeUtils {
    public static int salariesSum(List<Employee> list)
    {
        IntStream stream = list.stream().mapToInt(x->(x.salary));
        return stream.sum();
    }
}
