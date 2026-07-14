public class ReverseBrowserHistory {

    static class Node {

        String page;
        Node next;

        Node(String page) {
            this.page = page;
        }
    }

    static Node reverseHistory(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void display(Node head) {

        while (head != null) {

            System.out.print(head.page + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node("Google");
        head.next = new Node("YouTube");
        head.next.next = new Node("GitHub");
        head.next.next.next = new Node("ChatGPT");

        System.out.println("Original History:");
        display(head);

        head = reverseHistory(head);

        System.out.println("Reversed History:");
        display(head);
    }
}