package week7.assignments;

class MedicalStaff {
    protected String name;
    protected int id;

    public MedicalStaff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void scheduleShift() {
        System.out.println("Scheduling shift for " + name);
    }

    public void accessIDCard() {
        System.out.println(name + " using ID card " + id);
    }

    public void processPayroll() {
        System.out.println("Processing payroll for " + name);
    }
}

class Doctor extends MedicalStaff {
    public Doctor(String name, int id) {
        super(name, id);
    }

    public void diagnose() {
        System.out.println(name + " diagnosing a patient");
    }

    public void prescribeMedicine() {
        System.out.println(name + " prescribing medicine");
    }

    public void performSurgery() {
        System.out.println(name + " performing surgery");
    }
}

class Nurse extends MedicalStaff {
    public Nurse(String name, int id) {
        super(name, id);
    }

    public void administerMedicine() {
        System.out.println(name + " administering medicine");
    }

    public void monitorPatients() {
        System.out.println(name + " monitoring patients");
    }

    public void assistProcedures() {
        System.out.println(name + " assisting procedures");
    }
}

class Technician extends MedicalStaff {
    public Technician(String name, int id) {
        super(name, id);
    }

    public void operateEquipment() {
        System.out.println(name + " operating equipment");
    }

    public void runTests() {
        System.out.println(name + " running tests");
    }

    public void maintainInstruments() {
        System.out.println(name + " maintaining instruments");
    }
}

class Administrator extends MedicalStaff {
    public Administrator(String name, int id) {
        super(name, id);
    }

    public void scheduleAppointments() {
        System.out.println(name + " scheduling appointments");
    }

    public void manageRecords() {
        System.out.println(name + " managing records");
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        MedicalStaff[] staff = {
                new Doctor("Dr. Smith", 101),
                new Nurse("Nurse Amy", 102),
                new Technician("Tech Mike", 103),
                new Administrator("Admin Jane", 104)
        };

        for (MedicalStaff ms : staff) {
            ms.scheduleShift();
            ms.accessIDCard();
            ms.processPayroll();

            // Specialized behavior via downcasting
            if (ms instanceof Doctor) {
                ((Doctor) ms).diagnose();
                ((Doctor) ms).prescribeMedicine();
                ((Doctor) ms).performSurgery();
            } else if (ms instanceof Nurse) {
                ((Nurse) ms).administerMedicine();
                ((Nurse) ms).monitorPatients();
                ((Nurse) ms).assistProcedures();
            } else if (ms instanceof Technician) {
                ((Technician) ms).operateEquipment();
                ((Technician) ms).runTests();
                ((Technician) ms).maintainInstruments();
            } else if (ms instanceof Administrator) {
                ((Administrator) ms).scheduleAppointments();
                ((Administrator) ms).manageRecords();
            }

            System.out.println();
        }
    }
}
