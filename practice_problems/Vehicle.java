package week9.practice_problems;

public class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;

    // Constructor
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }

    // Getters
    public String getRegistrationNo() { return registrationNo; }
    public String getType() { return type; }
    public double getRatePerDay() { return ratePerDay; }

    // toString override
    @Override
    public String toString() {
        return "Vehicle [registrationNo=" + registrationNo +
                ", type=" + type +
                ", ratePerDay=" + ratePerDay + "]";
    }

    // equals override
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Vehicle v = (Vehicle) obj;
        return registrationNo.equals(v.registrationNo) &&
                type.equals(v.type) &&
                ratePerDay == v.ratePerDay;
    }

    // hashCode override
    @Override
    public int hashCode() {
        return registrationNo.hashCode() + type.hashCode() + Double.valueOf(ratePerDay).hashCode();
    }
}
