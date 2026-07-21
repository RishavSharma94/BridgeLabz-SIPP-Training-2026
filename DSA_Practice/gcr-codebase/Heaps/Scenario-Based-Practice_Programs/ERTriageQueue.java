import java.util.*;

class Patient {
    int severity;
    String name;

    Patient(int severity, String name) {
        this.severity = severity;
        this.name = name;
    }
}

public class ERTriageQueue {

    PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    void addPatient(Patient p) {
        pq.offer(p);
    }

    Patient treatNext() {
        return pq.poll();
    }

    public static void main(String[] args) {

        ERTriageQueue er = new ERTriageQueue();

        er.addPatient(new Patient(5, "Rahul"));
        er.addPatient(new Patient(9, "Aman"));
        er.addPatient(new Patient(7, "Riya"));

        while (!er.pq.isEmpty()) {
            Patient p = er.treatNext();
            System.out.println(p.name + " " + p.severity);
        }
    }
}