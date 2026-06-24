import java.io.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("report.txt", true));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                String name = data[0];

                int total = 0;
                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double avg = total / (data.length - 1);

                bw.write(name + " Average: " + avg);
                bw.newLine();
            }

            br.close();
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error processing file");
        }
    }
}