package week8.practice_problem;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public void displayDetails() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.20;
    }
}

class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee m = new Manager("Alice", 50000);
        m.displayDetails();
        System.out.println("Bonus: " + m.calculateBonus());

        Employee d = new Developer("Bob", 40000);
        d.displayDetails();
        System.out.println("Bonus: " + d.calculateBonus());
    }
}
