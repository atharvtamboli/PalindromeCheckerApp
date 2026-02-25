import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Linked List Palindrome Pro";
    private static final String APP_VERSION = "7.0.0";

    public static void main(String[] args) {
        displayWelcomeMessage();
        startPalindromeChecker();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("  Welcome to the " + APP_NAME);
        System.out.println("  Version: " + APP_VERSION);
        System.out.println("=====================================");
        System.out.println("Finding the middle and reversing the second half.\n");
    }

    private static void startPalindromeChecker() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a string (or 'exit'): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) break;

            Node head = convertToLinkedList(userInput.toLowerCase());

            if (isPalindrome(head)) {
                System.out.println("Result: It is a palindrome.");
            } else {
                System.out.println("Result: It is NOT a palindrome.");
            }
        }
        scanner.close();
    }

    private static Node convertToLinkedList(String str) {
        if (str.isEmpty()) return null;
        Node head = new Node(str.charAt(0));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }
        return head;
    }

    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data) return false;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}