package LambdaAndStreamDemo;

public class Employee {
    private String Name;
    private int Age;
    private double Salary;

    public Employee(String name, int age, double salary) {
        Name = name;
        Age = age;
        Salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Salary=" + Salary +
                '}';
    }
}
