import java.util.*;

public class ScenarioBasedQ_DetectiveAgency {

    static void mostInvestigated(HashMap<String, List<Integer>> map) {

        String suspect = "";
        int max = 0;

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {

            if (entry.getValue().size() > max) {

                max = entry.getValue().size();
                suspect = entry.getKey();
            }
        }

        System.out.println("Most Investigated Suspect : " + suspect);
    }

    static void exactlyTwoCases(HashMap<String, List<Integer>> map) {

        System.out.println("\nSuspects in Exactly 2 Cases:");

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {

            if (entry.getValue().size() == 2) {

                System.out.println(entry.getKey());
            }
        }
    }

    static void alwaysSeenTogether(HashMap<String, List<Integer>> map) {

        System.out.println("\nSuspects Always Seen Together:");

        List<String> suspects = new ArrayList<>(map.keySet());

        for (int i = 0; i < suspects.size(); i++) {

            for (int j = i + 1; j < suspects.size(); j++) {

                String s1 = suspects.get(i);
                String s2 = suspects.get(j);

                if (map.get(s1).equals(map.get(s2))) {

                    System.out.println(s1 + " & " + s2);
                }
            }
        }
    }

    static void subarraySumK(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        System.out.println("\nSubarray Sum = " + k);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (map.containsKey(sum - k)) {

                System.out.println("Start Index : " +
                        (map.get(sum - k) + 1));

                System.out.println("End Index : " + i);

                return;
            }

            map.put(sum, i);
        }

        System.out.println("No Subarray Found");
    }

    public static void main(String[] args) {

        HashMap<String, List<Integer>> suspects = new HashMap<>();

        suspects.put("Aman", Arrays.asList(101,102,103));
        suspects.put("Rahul", Arrays.asList(101,102));
        suspects.put("Rohit", Arrays.asList(103));
        suspects.put("Neha", Arrays.asList(101,102));
        suspects.put("Priya", Arrays.asList(104,105));

        mostInvestigated(suspects);

        exactlyTwoCases(suspects);

        alwaysSeenTogether(suspects);

        int[] arr = {2,3,1,2,4,3};

        subarraySumK(arr,7);
    }
}