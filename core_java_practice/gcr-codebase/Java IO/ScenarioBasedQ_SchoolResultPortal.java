import java.io.*;

public class ScenarioBasedQ_SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "report.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");
                String name = data[0];

                int sum = 0;

                for (int i = 1; i < data.length; i++) {
                    sum += Integer.parseInt(data[i]);
                }

                double avg = (double) sum / (data.length - 1);

                bw.write(name + " -> Average: " + avg);
                bw.newLine();
            }

            br.close();
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading or writing file");
        }
    }
}