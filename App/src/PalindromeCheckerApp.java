import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Deque Palindrome Logic";
    private static final String APP_VERSION = "6.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Using Double-Ended Queue for Front/Rear comparison.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Shutting down Deque App. Goodbye!");
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
        Deque<Character> deque = new ArrayDeque<>();
        String cleanStr = str.toLowerCase();

        for (int i = 0; i < cleanStr.length(); i++) {
            deque.addLast(cleanStr.charAt(i));
        }

        while (deque.size() > 1) {
            Character first = deque.removeFirst();
            Character last = deque.removeLast();

            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }
}