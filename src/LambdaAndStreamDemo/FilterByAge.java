package LambdaAndStreamDemo;

public class FilterByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 40;
    }
}
