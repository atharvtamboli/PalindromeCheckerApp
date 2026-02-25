import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "PalindromeChecker App";
    private static final String APP_VERSION = "1.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Enter 'exit' at any time to quit the application.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.print("Enter a string to check (or 'exit' to quit): ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting PalindromeChecker App. Goodbye!");
                break;
            }

            if (userInput.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }

            if (isPalindrome(userInput)) {
                System.out.println("'" + userInput + "' is a palindrome.");
            } else {
                System.out.println("'" + userInput + "' is not a palindrome.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        String normalizedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = normalizedStr.length() - 1;

        while (left < right) {
            if (normalizedStr.charAt(left) != normalizedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
