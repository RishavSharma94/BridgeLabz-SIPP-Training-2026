public class DisasterRescueManagementSystem {

    public static void main(String[] args) {

        RescueTeam[] teams = {
                new MedicalTeam("M101", "Delhi"),
                new FireRescueTeam("F201", "Mumbai"),
                new FoodSupplyTeam("FS301", "Delhi"),
                new MedicalTeam("M102", "Lucknow"),
                new MedicalTeam("M103", "Delhi")
        };

        System.out.println("Performing Duties:\n");

        for (RescueTeam team : teams) {
            team.performDuty();
        }

        findTeamByLocation(teams, "Delhi");

        System.out.println("\nTeams Starting With M:");
        displayTeamsByPrefix(teams, "M");

        countTeams(teams);
    }

    public static void findTeamByLocation(RescueTeam[] teams, String location) {

        System.out.println("\nTeams In " + location + ":");

        for (RescueTeam team : teams) {

            if (team.location.equalsIgnoreCase(location)) {
                System.out.println(team.teamId);
            }
        }
    }

    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {

        for (RescueTeam team : teams) {

            if (team.teamId.startsWith(prefix)) {
                System.out.println(team.teamId);
            }
        }
    }

    public static void countTeams(RescueTeam[] teams) {

        int medical = 0;
        int fire = 0;
        int food = 0;

        for (RescueTeam team : teams) {

            if (team instanceof MedicalTeam)
                medical++;
            else if (team instanceof FireRescueTeam)
                fire++;
            else if (team instanceof FoodSupplyTeam)
                food++;
        }

        System.out.println("\nMedical Teams: " + medical);
        System.out.println("Fire Rescue Teams: " + fire);
        System.out.println("Food Supply Teams: " + food);

        int max = Math.max(medical, Math.max(fire, food));

        System.out.print("Maximum Deployment Category: ");

        if (max == medical)
            System.out.println("Medical Team");
        else if (max == fire)
            System.out.println("Fire Rescue Team");
        else
            System.out.println("Food Supply Team");
    }
}

abstract class RescueTeam {

    String teamId;
    String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    abstract void performDuty();
}

class MedicalTeam extends RescueTeam {

    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " providing medical aid.");
    }
}

class FireRescueTeam extends RescueTeam {

    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " performing fire rescue.");
    }
}

class FoodSupplyTeam extends RescueTeam {

    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " distributing food supplies.");
    }
}