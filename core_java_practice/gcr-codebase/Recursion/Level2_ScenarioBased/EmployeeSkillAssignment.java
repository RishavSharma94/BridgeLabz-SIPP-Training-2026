import java.util.*;

public class EmployeeSkillAssignment {

    public static void findTeams(int[] arr, int index, int target, List<Integer> current) {

        if (target == 0) {
            System.out.println(current);
            return;
        }

        if (index == arr.length || target < 0) return;

        // include
        current.add(arr[index]);
        findTeams(arr, index + 1, target - arr[index], current);

        // exclude
        current.remove(current.size() - 1);
        findTeams(arr, index + 1, target, current);
    }

    public static void main(String[] args) {

        int[] skills = {2, 3, 5, 7};
        int target = 10;

        findTeams(skills, 0, target, new ArrayList<>());
    }
}