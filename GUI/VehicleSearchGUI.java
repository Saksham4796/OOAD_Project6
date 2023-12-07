package GUI;

import ObserverForNotification.EmailConfirmation;
import ObserverForNotification.SMSConfirmation;
import ParkingSpace.Parking;
import Reservation.VehicleReservation;
import SearchVehicle.VehicleInventory;
import Vehicles.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class VehicleSearchGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JTextField searchTypeField;
    private JTable resultTable;
    private JButton reservationButton;

    private JTextField licenseNumField;
    private JTextField startTimeField;
    private JTextField endTimeField;

    public VehicleSearchGUI() {
        setTitle("Vehicle Reservation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create CardLayout and JPanel to hold cards
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Card for the main screen
        JPanel mainScreen = createMainScreen();
        cardPanel.add(mainScreen, "mainScreen");

        // Card for the search screen
        JPanel searchScreen = createSearchScreen();
        cardPanel.add(searchScreen, "searchScreen");

        // Card for the reservation screen
        JPanel reservationScreen = createReservationScreen();
        cardPanel.add(reservationScreen, "reservationScreen");

        // Set up the layout
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // Initially show the main screen
        cardLayout.show(cardPanel, "mainScreen");
    }

    private JPanel createMainScreen() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton searchButton = new JButton("Search");
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the "searchScreen" when the button is clicked
                cardLayout.show(cardPanel, "searchScreen");
            }
        });

        return panel;
    }

    private JPanel createSearchScreen() {
        JPanel panel = new JPanel(new BorderLayout());

        searchTypeField = new JTextField(20);
        JButton searchTypeButton = new JButton("Search");
        resultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        reservationButton = new JButton("Reservation");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Vehicle Type:"));
        inputPanel.add(searchTypeField);
        inputPanel.add(searchTypeButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(reservationButton, BorderLayout.SOUTH);

        searchTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the "reservationScreen" when the button is clicked
                cardLayout.show(cardPanel, "reservationScreen");

                // Populate reservation screen with selected vehicle data
                populateReservationScreen();
            }
        });

        return panel;
    }

    private void performSearch() {
        // Simulate searching and getting results
        String searchType = searchTypeField.getText();
        ArrayList<Vehicle> searchResults = getSearchResults(searchType);

        // Display the results in the table
        displayResults(searchResults);
    }

    private ArrayList<Vehicle> getSearchResults(String searchType) {
        // Simulate retrieving search results from a database or other source
        // In a real application, you would perform a database query here
        // and return a list of Vehicle objects based on the search criteria

        return new VehicleInventory().searchByType(searchType);
    }

    private void displayResults(ArrayList<Vehicle> searchResults) {
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the table model
        model.addColumn("License Plate");
        model.addColumn("Type");
        model.addColumn("Make");
        model.addColumn("Model");

        // Add rows to the table model
        for (Vehicle vehicle : searchResults) {
            Object[] row = {
                    vehicle.getLicensePlate(),
                    vehicle.getModel(),
                    vehicle.getMake(),
                    vehicle.getCapacity()
            };
            model.addRow(row);
        }

        // Set the table model
        resultTable.setModel(model);
    }



    private JPanel createReservationScreen() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        licenseNumField = new JTextField(20);
        startTimeField = new JTextField(20);
        endTimeField = new JTextField(20);
        JButton reserveButton = new JButton("Reserve");

        panel.add(new JLabel("License Number:"));
        panel.add(licenseNumField);
        panel.add(new JLabel("Start Time:"));
        panel.add(startTimeField);
        panel.add(new JLabel("End Time:"));
        panel.add(endTimeField);
        panel.add(new JLabel(""));
        panel.add(reserveButton);

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logic to reserve the vehicle (displaying a message for simplicity)
                String message = "Vehicle Reserved:\n" +
                        "License Number: " + licenseNumField.getText() + "\n" +
                        "Start Time: " + startTimeField.getText() + "\n" +
                        "End Time: " + endTimeField.getText();

                JOptionPane.showMessageDialog(VehicleSearchGUI.this, message, "Reservation Complete", JOptionPane.INFORMATION_MESSAGE);

                // Switch back to the main screen
                cardLayout.show(cardPanel, "mainScreen");
                String uniqueID = UUID.randomUUID().toString();
                VehicleReservation reservation=new VehicleReservation();
                reservation.addConfirmationObserver(new EmailConfirmation(reservation));
                reservation.addConfirmationObserver(new SMSConfirmation(reservation));
                reservation.makeReservation(uniqueID,startTimeField.getText(), endTimeField.getText(), licenseNumField.getText(),
                        new Parking(12,"X"), new Parking(12,"X"));
            }
        });

        return panel;
    }

    private void populateReservationScreen() {
        // Get the selected row from the table
        int selectedRow = resultTable.getSelectedRow();

        if (selectedRow != -1) {
            // Retrieve values from the selected row and populate the reservation screen
            licenseNumField.setText(resultTable.getValueAt(selectedRow, 0).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Please select a vehicle for reservation.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            cardLayout.show(cardPanel, "searchScreen"); // Switch back to the search screen if no vehicle is selected
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VehicleSearchGUI().setVisible(true);
            }
        });
    }

    // A simple Vehicle class for demonstration purposes

}
