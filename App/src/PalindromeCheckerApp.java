import java.util.Scanner;

class PalindromeService {

    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String cleanStr = normalize(input);
        return isBalanced(cleanStr);
    }

    private String normalize(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean isBalanced(String str) {
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

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Encapsulated Palindrome Pro";

    public static void main(String[] args) {
        PalindromeService service = new PalindromeService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== " + APP_NAME + " ===");

        while (true) {
            System.out.print("Enter text (or 'exit'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            boolean result = service.checkPalindrome(input);
            System.out.println("Is Palindrome: " + result + "\n");
        }
        scanner.close();
    }
}