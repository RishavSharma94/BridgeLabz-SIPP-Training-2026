import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {

    public static void main(String[] args) {

        TrafficManager manager = new TrafficManager();

        manager.updateTraffic("MG Road", 250);
        manager.updateTraffic("Ring Road", 420);
        manager.updateTraffic("Station Road", 180);
        manager.updateTraffic("Airport Road", 510);
        manager.updateTraffic("MG Road", 100);

        System.out.println();

        manager.displaySortedRoads();

        System.out.println();

        manager.displayBusiestRoad();

        System.out.println();

        manager.generateTrafficReport();

        System.out.println();

        System.out.println("Total Roads Monitored: " + manager.getTotalRoads());
    }
}

class TrafficManager {

    HashMap<String, Integer> trafficData = new HashMap<>();

    public void updateTraffic(String roadName, int vehicles) {

        trafficData.put(roadName,
                trafficData.getOrDefault(roadName, 0) + vehicles);

        System.out.println("Updated " + roadName + " with " + vehicles + " vehicles.");
    }

    public void displaySortedRoads() {

        TreeMap<String, Integer> sortedRoads = new TreeMap<>(trafficData);

        System.out.println("Roads in Sorted Order:");

        for (Map.Entry<String, Integer> road : sortedRoads.entrySet()) {

            System.out.println(road.getKey() + " : " + road.getValue());
        }
    }

    public void displayBusiestRoad() {

        String busiestRoad = "";
        int maxVehicles = 0;

        for (Map.Entry<String, Integer> road : trafficData.entrySet()) {

            if (road.getValue() > maxVehicles) {

                maxVehicles = road.getValue();
                busiestRoad = road.getKey();
            }
        }

        System.out.println("Busiest Road: " + busiestRoad);
        System.out.println("Vehicle Count: " + maxVehicles);
    }

    public void generateTrafficReport() {

        System.out.println("Traffic Analysis Report:");

        for (Map.Entry<String, Integer> road : trafficData.entrySet()) {

            String status;

            if (road.getValue() >= 500) {
                status = "Heavy Traffic";
            } else if (road.getValue() >= 250) {
                status = "Moderate Traffic";
            } else {
                status = "Low Traffic";
            }

            System.out.println(
                    road.getKey() + " -> "
                            + road.getValue()
                            + " Vehicles ("
                            + status + ")");
        }
    }

    public int getTotalRoads() {
        return trafficData.size();
    }
}