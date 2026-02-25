import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Stack-Based Palindrome Validator";
    private static final String APP_VERSION = "4.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Using LIFO logic to validate palindromes.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Stack App. Goodbye!");
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
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return str.equalsIgnoreCase(reversed.toString());
    }
}