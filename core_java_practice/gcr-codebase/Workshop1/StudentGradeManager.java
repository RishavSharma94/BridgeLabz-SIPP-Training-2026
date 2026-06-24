import java.io.*;
import java.util.*;

public class StudentGradeManager {

    static String[] names = new String[100];
    static int[][] marks = new int[100][5];
    static int[] total = new int[100];
    static String[] grade = new String[100];
    static int count = 0;

    public static void readFile(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            names[count] = data[0];

            for (int i = 0; i < 5; i++) {
                marks[count][i] = Integer.parseInt(data[i + 1]);
                total[count] += marks[count][i];
            }

            calculateGrade(count);
            count++;
        }
        br.close();
    }

    public static void calculateGrade(int i) {
        int avg = total[i] / 5;

        if (avg >= 90) grade[i] = "A";
        else if (avg >= 75) grade[i] = "B";
        else if (avg >= 60) grade[i] = "C";
        else if (avg >= 40) grade[i] = "D";
        else grade[i] = "F";
    }

    public static void searchStudent(String key) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(key)) {
                System.out.println(names[i] + " Total: " + total[i] + " Grade: " + grade[i]);
                found = true;
            }
        }

        if (!found) System.out.println("Student not found");
    }

    public static void bubbleSort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (total[j] < total[j + 1]) {

                    int tempTotal = total[j];
                    total[j] = total[j + 1];
                    total[j + 1] = tempTotal;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    String tempGrade = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = tempGrade;
                }
            }
        }
    }

    public static void writeFile(String file) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        for (int i = 0; i < count; i++) {
            bw.write(names[i] + " Total: " + total[i] + " Grade: " + grade[i]);
            bw.newLine();
        }

        bw.close();
    }

    public static void main(String[] args) {
        try {
            readFile("input.txt");

            bubbleSort();

            searchStudent("Rishav");

            writeFile("output.txt");

            System.out.println("Report Generated Successfully");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }
}