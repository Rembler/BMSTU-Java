import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of customers:");

        int count = 0;

        while (count <= 0) {
            try {
                count = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read number of customers. %s%n", exception.getMessage());

                continue;
            }

            if (count <= 0) {
                System.out.println("Number of customers must be greater than zero");
            }
        }

        var customerInputReader = new CustomerInputReader(sc);
        var readCustomers = customerInputReader.readCustomers(count);

        sc.close();

        var customers = new Customer[readCustomers.size()];
        customers = readCustomers.toArray(customers);

        try {
            var customerCollection = new CustomerCollection(customers);

            System.out.println(customerCollection);

            System.out.println();

            System.out.println(customerCollection.sort(CustomerComparator.bySurname()));

            System.out.println();

            System.out.println(customerCollection.filterByCardNumber(1, 2));
        } catch (CustomerCreationException exception) {
            System.out.printf("Unable to create customer collection. %s%n", exception.getMessage());
        }
    }
}

