package week9.practice_problems;

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital h = new Hospital("SRM Hospital");
        Hospital.Department d1 = h.createDepartment("Cardiology");
        Hospital.Department d2 = h.createDepartment("Neurology");
        d1.displayInfo();
        d2.displayInfo();
    }
}
