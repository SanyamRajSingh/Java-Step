package week8.labs;

abstract class Employee {
    protected String name;
    protected double salary;

    protected Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public String basicInfo() {
        return "Name: " + name + ", Salary: " + salary;
    }
}

interface Payable {
    String generatePaySlip();
}

class Manager extends Employee implements Payable {
    private final double bonusRate; // e.g., 0.15 = 15%

    public Manager(String name, double salary, double bonusRate) {
        super(name, salary);
        this.bonusRate = bonusRate;
    }

    @Override
    public double calculateBonus() {
        return salary * bonusRate;
    }

    @Override
    public String generatePaySlip() {
        double bonus = calculateBonus();
        double gross = salary + bonus;
        return "PaySlip -> " + basicInfo() + ", Bonus: " + String.format("%.2f", bonus)
                + ", Gross: " + String.format("%.2f", gross);
    }
}

public class Lab4Demo {
    public static void main(String[] args) {
        Manager m = new Manager("Anika", 90000, 0.20);
        System.out.println(m.generatePaySlip());
    }
}
