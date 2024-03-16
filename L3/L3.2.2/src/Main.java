public class Main {
    public static void main(String[] args) {
        var customer1 = new Customer(
                0,
                "",
                "B",
                "",
                "",
                1,
                0
        );

        var customer2 = new Customer(
                0,
                "",
                "A",
                "",
                "",
                2,
                0
        );

        var customer3 = new Customer(
                0,
                "",
                "C",
                "",
                "",
                3,
                0
        );

        var customers = new Customer[] { customer1, customer2, customer3 };

        var customerCollection = new CustomerCollection(customers);

        System.out.println(customerCollection);

        System.out.println();

        System.out.println(customerCollection.sort(CustomerComparator.bySurname()));

        System.out.println();

        System.out.println(customerCollection.filterByCardNumber(1, 2));
    }
}

