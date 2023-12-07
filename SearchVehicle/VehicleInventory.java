package SearchVehicle;

import JDBC.JDBCResultExtraction;
import SearchVehicle.Search;
import Vehicles.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleInventory implements Search {
    ArrayList<Vehicle> vehicleTypes;
    ArrayList<Vehicle> vehicleModels;
    JDBCResultExtraction result=new JDBCResultExtraction();
    public VehicleInventory() {
        this.vehicleTypes =  new ArrayList<>();
        this.vehicleModels =  new ArrayList<>();
    }


    public ArrayList<Vehicle> searchByType(String type) {

        String query = "SELECT * FROM vehicle WHERE model = '"+type+"'";
        //System.out.println(query);
        vehicleTypes= this.result.getVehicle(query,type);
        return vehicleTypes;
    }

    public ArrayList<Vehicle> searchByModel(String type,String model) {

        String query="SELECT * FROM `vehicle` WHERE `model`='"+type+"' and `model`='"+model+"'";
        vehicleModels= this.result.getVehicle(query,type);
        return vehicleModels;
    }
}

