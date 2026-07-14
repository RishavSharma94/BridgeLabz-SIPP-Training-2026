public class CycleDetectionRedirectLoop {

    static class Node {

        String url;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    static boolean hasRedirectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");

        // Create Cycle
        head.next.next.next.next = head.next;

        if (hasRedirectLoop(head))
            System.out.println("Redirect Loop Detected");
        else
            System.out.println("No Redirect Loop");
    }
}