import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String longInput = "racecar".repeat(1000); // Create a large string for a fair test

        System.out.println("Benchmarking Palindrome Algorithms (Input Size: " + longInput.length() + " chars)");
        System.out.println("--------------------------------------------------");

        benchmark("For-Loop Concatenation", () -> {
            StringBuilder reversed = new StringBuilder();
            for (int i = longInput.length() - 1; i >= 0; i--) {
                reversed.append(longInput.charAt(i));
            }
            return longInput.equalsIgnoreCase(reversed.toString());
        });

        benchmark("StringBuilder Reverse", () -> {
            String reversed = new StringBuilder(longInput).reverse().toString();
            return longInput.equalsIgnoreCase(reversed);
        });

        benchmark("Two-Pointer (Char Array)", () -> {
            char[] chars = longInput.toCharArray();
            int left = 0, right = chars.length - 1;
            while (left < right) {
                if (chars[left++] != chars[right--]) return false;
            }
            return true;
        });

        benchmark("Deque (ArrayDeque)", () -> {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : longInput.toCharArray()) deque.addLast(c);
            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) return false;
            }
            return true;
        });
    }

    private static void benchmark(String name, java.util.function.Supplier<Boolean> algorithm) {
        long startTime = System.nanoTime();
        algorithm.get();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.printf("%-25s : %d ns\n", name, duration);
    }
}