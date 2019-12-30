package LambdaAndStreamDemo;

public class FilterBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() < 5000;
    }
}
