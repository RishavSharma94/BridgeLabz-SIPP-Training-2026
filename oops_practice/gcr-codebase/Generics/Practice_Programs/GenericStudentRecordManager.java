import java.util.ArrayList;

public class GenericStudentRecordManager {

    public static void main(String[] args) {

        StudentRecord<Integer> record1 = new StudentRecord<>();

        record1.addRecord(101);
        record1.addRecord(102);
        record1.addRecord(103);

        System.out.println("Integer Student IDs:");
        record1.displayRecords();

        System.out.println();

        StudentRecord<String> record2 = new StudentRecord<>();

        record2.addRecord("S101");
        record2.addRecord("S102");
        record2.addRecord("S103");

        System.out.println("String Student IDs:");
        record2.displayRecords();
    }
}

class StudentRecord<T> {

    ArrayList<T> records = new ArrayList<>();

    public void addRecord(T id) {
        records.add(id);
    }

    public void displayRecords() {

        for (T id : records) {
            System.out.println(id);
        }
    }
}