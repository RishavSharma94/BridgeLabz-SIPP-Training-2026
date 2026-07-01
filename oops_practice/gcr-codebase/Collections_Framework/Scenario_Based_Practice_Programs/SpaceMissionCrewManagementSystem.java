import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SpaceMissionCrewManagementSystem {

    public static void main(String[] args) {

        MissionManager manager = new MissionManager();

        manager.addMission("Chandrayaan-4");
        manager.addMission("Gaganyaan");
        manager.addMission("Mars Mission");

        manager.assignAstronaut("Chandrayaan-4", new Astronaut("A101", "Rishav", "Pilot"));
        manager.assignAstronaut("Chandrayaan-4", new Astronaut("A102", "Aman", "Scientist"));
        manager.assignAstronaut("Chandrayaan-4", new Astronaut("A101", "Rishav", "Pilot"));

        manager.assignAstronaut("Gaganyaan", new Astronaut("A103", "Rahul", "Engineer"));
        manager.assignAstronaut("Gaganyaan", new Astronaut("A104", "Kunal", "Doctor"));

        manager.assignAstronaut("Mars Mission", new Astronaut("A105", "Rohit", "Commander"));

        System.out.println();

        manager.displayMissions();
    }
}

class Astronaut {

    String astronautId;
    String name;
    String specialization;

    public Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }
}

class MissionManager {

    HashMap<String, List<Astronaut>> missions = new HashMap<>();
    HashMap<String, HashSet<String>> assignedIds = new HashMap<>();

    public void addMission(String missionName) {

        missions.putIfAbsent(missionName, new ArrayList<>());
        assignedIds.putIfAbsent(missionName, new HashSet<>());

        System.out.println(missionName + " Added.");
    }

    public void assignAstronaut(String missionName, Astronaut astronaut) {

        if (!missions.containsKey(missionName)) {
            System.out.println("Mission Not Found.");
            return;
        }

        HashSet<String> ids = assignedIds.get(missionName);

        if (ids.contains(astronaut.astronautId)) {
            System.out.println("Duplicate Assignment: " + astronaut.name);
            return;
        }

        missions.get(missionName).add(astronaut);
        ids.add(astronaut.astronautId);

        System.out.println(astronaut.name + " Assigned to " + missionName);
    }

    public void displayMissions() {

        for (String mission : missions.keySet()) {

            System.out.println("Mission: " + mission);

            List<Astronaut> crew = missions.get(mission);

            for (Astronaut astronaut : crew) {

                System.out.println(
                        astronaut.astronautId + "  "
                                + astronaut.name + "  "
                                + astronaut.specialization);
            }

            System.out.println("Total Crew: " + crew.size());
            System.out.println();
        }
    }
}