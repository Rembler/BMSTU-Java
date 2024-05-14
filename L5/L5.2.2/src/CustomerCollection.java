import java.util.Arrays;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class CustomerCollection {
    public final Customer[] Data;

    public CustomerCollection(Customer[] data) throws CustomerCreationException {
        var ids = new HashSet<Integer>();

        for (var customer : data) {
            ids.add(customer.getId());
        }

        if (ids.size() < data.length) {
            throw new CustomerCreationException("Data contains customers with same IDs");
        }

        Data = data;
    }

    public CustomerCollection sort(CustomerComparator comparator) throws CustomerCreationException {
        var dataCopy = Data;

        Arrays.sort(dataCopy, comparator);

        return new CustomerCollection(dataCopy);
    }

    public CustomerCollection filterByCardNumber(int lowerBound, int upperBound) throws CustomerCreationException {
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
