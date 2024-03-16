public class Main {
    public static void main(String[] args) {
        var patients = new Patient[] {
                new Patient(
                        1,
                        "",
                        "",
                        "",
                        "",
                        "",
                        1,
                        "A"
                ),
                new Patient(
                        2,
                        "",
                        "",
                        "",
                        "",
                        "",
                        2,
                        "B"
                ),
                new Patient(
                        3,
                        "",
                        "",
                        "",
                        "",
                        "",
                        3,
                        "B"
                )
        };

        var patientCollection = new PatientCollection(patients);

        System.out.println(patientCollection);
        System.out.println();

        System.out.println(patientCollection.filterByDiagnosis("B"));
        System.out.println();

        System.out.println(patientCollection.filterByCardNumber(1, 2));
    }
}