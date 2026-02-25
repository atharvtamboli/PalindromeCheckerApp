import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "PalindromeChecker Pro";
    private static final String APP_VERSION = "1.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        runApplicationLoop();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Type 'exit' to quit.\n");
    }

    private static void runApplicationLoop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter text to check: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Closing application. Happy coding!");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
                continue;
            }

            if (isPalindrome(input)) {
                System.out.println("Result: '" + input + "' is a palindrome.");
            } else {
                System.out.println("Result: '" + input + "' is NOT a palindrome.");
            }
            System.out.println("-------------------------------------");
        }
        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        String clean = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}