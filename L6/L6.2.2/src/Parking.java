import java.util.HashMap;
import java.util.HashSet;

public class Parking {
    private final int _size;
    private final HashMap<String, Integer> _plateToParkingLotMap;
    private final HashSet<Integer> _occupiedParkingLots;

    public Parking(int size) {
        _size = size;
        _plateToParkingLotMap = new HashMap<>(size);
        _occupiedParkingLots = new HashSet<>(size);
    }

    public void placeCar(String plateNumber) throws Exception {
        if (_plateToParkingLotMap.containsKey(plateNumber)) {
            throw new Exception(String.format("Car with plate number %s already parked", plateNumber));
        }

        var lotFound = false;

        for (int i = 0; i < _size; i++) {
            if (!_occupiedParkingLots.contains(i)) {
                _plateToParkingLotMap.put(plateNumber, i);
                _occupiedParkingLots.add(i);

                lotFound = true;

                break;
            }
        }

        if (!lotFound) {
            throw new Exception("No free parking lots at the moment");
        }
    }

    public void accountCarDeparture(String plateNumber) throws Exception {
        if (!_plateToParkingLotMap.containsKey(plateNumber)) {
            throw new Exception(String.format("Car with plate number %s is not parked", plateNumber));
        }

        var parkingLot = _plateToParkingLotMap.get(plateNumber);

        _plateToParkingLotMap.remove(plateNumber);
        _occupiedParkingLots.remove(parkingLot);
    }
}
