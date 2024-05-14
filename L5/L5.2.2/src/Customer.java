import java.util.StringJoiner;

public class Customer {
    private int Id;
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Address;
    private int CardNumber;
    private int BankAccountNumber;

    public Customer(int id,
                    String name,
                    String surname,
                    String patronymic,
                    String address,
                    int cardNumber,
                    int bankAccountNumber) {
        Id = id;
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        Address = address;
        CardNumber = cardNumber;
        BankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        var stringJoiner = new StringJoiner(", ");

        stringJoiner
                .add("id: " + Id)
                .add("name: " + Name)
                .add("surname: " + Surname)
                .add("patronymic: " + Patronymic)
                .add("address: " + Address)
                .add("card number: " + CardNumber)
                .add("bank account number: " + BankAccountNumber);

        return stringJoiner.toString();
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public String getAddress() {
        return Address;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public int getBankAccountNumber() {
        return BankAccountNumber;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        BankAccountNumber = bankAccountNumber;
    }
}

