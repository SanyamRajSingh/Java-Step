package week9.assignment;

class University {
    private String uniName;
    University(String name) { this.uniName = name; }

    class Department {
        String deptName;
        Department(String deptName) { this.deptName = deptName; }
        void showDetails() {
            System.out.println(deptName + " of " + uniName);
        }
    }

    static class ExamCell {
        static void showExamDetails() {
            System.out.println("Exam operations performed.");
        }
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University u = new University("SRM");
        University.Department dep = u.new Department("CSE");
        dep.showDetails();

        University.ExamCell.showExamDetails();
    }
}
