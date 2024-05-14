import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientInputReader {
    private ArrayList<Patient> _readPatients;
    private Scanner _sc;

    public PatientInputReader(Scanner scanner) {
        _readPatients = new ArrayList<>();
        _sc = scanner;
    }

    public ArrayList<Patient> readPatients(int numberOfCustomers) {
        _readPatients = new ArrayList<>();

        for (int i = 0; i < numberOfCustomers; i++) {
            var patientId = readId("'Patient ID'");
            var fullName = readFullName();
            var address = readAddress();
            var phoneNumber = readPhoneNumber();
            var cardNumber = readId("'Card number'");
            var diagnosis = readDiagnosis();

            var customer = new Patient(
                    patientId,
                    fullName.Name,
                    fullName.Surname,
                    fullName.Patronymic,
                    address,
                    phoneNumber,
                    cardNumber,
                    diagnosis);

            _readPatients.add(customer);
        }

        return _readPatients;
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

    private String readPhoneNumber()
    {
        System.out.println("Phone number:");

        boolean phoneNumberRead = false;
        var phoneNumber = "";

        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        Pattern pattern = Pattern.compile(patterns);

        while (!phoneNumberRead) {
            try {
                phoneNumber = _sc.nextLine();
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read phone number. %s%n",exception.getMessage());

                continue;
            }

            Matcher matcher = pattern.matcher(phoneNumber);

            if (!matcher.matches()) {
                System.out.println("Phone number has invalid format");

                continue;
            }

            phoneNumberRead = true;
        }

        return phoneNumber;
    }

    private String readDiagnosis()
    {
        System.out.println("Diagnosis:");

        var diagnosis = "";

        while (diagnosis == "") {
            try {
                diagnosis = _sc.nextLine();
            } catch (InputMismatchException exception) {
                System.out.printf("Unable to read diagnosis. %s%n",exception.getMessage());
            }
        }

        return diagnosis;
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
