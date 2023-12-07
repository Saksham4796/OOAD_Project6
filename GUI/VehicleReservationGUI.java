package GUI;

import JDBC.JDBCAddEntries;
import Vehicles.Vehicle;
import Vehicles.VehicleFactoryCreation;
import ParkingSpace.Parking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleReservationGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private VehicleFactoryCreation vehicleFactory=new VehicleFactoryCreation();
    private JTextField licenseNumField;
    private JTextField stockNumField;
    private JTextField capacityField;
    private JTextField barcodeField;
    private JCheckBox hasSunroofCheckBox;
    private JTextField statusField;
    private JTextField modelField;
    private JTextField makeField;
    private JTextField manufacturingYearField;
    private JTextField mileageField;
    private JTextField parkingLotNumField;
    private JTextField parkingLocationField;

    public VehicleReservationGUI() {
        setTitle("Vehicle Reservation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create CardLayout and JPanel to hold cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Card for the main screen
        JPanel mainScreen = createMainScreen();
        cardPanel.add(mainScreen, "mainScreen");

        // Card for the add vehicle screen
        JPanel addVehicleScreen = createAddVehicleScreen();
        cardPanel.add(addVehicleScreen, "addVehicleScreen");

        // Set up the layout
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // Initially show the main screen
        cardLayout.show(cardPanel, "mainScreen");
    }

    private JPanel createMainScreen() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton addVehicleButton = new JButton("Add Vehicle");
        panel.add(addVehicleButton);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the "addVehicleScreen" when the button is clicked
                cardLayout.show(cardPanel, "addVehicleScreen");
            }
        });

        return panel;
    }

    private JPanel createAddVehicleScreen() {
        JPanel panel = new JPanel(new GridLayout(14, 2, 10, 10));

        licenseNumField = new JTextField(20);
        stockNumField = new JTextField(20);
        capacityField = new JTextField(20);
        barcodeField = new JTextField(20);
        hasSunroofCheckBox = new JCheckBox("Has Sunroof");
        statusField = new JTextField(20);
        modelField = new JTextField(20);
        makeField = new JTextField(20);
        manufacturingYearField = new JTextField(20);
        mileageField = new JTextField(20);
        parkingLotNumField = new JTextField(20);
        parkingLocationField = new JTextField(20);

        JButton saveButton = new JButton("Save");

        panel.add(new JLabel("License Number:"));
        panel.add(licenseNumField);
        panel.add(new JLabel("Stock Number:"));
        panel.add(stockNumField);
        panel.add(new JLabel("Capacity:"));
        panel.add(capacityField);
        panel.add(new JLabel("Barcode:"));
        panel.add(barcodeField);
        panel.add(new JLabel("Has Sunroof:"));
        panel.add(hasSunroofCheckBox);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Make:"));
        panel.add(makeField);
        panel.add(new JLabel("Manufacturing Year:"));
        panel.add(manufacturingYearField);
        panel.add(new JLabel("Mileage:"));
        panel.add(mileageField);
        panel.add(new JLabel("Parking Lot Number:"));
        panel.add(parkingLotNumField);
        panel.add(new JLabel("Parking Location:"));
        panel.add(parkingLocationField);
        panel.add(new JLabel(""));
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVehicle();
            }
        });

        return panel;
    }

    private void addVehicle() {
        // Retrieve values from the input fields
        String licenseNum = licenseNumField.getText();
        String stockNum = stockNumField.getText();
        int capacity = Integer.parseInt(capacityField.getText());
        String barcode = barcodeField.getText();
        boolean hasSunroof = hasSunroofCheckBox.isSelected();
        String status = statusField.getText();
        String model = modelField.getText();
        String make = makeField.getText();
        int manufacturingYear = Integer.parseInt(manufacturingYearField.getText());
        int mileage = Integer.parseInt(mileageField.getText());
        int parkingLotNum = Integer.parseInt(parkingLotNumField.getText());
        String parkingLocation = parkingLocationField.getText();

        Parking parking=new Parking(parkingLotNum,parkingLocation);
        Vehicle vehicle = vehicleFactory.createVehicle(make,licenseNum, stockNum, capacity, barcode,
                hasSunroof, status, model,make,manufacturingYear, mileage, parking);

        JDBCAddEntries addEntries = new JDBCAddEntries();
        addEntries.addVehicle(vehicle);

        // Perform logic to add vehicle (displaying a message for simplicity)
        String message = "Vehicle Added:\n" +
                "License Number: " + licenseNum + "\n" +
                "Stock Number: " + stockNum + "\n" +
                "Capacity: " + capacity + "\n" +
                "Barcode: " + barcode + "\n" +
                "Has Sunroof: " + hasSunroof + "\n" +
                "Status: " + status + "\n" +
                "Model: " + model + "\n" +
                "Make: " + make + "\n" +
                "Manufacturing Year: " + manufacturingYear + "\n" +
                "Mileage: " + mileage + "\n" +
                "Parking Lot Number: " + parkingLotNum + "\n" +
                "Parking Location: " + parkingLocation;

        JOptionPane.showMessageDialog(this, message, "Vehicle Added", JOptionPane.INFORMATION_MESSAGE);

        // Switch back to the main screen after adding a vehicle
        cardLayout.show(cardPanel, "mainScreen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VehicleReservationGUI().setVisible(true);
            }
        });
    }
}
