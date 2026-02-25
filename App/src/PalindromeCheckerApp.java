import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Loop Explorer";
    private static final String APP_VERSION = "2.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("This version uses String Concatenation logic.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting. Goodbye!");
                break;
            }

            String reversed = reverseString(userInput);

            System.out.println("Original: " + userInput);
            System.out.println("Reversed: " + reversed);

            if (userInput.equalsIgnoreCase(reversed)) {
                System.out.println("Result: It is a palindrome!");
            } else {
                System.out.println("Result: It is NOT a palindrome.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        return reversed;
    }
}