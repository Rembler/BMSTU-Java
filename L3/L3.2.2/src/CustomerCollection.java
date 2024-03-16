import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class CustomerCollection {
    public final Customer[] Data;

    public CustomerCollection(Customer[] data) {
        Data = data;
    }

    public CustomerCollection sort(CustomerComparator comparator) {
        var dataCopy = Data;

        Arrays.sort(dataCopy, comparator);

        return new CustomerCollection(dataCopy);
    }

    public CustomerCollection filterByCardNumber(int lowerBound, int upperBound) {
        Predicate<Customer> predicate = (Customer customer) -> {
            var cardNumber = customer.getCardNumber();

            return cardNumber >= lowerBound && cardNumber <= upperBound;
        };

        var filteredData = Arrays.stream(Data).filter(predicate).toArray(Customer[]::new);

        return new CustomerCollection(filteredData);
    }

    @Override
    public String toString() {
        var stringJoiner = new StringJoiner("\n");

        for (var customer : Data) {
            stringJoiner.add(customer.toString());
        }

        return stringJoiner.toString();
    }
}
