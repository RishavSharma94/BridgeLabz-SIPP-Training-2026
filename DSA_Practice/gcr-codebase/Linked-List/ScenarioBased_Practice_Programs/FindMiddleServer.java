public class FindMiddleServer {

    static class Node {

        String serverName;
        Node next;

        Node(String serverName) {
            this.serverName = serverName;
        }
    }

    static Node findMiddleServer(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static void display(Node head) {

        while (head != null) {

            System.out.print(head.serverName + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node("Server1");
        head.next = new Node("Server2");
        head.next.next = new Node("Server3");
        head.next.next.next = new Node("Server4");
        head.next.next.next.next = new Node("Server5");

        display(head);

        Node middle = findMiddleServer(head);

        System.out.println("Middle Server: " + middle.serverName);
    }
}