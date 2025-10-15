package week9.practice_problems;

public class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Employee e = (Employee) obj;
        return empCode.equals(e.empCode);
    }

    @Override
    public int hashCode() {
        return empCode.hashCode();
    }

    @Override
    public String toString() {
        return "Employee [empCode=" + empCode + ", name=" + name + "]";
    }
}
