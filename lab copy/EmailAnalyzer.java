package week2.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmailAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> emails = new ArrayList<>();

        System.out.println("Enter emails (type 'stop' to end):");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("stop")) break;
            emails.add(email);
        }

        analyzeEmails(emails);
        sc.close();
    }

    public static void analyzeEmails(ArrayList<String> emails) {
        int validCount = 0, invalidCount = 0;
        HashMap<String, Integer> domainCounts = new HashMap<>();
        int totalUsernameLength = 0;

        System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s%n",
                "Email", "Username", "Domain", "Domain Name", "Ext", "Valid");
        for (String email : emails) {
            boolean valid = isValidEmail(email);
            String username = extractUsername(email);
            String domain = extractDomain(email);
            String domainName = "";
            String extension = "";

            if (!domain.isEmpty() && domain.contains(".")) {
                int dotPos = domain.lastIndexOf('.');
                domainName = domain.substring(0, dotPos);
                extension = domain.substring(dotPos + 1);
            }

            if (valid) {
                validCount++;
                totalUsernameLength += username.length();
                domainCounts.put(domain, domainCounts.getOrDefault(domain, 0) + 1);
            } else invalidCount++;

            System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s%n",
                    email, username, domain, domainName, extension, valid ? "Yes" : "No");
        }

        System.out.println("\nTotal valid emails: " + validCount);
        System.out.println("Total invalid emails: " + invalidCount);

        String commonDomain = domainCounts.entrySet().stream()
                .max((a, b) -> a.getValue() - b.getValue())
                .map(e -> e.getKey())
                .orElse("N/A");
        System.out.println("Most common domain: " + commonDomain);

        double avgUsernameLen = validCount > 0 ? (double) totalUsernameLength / validCount : 0;
        System.out.printf("Average username length: %.2f%n", avgUsernameLen);
    }

    public static boolean isValidEmail(String email) {
        int atPos = email.indexOf('@');
        int lastAtPos = email.lastIndexOf('@');
        if (atPos == -1 || atPos != lastAtPos) return false;
        String username = email.substring(0, atPos);
        String domain = email.substring(atPos + 1);
        if (username.isEmpty() || domain.isEmpty()) return false;
        if (!domain.contains(".")) return false;
        return true;
    }

    public static String extractUsername(String email) {
        int atPos = email.indexOf('@');
        return (atPos != -1) ? email.substring(0, atPos) : "";
    }

    public static String extractDomain(String email) {
        int atPos = email.indexOf('@');
        return (atPos != -1) ? email.substring(atPos + 1) : "";
    }
}
