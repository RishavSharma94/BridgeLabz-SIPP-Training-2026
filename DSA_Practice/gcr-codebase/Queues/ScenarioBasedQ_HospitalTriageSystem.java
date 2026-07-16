import java.util.*;

public class ScenarioBasedQ_HospitalTriageSystem {

    static class Patient {

        int severity;
        String name;

        Patient(int severity, String name) {
            this.severity = severity;
            this.name = name;
        }
    }

    static void hospitalTriage() {

        PriorityQueue<Patient> pq =
                new PriorityQueue<>((a, b) -> a.severity - b.severity);

        pq.offer(new Patient(3, "Rahul"));
        pq.offer(new Patient(1, "Aman"));
        pq.offer(new Patient(2, "Priya"));
        pq.offer(new Patient(5, "Neha"));

        System.out.println("Hospital Triage:");

        while (!pq.isEmpty()) {

            Patient p = pq.poll();

            System.out.println(p.name + " -> Severity " + p.severity);
        }
    }

    static void slidingWindowMaximum(int[] vitals, int k) {

        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("\nSliding Window Maximum:");

        for (int i = 0; i < vitals.length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();

            while (!deque.isEmpty() &&
                    vitals[deque.peekLast()] <= vitals[i])
                deque.pollLast();

            deque.offerLast(i);

            if (i >= k - 1)
                System.out.print(vitals[deque.peekFirst()] + " ");
        }

        System.out.println();
    }

    static class CircularQueue {

        int[] queue;
        int front;
        int rear;
        int count;

        CircularQueue(int size) {

            queue = new int[size];
            front = 0;
            rear = 0;
            count = 0;
        }

        void enqueue(int process) {

            if (count == queue.length) {
                System.out.println("Queue Full");
                return;
            }

            queue[rear] = process;
            rear = (rear + 1) % queue.length;
            count++;
        }

        void dequeue() {

            if (count == 0) {
                System.out.println("Queue Empty");
                return;
            }

            System.out.println("Executing Process : " + queue[front]);

            front = (front + 1) % queue.length;
            count--;
        }
    }

    public static void main(String[] args) {

        hospitalTriage();

        int[] vitals = {10, 20, 30, 15, 25, 40, 35};

        slidingWindowMaximum(vitals, 3);

        CircularQueue cpu = new CircularQueue(5);

        cpu.enqueue(101);
        cpu.enqueue(102);
        cpu.enqueue(103);
        cpu.enqueue(104);

        System.out.println("\nRound Robin CPU Scheduler:");

        cpu.dequeue();
        cpu.dequeue();

        cpu.enqueue(105);
        cpu.enqueue(106);

        cpu.dequeue();
        cpu.dequeue();
        cpu.dequeue();
        cpu.dequeue();
    }
}