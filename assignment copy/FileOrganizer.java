package week2.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class FileOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> filenames = new ArrayList<>();

        System.out.println("Enter file names (type 'end' to stop):");
        while (true) {
            String fname = sc.nextLine();
            if (fname.equalsIgnoreCase("end")) break;
            filenames.add(fname);
        }

        organizeFiles(filenames);
        sc.close();
    }

    public static void organizeFiles(ArrayList<String> files) {
        int docCount = 0, imgCount = 0, unknownCount = 0;
        for (String file : files) {
            String ext = getFileExtension(file);
            String category = categorizeExtension(ext);
            System.out.printf("%-20s %-15s%n", file, category);
            if (category.equals("Documents")) docCount++;
            else if (category.equals("Images")) imgCount++;
            else unknownCount++;
        }
        System.out.println("\nSummary:");
        System.out.println("Documents: " + docCount);
        System.out.println("Images: " + imgCount);
        System.out.println("Unknown: " + unknownCount);
    }

    public static String getFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot == -1 || dot == filename.length() - 1) return "";
        return filename.substring(dot + 1).toLowerCase();
    }

    public static String categorizeExtension(String ext) {
        return switch (ext) {
            case "txt", "doc", "docx", "pdf" -> "Documents";
            case "jpg", "jpeg", "png", "bmp", "gif" -> "Images";
            case "mp3", "wav", "aac" -> "Audio";
            case "mp4", "avi", "mkv" -> "Video";
            default -> "Unknown";
        };
    }
}
