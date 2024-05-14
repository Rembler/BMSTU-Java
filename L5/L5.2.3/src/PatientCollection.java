import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class PatientCollection {
    public final Patient[] Data;

    public PatientCollection(Patient[] data) {
        Data = data;
    }

    public PatientCollection filterByDiagnosis(String targetDiagnosis) {
        var filteredData = Arrays.stream(Data)
                .filter(patient -> patient.getDiagnosis().equals(targetDiagnosis))
                .toArray(Patient[]::new);

        return new PatientCollection(filteredData);
    }

    public PatientCollection filterByCardNumber(int lowerBound, int upperBound) {
        Predicate<Patient> predicate = (Patient customer) -> {
            var cardNumber = customer.getCardNumber();

            return cardNumber >= lowerBound && cardNumber <= upperBound;
        };

        var filteredData = Arrays.stream(Data).filter(predicate).toArray(Patient[]::new);

        return new PatientCollection(filteredData);
    }

    @Override
    public String toString() {
        var stringJoiner = new StringJoiner("\n");

        for (var patient : Data) {
            stringJoiner.add(patient.toString());
        }

        return stringJoiner.toString();
    }
}
