import java.util.Arrays;

public class TripletsLoadBalancing {

    public static void main(String[] args) {

        int[] jobs = {200, 300, 400, 500, 600, 700};

        int target = 1200;

        Arrays.sort(jobs);

        System.out.println("Triplets:");

        for (int i = 0; i < jobs.length - 2; i++) {

            if (i > 0 && jobs[i] == jobs[i - 1])
                continue;

            int left = i + 1;
            int right = jobs.length - 1;

            while (left < right) {

                int sum = jobs[i] + jobs[left] + jobs[right];

                if (sum == target) {

                    System.out.println(jobs[i] + " " + jobs[left] + " " + jobs[right]);

                    left++;
                    right--;

                    while (left < right && jobs[left] == jobs[left - 1])
                        left++;

                    while (left < right && jobs[right] == jobs[right + 1])
                        right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}