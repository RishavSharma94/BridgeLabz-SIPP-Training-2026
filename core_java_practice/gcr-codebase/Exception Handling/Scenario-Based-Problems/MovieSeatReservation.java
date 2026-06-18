public class MovieSeatReservation {

    public static int getSeat(int index) {
        int[] seats = {101, 102, 103, 104, 105};

        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat index!");
            return -1;
        }
    }

    public static void main(String[] args) {

        int result = getSeat(8); // test case

        if (result != -1) {
            System.out.println("Seat number: " + result);
        } else {
            System.out.println("Seat not available");
        }
    }
}