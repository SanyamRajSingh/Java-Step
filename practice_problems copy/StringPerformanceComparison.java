package week2.practice_problems;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        long start = System.nanoTime();
        String s1 = concatenateWithString(10000);
        long end = System.nanoTime();
        System.out.println("String concatenation time: " + (end - start) + " ns");

        start = System.nanoTime();
        String s2 = concatenateWithStringBuilder(10000);
        end = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (end - start) + " ns");

        start = System.nanoTime();
        String s3 = concatenateWithStringBuffer(10000);
        end = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (end - start) + " ns");

        System.out.println("\nStringBuilder methods demo:");
        demonstrateStringBuilderMethods();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i + " ";
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!!!");
        System.out.println("Append: " + sb);

        sb.insert(5, " Inserted");
        System.out.println("Insert: " + sb);

        sb.delete(5, 15);
        System.out.println("Delete: " + sb);

        sb.deleteCharAt(0);
        System.out.println("Delete Char At: " + sb);

        sb.reverse();
        System.out.println("Reverse: " + sb);

        sb.replace(0, 5, "Repl");
        System.out.println("Replace: " + sb);

        sb.setCharAt(0, 'X');
        System.out.println("Set Char At: " + sb);

        System.out.println("Capacity: " + sb.capacity());

        sb.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity(50): " + sb.capacity());

        sb.trimToSize();
        System.out.println("Capacity after trimToSize(): " + sb.capacity());
    }
}
