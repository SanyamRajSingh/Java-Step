package week7.assignments;

public class HotelBooking {
    // Standard booking: room type and nights
    public void calculatePrice(String roomType, int nights) {
        double pricePerNight = getRoomPrice(roomType);
        double total = pricePerNight * nights;
        System.out.println("Standard Booking:\nRoom: " + roomType + "\nNights: " + nights + "\nPrice per night: " + pricePerNight + "\nTotal: " + total);
    }

    // Seasonal booking: with multiplier
    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double pricePerNight = getRoomPrice(roomType);
        double total = pricePerNight * nights * seasonalMultiplier;
        System.out.println("Seasonal Booking:\nRoom: " + roomType + "\nNights: " + nights + "\nSeasonal Multiplier: " + seasonalMultiplier + "\nTotal: " + total);
    }

    // Corporate booking: discount and meal package
    public void calculatePrice(String roomType, int nights, double corporateDiscount, boolean mealPackage) {
        double pricePerNight = getRoomPrice(roomType);
        double baseTotal = pricePerNight * nights;
        double discountAmount = baseTotal * corporateDiscount;
        double mealCost = mealPackage ? 20 * nights : 0;
        double total = baseTotal - discountAmount + mealCost;
        System.out.println("Corporate Booking:\nRoom: " + roomType + "\nNights: " + nights + "\nCorporate discount: " + (corporateDiscount*100) + "%\nMeal package: " + (mealPackage ? "Included" : "Not included") + "\nTotal: " + total);
    }

    // Wedding package: guest count, decoration fee, catering options
    public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, double cateringCost) {
        double pricePerNight = getRoomPrice(roomType);
        double baseTotal = pricePerNight * nights;
        double guestCharge = guestCount * 15; // per guest entrance fee
        double total = baseTotal + guestCharge + decorationFee + cateringCost;
        System.out.println("Wedding Package:\nRoom: " + roomType + "\nNights: " + nights + "\nGuest count: " + guestCount + "\nDecoration fee: " + decorationFee + "\nCatering cost: " + cateringCost + "\nTotal: " + total);
    }

    // Helper to get base price of room type
    private double getRoomPrice(String roomType) {
        switch (roomType.toLowerCase()) {
            case "single": return 50;
            case "double": return 90;
            case "suite": return 150;
            default: return 70;
        }
    }

    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();

        booking.calculatePrice("Single", 3);
        booking.calculatePrice("Double", 4, 1.2);
        booking.calculatePrice("Suite", 5, 0.15, true);
        booking.calculatePrice("Suite", 2, 100, 500, 2000);
    }
}
