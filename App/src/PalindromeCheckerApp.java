import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Array Pro";
    private static final String APP_VERSION = "3.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Efficiently checking palindromes using char[] pointers.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("System shutdown. Goodbye!");
                break;
            }

            char[] charArray = userInput.toLowerCase().toCharArray();

            if (isPalindrome(charArray)) {
                System.out.println("Result: '" + userInput + "' is a palindrome.");
            } else {
                System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static boolean isPalindrome(char[] chars) {
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}