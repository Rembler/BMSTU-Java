public class Main {
    public static void main(String[] args) throws Exception {
        var parking = new Parking(10);

        parking.placeCar("U234");
        parking.placeCar("P032");

        parking.accountCarDeparture("P032");

        parking.placeCar("X909");
    }
}