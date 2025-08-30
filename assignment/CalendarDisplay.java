package week1.assignment;

import java.util.Scanner;

public class CalendarDisplay {
    static String[] months = new String[]{"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        if (month == 2 && isLeapYear(year)) {
            days[2] = 29;
        }

        int d = dayOfWeek(1, month, year);
        String var10001 = months[month];
        System.out.println("\n" + var10001 + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for(int i = 0; i < d; ++i) {
            System.out.print("    ");
        }

        for(int i = 1; i <= days[month]; ++i) {
            System.out.printf("%3d ", i);
            if ((i + d) % 7 == 0 || i == days[month]) {
                System.out.println();
            }
        }

        sc.close();
    }

    public static int dayOfWeek(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }
}