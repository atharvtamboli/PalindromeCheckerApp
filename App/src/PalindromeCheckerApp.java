import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Normalization Palindrome App";
    private static final String APP_VERSION = "9.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Ignoring case, spaces, and special characters.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) break;

            String normalized = normalizeString(userInput);

            if (isPalindrome(normalized)) {
                System.out.println("Result: It is a palindrome.");
            } else {
                System.out.println("Result: It is NOT a palindrome.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static String normalizeString(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}