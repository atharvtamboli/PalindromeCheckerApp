import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Recursive Palindrome Validator";
    private static final String APP_VERSION = "8.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Using the Call Stack to validate palindromes.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) break;

            String cleanInput = userInput.toLowerCase().replaceAll("[^a-z0-9]", "");

            if (isPalindrome(cleanInput, 0, cleanInput.length() - 1)) {
                System.out.println("Result: '" + userInput + "' is a palindrome.");
            } else {
                System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static boolean isPalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}