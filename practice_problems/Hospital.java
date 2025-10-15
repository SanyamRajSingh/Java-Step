package week9.practice_problems;

public class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println(deptName + " department at " + name + " hospital.");
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }
}
