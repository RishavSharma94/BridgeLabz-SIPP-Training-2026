import java.util.PriorityQueue;

class Patient {

    int priority;
    String name;

    Patient(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }
}

public class HospitalERTriage {

    public static void main(String[] args) {

        PriorityQueue<Patient> queue =
                new PriorityQueue<>((a, b) -> a.priority - b.priority);

        queue.offer(new Patient(3, "Rohan"));
        queue.offer(new Patient(1, "Aman"));
        queue.offer(new Patient(2, "Priya"));
        queue.offer(new Patient(5, "Rahul"));
        queue.offer(new Patient(4, "Neha"));

        while (!queue.isEmpty()) {

            Patient p = queue.poll();

            System.out.println(p.name + " Priority : " + p.priority);
        }
    }
}