import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerInputReader {
    private ArrayList<Customer> _readCustomers;
    private Scanner _sc;

    public CustomerInputReader(Scanner scanner) {
        _readCustomers = new ArrayList<>();
        _sc = scanner;
    }

    public ArrayList<Customer> readCustomers(int numberOfCustomers) {
        _readCustomers = new ArrayList<>();

        for (int i = 0; i < numberOfCustomers; i++) {
            var customerId = readId("'Customer ID'");
            var fullName = readFullName();
            var address = readAddress();
            var cardNumber = readId("'Card number'");
            var bankAccountNumber = readId("'Bank account number'");

            var customer = new Customer(customerId,
                    fullName.Name,
                    fullName.Surname,
                    fullName.Patronymic,
                    address,
                    cardNumber,
                    bankAccountNumber);

            _readCustomers.add(customer);
        }

        return _readCustomers;
    }

    private int readId(String parameterName) {
        System.out.printf("%s%n", parameterName);

        int id = -1;

        while (id < 0) {
            try {
                id = _sc.nextInt();
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read %s. %s%n", parameterName, exception.getMessage());

                continue;
            }

            if (id < 0) {
                System.out.printf("%s must be greater than or equal to zero%n", parameterName);
            }
        }

        return id;
    }

    private FullName readFullName() {
        System.out.println("Full name (format: Surname Name Patronymic):");
        _sc.nextLine();

        boolean fullNameRead = false;
        String[] fullName = new String[] {};

        while (!fullNameRead) {
            try {
                fullName = _sc.nextLine().split(" ");
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read full name. %s%n",exception.getMessage());

                continue;
            }

            if (fullName.length != 3) {
                System.out.println("Full name must be provided in following format: Surname Name Patronymic");

                continue;
            }

            fullNameRead = true;
        }

        return new FullName(fullName[1], fullName[0], fullName[2]);
    }

    private String readAddress()
    {
        System.out.println("Address:");

        var address = "";

        while (address == "") {
            try {
                address = _sc.nextLine();
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read address. %s%n",exception.getMessage());
            }
        }

        return address;
    }

    private class FullName {
        public String Name;
        public String Surname;
        public String Patronymic;

        public FullName(String name, String surname, String patronymic) {
            Name = name;
            Surname = surname;
            Patronymic = patronymic;
        }
    }
}
