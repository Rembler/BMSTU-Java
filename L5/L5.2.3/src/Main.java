import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of patients:");

        int count = 0;

        while (count <= 0) {
            try {
                count = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read number of patients. %s%n", exception.getMessage());

                continue;
            }

            if (count <= 0) {
                System.out.println("Number of patients must be greater than zero");
            }
        }

        var patientInputReader = new PatientInputReader(sc);
        var readPatients = patientInputReader.readPatients(count);

        sc.close();

        var patients = new Patient[readPatients.size()];
        patients = readPatients.toArray(patients);

        var patientCollection = new PatientCollection(patients);

        System.out.println(patientCollection);
        System.out.println();

        System.out.println(patientCollection.filterByDiagnosis("B"));
        System.out.println();

        System.out.println(patientCollection.filterByCardNumber(1, 2));
    }
}