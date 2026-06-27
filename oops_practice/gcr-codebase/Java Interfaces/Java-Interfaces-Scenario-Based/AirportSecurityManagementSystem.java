public class AirportSecurityManagementSystem {

    public static void main(String[] args) {

        String[] passengerNames = {
                "Rishav",
                "Aman",
                "Rahul",
                "Kunal"
        };

        String[] passportNumbers = {
                "P1234567",
                "12345",
                "P9876543",
                "AB12"
        };

        AirportSecuritySystem security = new AirportSecuritySystem();

        security.displaySecurityGuidelines();

        System.out.println();

        for (int i = 0; i < passengerNames.length; i++) {

            System.out.println("Passenger: " + passengerNames[i]);

            boolean luggageStatus = security.scanLuggage();
            boolean passportStatus = security.verifyPassport(passportNumbers[i]);

            if (luggageStatus && passportStatus) {
                System.out.println("Status: Allowed to Board");
            } else {
                System.out.println("Status: Boarding Denied");
            }

            System.out.println();
        }
    }
}

interface LuggageScanner {

    boolean scanLuggage();

    default void displaySecurityGuidelines() {
        System.out.println("Luggage must not contain prohibited items.");
    }
}

interface PassportVerifier {

    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passenger must carry a valid passport.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.startsWith("P") && passportNo.length() == 8;
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    @Override
    public boolean scanLuggage() {
        return true;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {

        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();

        System.out.println("Follow all airport security rules.");
    }
}