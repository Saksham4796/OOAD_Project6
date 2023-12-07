package JDBC;

import ParkingSpace.Parking;
import Vehicles.Vehicle;
import Vehicles.VehicleFactory;
import Vehicles.VehicleFactoryCreation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCResultExtraction {

    VehicleFactory vehicleFactory=new VehicleFactoryCreation();
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    public ArrayList<Vehicle> getVehicle(String query, String searchType){


        // SQL SELECT query
        //String selectQuery = "SELECT * FROM vehicle";

        String url = "jdbc:mysql://localhost/car_rental";
        String username = "root";
        String password = "Masterblaster@9296";

        try (
                // Establishing a connection to the database
                Connection connection = DriverManager.getConnection(url, username, password);

                // Creating a Statement for running SQL queries
                Statement statement = connection.createStatement();
        ) {
            // Sample SQL query (replace with your own query)
            //String sqlQuery = "SELECT * FROM vehicle";

            // Executing the SQL query and getting the ResultSet
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            while (resultSet.next()) {
                // Mapping query results to Vehicle object variables
                String licenseNum = resultSet.getString("licenseNum");
                String stockNum = resultSet.getString("stockNum");
                int capacity = resultSet.getInt("capacity");
                String barcode = resultSet.getString("barcode");
                boolean hasSunroof = resultSet.getBoolean("hasSunroof");
                String status = resultSet.getString("status");
                String make= resultSet.getString("make");
                String model = resultSet.getString("model");
                int manufacturingYear = resultSet.getInt("manufacturingYear");
                int mileage = resultSet.getInt("mileage");

                //String query="SELECT * FROM `parking` WHERE `licenceNumber`='"+licenseNum+"'";
                Parking parking=new Parking(1,"A1,B2");
                // Creating a new Vehicle object and adding it to the list
                Vehicle vehicle = vehicleFactory.createVehicle(make,licenseNum, stockNum, capacity, barcode,
                        hasSunroof, status, model,make,manufacturingYear, mileage,parking);

                vehicles.add(vehicle);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}
