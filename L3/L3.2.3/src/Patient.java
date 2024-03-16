import java.util.StringJoiner;

public class Patient {
    private int Id;
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Address;
    private String PhoneNumber;
    private int CardNumber;
    private String Diagnosis;

    public Patient(int id,
                    String name,
                    String surname,
                    String patronymic,
                    String address,
                    String phoneNumber,
                    int cardNumber,
                    String diagnosis) {
        Id = id;
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        Address = address;
        PhoneNumber = phoneNumber;
        CardNumber = cardNumber;
        Diagnosis = diagnosis;
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
                .add("phone number: " + PhoneNumber)
                .add("card number: " + CardNumber)
                .add("diagnosis: " + Diagnosis);

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
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public String getDiagnosis() {
        return Diagnosis;
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
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public void setDiagnosis(String diagnosis) {
        Diagnosis = diagnosis;
    }
}

