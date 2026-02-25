import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "FIFO vs LIFO Palindrome App";
    private static final String APP_VERSION = "5.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Comparing Queue (FIFO) and Stack (LIFO) behavior.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Shutting down. Goodbye!");
                break;
            }

            if (isPalindrome(userInput)) {
                System.out.println("Result: '" + userInput + "' is a palindrome.");
            } else {
                System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        String cleanStr = str.toLowerCase();

        for (int i = 0; i < cleanStr.length(); i++) {
            char c = cleanStr.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }
}