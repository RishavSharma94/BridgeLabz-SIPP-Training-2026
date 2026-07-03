import java.util.ArrayList;
import java.util.List;

public class AIDrivenResumeScreeningSystem {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> software =
                new Resume<>(new SoftwareEngineer("Rishav"));

        Resume<DataScientist> data =
                new Resume<>(new DataScientist("Aman"));

        Resume<ProductManager> manager =
                new Resume<>(new ProductManager("Rahul"));

        List<JobRole> candidates = new ArrayList<>();

        candidates.add(software.getJobRole());
        candidates.add(data.getJobRole());
        candidates.add(manager.getJobRole());

        displayCandidates(candidates);
    }

    public static void displayCandidates(List<? extends JobRole> list) {

        System.out.println("Resume Screening Results:");

        for (JobRole candidate : list) {
            System.out.println(candidate);
        }
    }
}

abstract class JobRole {

    String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String toString() {
        return candidateName + " - " + getClass().getSimpleName();
    }
}

class SoftwareEngineer extends JobRole {

    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }
}

class DataScientist extends JobRole {

    public DataScientist(String candidateName) {
        super(candidateName);
    }
}

class ProductManager extends JobRole {

    public ProductManager(String candidateName) {
        super(candidateName);
    }
}

class Resume<T extends JobRole> {

    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }
}