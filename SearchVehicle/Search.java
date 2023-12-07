package SearchVehicle;

import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public interface Search {
    public List<Vehicle> searchByType(String type);
    public List<Vehicle> searchByModel(String type,String model) ;

}
