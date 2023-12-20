package GUI;

import Account.AdminAccountSingleton;
import JDBC.JDBCAddEntries;
import ParkingSpace.Parking;
import Vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ObserverForNotification.EmailConfirmation;
import ObserverForNotification.SMSConfirmation;
import ParkingSpace.Parking;
import Reservation.VehicleReservation;
import SearchVehicle.VehicleInventory;
import Vehicles.Vehicle;
import Vehicles.VehicleFactoryCreation;


public class CarRentalSystemSwing extends JFrame {

    private List<User> users;
    private List<AdminAccountSingleton> admins;

    private JTextField usernameField;
    private JPasswordField passwordField;

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
    public CarRentalSystemSwing() {
        users = new ArrayList<>();
        admins = new ArrayList<>();

        setTitle("Car Rental System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        createLoginPanel();
        createRegistrationPanel();
        createAdminHomePage();
        createAddVehicleScreen();
        createUserHomePage();
        createSearchVehicleScreen();

        cardLayout.show(cardPanel, "loginScreen");

        add(cardPanel);

        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "registrationScreen");
            }
        });

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        cardPanel.add(panel, "loginScreen");
    }

    private void createRegistrationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField regUsernameField = new JTextField();
        JPasswordField regPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        panel.add(new JLabel("Account Type:"));
        JComboBox<String> accountTypeComboBox = new JComboBox<>(new String[]{"User", "Admin"});
        panel.add(accountTypeComboBox);
        panel.add(new JLabel("Username:"));
        panel.add(regUsernameField);
        panel.add(new JLabel("Password:"));
        panel.add(regPasswordField);
        panel.add(new JLabel(""));
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegistration(
                        regUsernameField.getText(),
                        new String(regPasswordField.getPassword()),
                        (String) accountTypeComboBox.getSelectedItem()
                );
            }
        });

        cardPanel.add(panel, "registrationScreen");
    }

    private void createAdminHomePage() {
        JPanel panel = new JPanel();
        JButton addVehicleButton = new JButton("Add Vehicle");

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "addVehicleScreen");
            }
        });

        panel.add(addVehicleButton);

        cardPanel.add(panel, "adminHomeScreen");
    }

    private void createAddVehicleScreen() {
        JPanel panel = new JPanel(new GridLayout(14, 2, 10, 10));

        // Add vehicle input fields
        // ... (same as your previous add vehicle screen)
        panel.add(new JLabel("License Number:"));
         licenseNumField = new JTextField(20);
        panel.add(licenseNumField);

        panel.add(new JLabel("Stock Number:"));
         stockNumField = new JTextField(20);
        panel.add(stockNumField);

        panel.add(new JLabel("Capacity:"));
         capacityField = new JTextField(20);
        panel.add(capacityField);

        panel.add(new JLabel("Barcode:"));
         barcodeField = new JTextField(20);
        panel.add(barcodeField);

        panel.add(new JLabel("Has Sunroof:"));
         hasSunroofCheckBox = new JCheckBox("Has Sunroof");
        panel.add(hasSunroofCheckBox);

        panel.add(new JLabel("Status:"));
         statusField = new JTextField(20);
        panel.add(statusField);

        panel.add(new JLabel("Model:"));
         modelField = new JTextField(20);
        panel.add(modelField);

        panel.add(new JLabel("Make:"));
         makeField = new JTextField(20);
        panel.add(makeField);

        panel.add(new JLabel("Manufacturing Year:"));
         manufacturingYearField = new JTextField(20);
        panel.add(manufacturingYearField);

        panel.add(new JLabel("Mileage:"));
         mileageField = new JTextField(20);
        panel.add(mileageField);

        panel.add(new JLabel("Parking Lot Number:"));
         parkingLotNumField = new JTextField(20);
        panel.add(parkingLotNumField);

        panel.add(new JLabel("Parking Location:"));
         parkingLocationField = new JTextField(20);
        panel.add(parkingLocationField);



        JButton saveButton = new JButton("Save");

        //panel.add(new JLabel("License Number:"));
        // Add other vehicle fields

        panel.add(new JLabel(""));
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVehicle();
            }
        });

        cardPanel.add(panel, "addVehicleScreen");
    }

    private void createUserHomePage() {
        JPanel panel = new JPanel();
        JButton searchVehicleButton = new JButton("Search Vehicle");

        searchVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle search vehicle functionality
                JOptionPane.showMessageDialog(CarRentalSystemSwing.this, "Implement Search Vehicle functionality for the user.");
            }
        });

        panel.add(searchVehicleButton);

        cardPanel.add(panel, "userHomeScreen");
    }

    private void createSearchVehicleScreen() {
        // Add search vehicle screen components if needed
        // For simplicity, we're not implementing it in this example
    }

    private void handleLogin() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        for (AdminAccountSingleton admin : admins) {
            if (admin.getUserName().equals(username) && admin.getPassword().equals(password)) {
                // Show admin home page
                cardLayout.show(cardPanel, "adminHomeScreen");
                return;
            }
        }

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Show user home page
                cardLayout.show(cardPanel, "userHomeScreen");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
    }

    private void handleRegistration(String username, String password, String accountType) {
        if ("User".equals(accountType)) {
            users.add(new User(username, password));
        } else if ("Admin".equals(accountType)) {
            //admins.add(new Admin(username, password));
            AdminAccountSingleton admin=AdminAccountSingleton.getInstance(UUID.randomUUID().toString(),username,password,"admin");
            admins.add(admin);
        }

        JOptionPane.showMessageDialog(this, "Registration successful", "Registration", JOptionPane.INFORMATION_MESSAGE);
        cardLayout.show(cardPanel, "loginScreen");
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

    private static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    private static class Admin {
        private String username;
        private String password;

        public Admin(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarRentalSystemSwing();
            }
        });
    }
}
