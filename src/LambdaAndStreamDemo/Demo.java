package LambdaAndStreamDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    List<Employee> employees = Arrays.asList(
            new Employee("zhangsan", 18, 9999.99),
            new Employee("lisi", 28, 8888.99),
            new Employee("wangwu", 38, 7777.99),
            new Employee("zhaoliu", 48, 6666.99),
            new Employee("biqi", 58, 5555.99),
            new Employee("erba", 68, 4444.99),
            new Employee("hujiu", 78, 3333.99),
            new Employee("bashi", 98, 2222.99)
    );


    public List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> myPredicate) {
        List<Employee> list = new ArrayList<>();

        for (Employee emp : employees) {
            if (myPredicate.test(emp)) list.add(emp);
        }

        return list;
    }

    //策略设计模式
    @Test
    public void testFilterByAge() {
        List<Employee> list = filterEmployee(employees, new FilterByAge());

        for (Employee emp : list
        ) {
            System.out.println(emp);
        }

    }

    @Test
    public void testFilterBySalary() {
        List<Employee> list = filterEmployee(employees, new FilterBySalary());

        for (Employee emp : list
        ) {
            System.out.println(emp);
        }

    }


    //匿名内部类
    @Test
    public void testAnonymousInnerClass() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {

            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 40;
            }
        });
        for (Employee emp : list
        ) {
            System.out.println(emp);
        }
    }


    //Lambda
    @Test
    public void testLambda() {
        List<Employee> list = filterEmployee(employees,(employee) -> employee.getSalary() < 6000);
        list.forEach(System.out::println);
    }

    //Stream
    @Test
    public void testStream(){
        employees.stream()
                .filter(employee -> employee.getSalary()>5000)
                .forEach(System.out::println);
    }

}
