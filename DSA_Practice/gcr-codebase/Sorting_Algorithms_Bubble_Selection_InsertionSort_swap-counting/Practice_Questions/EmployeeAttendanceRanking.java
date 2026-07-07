import java.util.Arrays;

public class EmployeeAttendanceRanking {

    public static void main(String[] args) {

        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};

        int k = 3;

        for (int i = 0; i < attendance.length - 1; i++) {

            for (int j = i + 1; j < attendance.length; j++) {

                if (attendance[i] < attendance[j] ||
                        (attendance[i] == attendance[j] && employeeIds[i] > employeeIds[j])) {

                    int tempAttendance = attendance[i];
                    attendance[i] = attendance[j];
                    attendance[j] = tempAttendance;

                    int tempId = employeeIds[i];
                    employeeIds[i] = employeeIds[j];
                    employeeIds[j] = tempId;
                }
            }
        }

        int[] result = Arrays.copyOf(employeeIds, k);

        System.out.println("Top " + k + " Employees:");
   //output
        for (int id : result) {
            System.out.print(id + " ");
        }
    }
}