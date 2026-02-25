import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());

        return clean.contentEquals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String text) {
        return strategy.isPalindrome(text);
    }
}

public class PalindromeCheckerApp {
    static void main(String[] args) {
        PalindromeContext context = new PalindromeContext();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Strategy: 1 (Stack) or 2 (Deque)");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            context.setStrategy(new StackStrategy());
        } else {
            context.setStrategy(new DequeStrategy());
        }

        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.println("Result: " + context.executeCheck(text));

        scanner.close();
    }
}