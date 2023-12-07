package JDBC;

import Vehicles.Vehicle;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCAddEntries {
    // ... other code ...

    public void addVehicle(Vehicle vehicle) {
        try {
            // Retrieve values from the input fields

            // JDBC Connection parameters
            String DB_URL = "jdbc:mysql://localhost/CAR_RENTAL";
            String USER = "root";
            String PASS = "Masterblaster@9296";

            // SQL INSERT query
            String insertQuery = "INSERT INTO vehicle (licenseNum, stockNum, capacity, barcode, hasSunroof, status, model, make, manufacturingYear, mileage) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (
                    // Establishing a connection to the database
                    Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

                    // Creating a PreparedStatement for the INSERT query
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
            ) {
                // Setting parameter values for the PreparedStatement
                preparedStatement.setString(1, vehicle.getLicensePlate());
                preparedStatement.setString(2, vehicle.getStockNumber());
                preparedStatement.setInt(3, vehicle.getCapacity());
                preparedStatement.setString(4, vehicle.getBarcode());
                preparedStatement.setBoolean(5, vehicle.isHasSunroof());
                preparedStatement.setString(6, vehicle.getStatus());
                preparedStatement.setString(7, vehicle.getModel());
                preparedStatement.setString(8, vehicle.getMake());
                preparedStatement.setInt(9, vehicle.getManufacturingYear());
                preparedStatement.setInt(10, vehicle.getMileage());
                //preparedStatement.setInt(11, parkingLotNumber);
                //preparedStatement.setString(12, parkingLocation);

                // Executing the INSERT query
                preparedStatement.executeUpdate();

                // Display success message
                String message = "Vehicle Added to Database";



                // Switch back to the main screen after adding a vehicle
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
        }
    }

    public void addReservation() {
    }

    // ... other code ...
}
