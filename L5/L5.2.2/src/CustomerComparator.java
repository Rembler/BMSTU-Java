import java.util.Comparator;

public abstract class CustomerComparator implements Comparator<Customer> {
    public static CustomerComparator bySurname() {
        return new CustomerSurnameComparator();
    }

    private static class CustomerSurnameComparator extends CustomerComparator {

        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
}
