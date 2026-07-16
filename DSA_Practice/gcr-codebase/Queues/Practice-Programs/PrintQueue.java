import java.util.ArrayDeque;
import java.util.Deque;

public class PrintQueue {

    private Deque<Integer> queue = new ArrayDeque<>();

    // Normal Job
    public void addLast(int jobId) {

        queue.addLast(jobId);
        System.out.println("Normal Job Added : " + jobId);
    }

    // Urgent Job
    public void addFirst(int jobId) {

        queue.addFirst(jobId);
        System.out.println("Urgent Job Added : " + jobId);
    }

    // Print Next Job
    public void removeFirst() {

        if (queue.isEmpty()) {
            System.out.println("No Jobs Available");
            return;
        }

        System.out.println("Printing Job : " + queue.removeFirst());
    }

    public void display() {

        System.out.println(queue);
    }

    public static void main(String[] args) {

        PrintQueue printer = new PrintQueue();

        printer.addLast(101);
        printer.addLast(102);
        printer.addLast(103);

        printer.addFirst(999);

        System.out.println("\nCurrent Queue:");
        printer.display();

        System.out.println("\nPrinting Jobs:");

        printer.removeFirst();
        printer.removeFirst();
        printer.removeFirst();
        printer.removeFirst();

        System.out.println("\nRemaining Queue:");
        printer.display();
    }
}