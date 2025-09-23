package week6.practice_problems;

import java.util.Date;

class Employee {
    protected String employeeId;
    protected String name;
    protected double baseSalary;
    protected String department;
    protected Date joiningDate;

    public Employee(String employeeId, String name, double baseSalary, String department, Date joiningDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department;
        this.joiningDate = joiningDate;
        System.out.println("Employee " + name + " created in " + department);
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public String getJobDescription() {
        return "General Employee";
    }

    public void performWork() {
        System.out.println("Employee is working");
    }

    public void attendMeeting() {
        System.out.println("Employee attending meeting");
    }

    public final String getEmployeeId() {
        return employeeId;
    }

    public final void printEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Joining Date: " + joiningDate);
    }

    public void takeBreak() {
        System.out.println(name + " is taking a break");
    }

    public void clockIn() {
        System.out.println(name + " clocked in");
    }

    public void clockOut() {
        System.out.println(name + " clocked out");
    }
}

class Developer extends Employee {
    private String[] programmingLanguages;
    private String experienceLevel;
    private int projectsCompleted;

    public Developer(String employeeId, String name, double baseSalary, String department, Date joiningDate,
                     String[] programmingLanguages, String experienceLevel, int projectsCompleted) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.programmingLanguages = programmingLanguages;
        this.experienceLevel = experienceLevel;
        this.projectsCompleted = projectsCompleted;
        System.out.println("Developer profile created");
    }

    @Override
    public double calculateSalary() {
        double bonus = 1000 * projectsCompleted;
        if (experienceLevel.equalsIgnoreCase("Senior")) {
            bonus += 5000;
        } else if (experienceLevel.equalsIgnoreCase("Mid")) {
            bonus += 2000;
        }
        return baseSalary + bonus;
    }

    @Override
    public String getJobDescription() {
        return "Software Developer";
    }

    @Override
    public void performWork() {
        System.out.println("Developer is coding and debugging");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Developer in technical meeting");
    }

    public void writeCode(String language) {
        System.out.println("Writing code in " + language);
    }

    public void reviewCode() {
        System.out.println("Reviewing team's code");
    }

    public void deployApplication() {
        System.out.println("Deploying application to production");
    }
}

class Manager extends Employee {
    private int teamSize;
    private String managementLevel;
    private double budgetResponsibility;

    public Manager(String employeeId, String name, double baseSalary, String department, Date joiningDate,
                   int teamSize, String managementLevel, double budgetResponsibility) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.teamSize = teamSize;
        this.managementLevel = managementLevel;
        this.budgetResponsibility = budgetResponsibility;
        System.out.println("Manager profile created");
    }

    @Override
    public double calculateSalary() {
        double bonus = teamSize * 500;
        if (managementLevel.equalsIgnoreCase("Director")) {
            bonus += 8000;
        } else if (managementLevel.equalsIgnoreCase("Manager")) {
            bonus += 4000;
        }
        return baseSalary + bonus + budgetResponsibility * 0.01;
    }

    @Override
    public String getJobDescription() {
        return "Team Manager";
    }

    @Override
    public void performWork() {
        System.out.println("Manager is coordinating team activities");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Manager leading strategic meeting");
    }

    public void conductPerformanceReview() {
        System.out.println("Conducting team performance review");
    }

    public void assignTasks() {
        System.out.println("Assigning tasks to team members");
    }

    public void manageBudget() {
        System.out.println("Managing department budget");
    }
}

class Intern extends Employee {
    private String university;
    private int internshipDuration;
    private String mentor;
    private boolean isFullTime;

    public Intern(String employeeId, String name, double baseSalary, String department, Date joiningDate,
                  String university, int internshipDuration, String mentor, boolean isFullTime) {
        super(employeeId, name, baseSalary, department, joiningDate);
        this.university = university;
        this.internshipDuration = internshipDuration;
        this.mentor = mentor;
        this.isFullTime = isFullTime;
        System.out.println("Intern onboarded");
    }

    @Override
    public double calculateSalary() {
        return 1000; // Fixed stipend
    }

    @Override
    public String getJobDescription() {
        return "Intern";
    }

    @Override
    public void performWork() {
        System.out.println("Intern is learning and assisting");
    }

    public void attendTraining() {
        System.out.println("Intern attending training session");
    }

    public void submitReport() {
        System.out.println("Submitting weekly progress report");
    }

    public void seekMentorship() {
        System.out.println("Getting guidance from mentor");
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new Developer("D001", "Alice", 70000, "Development", new Date(), new String[]{"Java", "Python"}, "Senior", 5);
        employees[1] = new Manager("M001", "Bob", 90000, "Management", new Date(), 10, "Manager", 50000);
        employees[2] = new Intern("I001", "Charlie", 0, "Development", new Date(), "State University", 12, "D001", true);
        employees[3] = new Employee("E001", "Diana", 60000, "Support", new Date());

        for (Employee emp : employees) {
            emp.printEmployeeDetails();
            System.out.println("Job: " + emp.getJobDescription());
            emp.performWork();
            System.out.println("Salary: " + emp.calculateSalary());
            emp.attendMeeting();
            System.out.println();
        }
    }
}
