public class SmartLibraryMembershipSystem {

    public static void main(String[] args) {

        LibraryMember[] members = {
                new StudentMember("Rishav", "S101"),
                new FacultyMember("Aman", "F201"),
                new GuestMember("Rahul", "G301")
        };

        int overdueDays = 5;

        for (LibraryMember member : members) {
            member.printDetails();
            System.out.println("Fine: ₹" + member.calculateFine(overdueDays));
            System.out.println();
        }

        String searchId = "F201";

        for (LibraryMember member : members) {
            if (member.memberId.equals(searchId)) {
                System.out.println("Member Found:");
                member.printDetails();
            }
        }
    }
}

abstract class LibraryMember {

    String memberName;
    String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    abstract double calculateFine(int overdueDays);

    public void printDetails() {
        System.out.println("Name: " + memberName);
        System.out.println("ID: " + memberId);
    }
}

class StudentMember extends LibraryMember {

    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
}

class FacultyMember extends LibraryMember {

    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 1;
    }
}

class GuestMember extends LibraryMember {

    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }
}