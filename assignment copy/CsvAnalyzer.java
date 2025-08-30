package week2.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class CsvAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV data (type 'end' to finish):");

        ArrayList<String> lines = new ArrayList<>();
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("end")) break;
            lines.add(line);
        }

        String[][] data = parseCsv(lines);
        printTable(data);

        sc.close();
    }

    public static String[][] parseCsv(ArrayList<String> lines) {
        String[][] data = new String[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            data[i] = parseCsvLine(lines.get(i));
        }
        return data;
    }

    public static String[] parseCsvLine(String line) {
        ArrayList<String> fields = new ArrayList<>();
        int start = 0;
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') inQuotes = !inQuotes;
            else if (c == ',' && !inQuotes) {
                fields.add(line.substring(start, i).replace("\"", "").trim());
                start = i + 1;
            }
        }
        fields.add(line.substring(start).replace("\"", "").trim());
        return fields.toArray(new String[0]);
    }

    public static void printTable(String[][] data) {
        for (String[] row : data) {
            for (String field : row) {
                System.out.print(field + "\t");
            }
            System.out.println();
        }
    }
}
