package ParkingSpace;

public class Parking {
    int ParkingLotNumber;
    String Location;

    public Parking(int ParkingLotNumber, String Location) {
        this.ParkingLotNumber = ParkingLotNumber;
        this.Location = Location;
    }
    public int getParkingLotNumber() {
        return ParkingLotNumber;
    }
    public void setParkingLotNumber(int ParkingLotNumber) {
        this.ParkingLotNumber = ParkingLotNumber;
    }

}
