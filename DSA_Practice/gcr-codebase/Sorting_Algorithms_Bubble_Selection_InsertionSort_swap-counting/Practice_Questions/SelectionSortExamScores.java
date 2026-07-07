public class SelectionSortExamScores {

    public static void main(String[] args) {

        int[] scores = {76, 91, 58, 84, 69};

        for (int i = 0; i < scores.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < scores.length; j++) {

                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }

        System.out.println("Sorted Exam Scores:");

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}