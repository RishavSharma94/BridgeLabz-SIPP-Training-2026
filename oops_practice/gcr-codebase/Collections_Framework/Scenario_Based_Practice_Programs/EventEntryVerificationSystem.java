import java.util.HashSet;

public class EventEntryVerificationSystem {

    public static void main(String[] args) {

        EventManager manager = new EventManager();

        manager.registerParticipant("rishav@gmail.com");
        manager.registerParticipant("aman@gmail.com");
        manager.registerParticipant("rahul@gmail.com");
        manager.registerParticipant("aman@gmail.com");
        manager.registerParticipant("kunal@gmail.com");

        System.out.println();

        manager.displayParticipants();
    }
}

class EventManager {

    HashSet<String> participants = new HashSet<>();

    public void registerParticipant(String email) {

        if (participants.add(email)) {
            System.out.println(email + " Registered Successfully.");
        } else {
            System.out.println(email + " Registration Rejected (Duplicate)");
        }
    }

    public void displayParticipants() {

        System.out.println("Registered Participants:");

        for (String email : participants) {
            System.out.println(email);
        }

        System.out.println("\nTotal Eligible Participants: " + participants.size());
    }
}