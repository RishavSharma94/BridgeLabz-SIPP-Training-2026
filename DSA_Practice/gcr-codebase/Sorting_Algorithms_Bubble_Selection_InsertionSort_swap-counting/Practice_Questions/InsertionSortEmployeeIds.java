public class InsertionSortEmployeeIds {

    public static void main(String[] args) {

        int[] employeeIds = {105, 101, 109, 103, 102};

        for (int i = 1; i < employeeIds.length; i++) {

            int key = employeeIds[i];
            int j = i - 1;

            while (j >= 0 && employeeIds[j] > key) {

                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            employeeIds[j + 1] = key;
        }

        System.out.println("Sorted Employee IDs:");

        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}