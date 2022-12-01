package it.unisa.vehiclearchive.gui;

import it.unisa.vehiclearchive.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class VehicleFrame extends JFrame {

    private JPanel motorVehiclePanel;
    private JPanel motorCyclePanel;
    private JComboBox<String> supplyComboBox;
    private JComboBox<Integer> numberOfSeatsComboBox;
    private JComboBox<Integer> yearsComboBox;
    private JComboBox<Integer> numberOfWheelsComboBox;
    private JTextArea textArea;

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 400;

    public VehicleFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(this.createMenu());
        this.createPanel();
    }

    private JMenu createMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem openFileItem = new JMenuItem("Apri File");
        openFileItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(VehicleFrame.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    VehicleGUI.vehicleManager.readUserDataFromFile(fileChooser.getSelectedFile());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (BadDataFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Il file non è nel formato corretto", "Messaggio", JOptionPane.ERROR_MESSAGE);
                }

                updateMotorCycleComponentsWithValue();
                updateMotorVehicleComponentsWithValues();
            }
        });
        fileMenu.add(openFileItem);
        JMenuItem saveFileItem = new JMenuItem("Salva File");
        saveFileItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(VehicleFrame.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    VehicleGUI.vehicleManager.writeUserDataToFile(fileChooser.getSelectedFile(), true);
                } catch (FileNotFoundException | FileAlreadyExistsException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        fileMenu.add(saveFileItem);
        JMenuItem exitItem = new JMenuItem("Esci");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        return fileMenu;
    }

    private void createPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 1));
        topPanel.setBorder(new TitledBorder(new EtchedBorder()));

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new FlowLayout());
        JRadioButton motorVehicleButton = new JRadioButton("Autoveicolo");
        motorVehicleButton.setActionCommand("motorVehicle");
        motorVehicleButton.setSelected(true);
        JRadioButton motorCycleButton = new JRadioButton("Motociclo");
        motorCycleButton.setActionCommand("motorCycle");
        selectPanel.add(motorVehicleButton);
        selectPanel.add(motorCycleButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(motorVehicleButton);
        buttonGroup.add(motorCycleButton);

        RadioListener radioListener = new RadioListener();
        motorVehicleButton.addActionListener(radioListener);
        motorCycleButton.addActionListener(radioListener);

        topPanel.add(selectPanel);

        // Create the panel for motorvehicles
        motorVehiclePanel = new JPanel();
        motorVehiclePanel.setLayout(new FlowLayout());

        JLabel licensePlateLabel = new JLabel("Targa");
        motorVehiclePanel.add(licensePlateLabel);
        JTextField motorVehicleLicensePlate = new JTextField(6);
        motorVehiclePanel.add(motorVehicleLicensePlate);

        JLabel supplyLabel = new JLabel("Alimentazione");
        motorVehiclePanel.add(supplyLabel);
        supplyComboBox = new JComboBox<>();
        motorVehiclePanel.add(supplyComboBox);

        JLabel numberOfSeatsLabel = new JLabel("Numero di posti");
        motorVehiclePanel.add(numberOfSeatsLabel);
        numberOfSeatsComboBox = new JComboBox<>();
        motorVehiclePanel.add(numberOfSeatsComboBox);

        JButton searchMotorVehiclesButton = new JButton("Cerca");
        searchMotorVehiclesButton.addActionListener(e -> {
            if (supplyComboBox.getSelectedIndex() == -1 && numberOfSeatsComboBox.getSelectedIndex() == -1) {
                List<Vehicle> allMotorVehicles = VehicleGUI.vehicleManager.getAllMotorVehicles();
                updateTextArea(allMotorVehicles);
            }
            if (!(motorVehicleLicensePlate.getText().matches("[A-Z]{2}[0-9]{3}[A-Z]{2}"))) {
                try {
                    throw new WrongLicensePlateException();
                } catch (WrongLicensePlateException ex) {
                    JOptionPane.showMessageDialog(VehicleFrame.this,
                            "Formato targa errato", "Messaggio", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                List<Vehicle> filteredMotorVehicles = VehicleGUI.vehicleManager.searchMotorVehicle(motorVehicleLicensePlate.getText(),
                        MotorVehicle.SupplyType.valueOf((String) supplyComboBox.getSelectedItem()),
                        (Integer) numberOfSeatsComboBox.getSelectedItem());
                if (filteredMotorVehicles.isEmpty()) {
                    int result = JOptionPane.showConfirmDialog(VehicleFrame.this,
                            "Nessun autoveicolo con questa targa. Vuoi Inserirlo?",
                            "Selezionare un'opzione",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        InsertMotorVehiclePanel newVehiclePanel = new InsertMotorVehiclePanel();
                        int option = JOptionPane.showConfirmDialog(VehicleFrame.this, newVehiclePanel,
                                "Inserisci nuovo autoveicolo", JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            try {
                                MotorVehicle newVehicle = new MotorVehicle(newVehiclePanel.brandTextField.getText(),
                                        newVehiclePanel.modelTextField.getText(),
                                        newVehiclePanel.licensePlateTextField.getText(),
                                        Integer.parseInt(newVehiclePanel.yearTextField.getText()),
                                        MotorVehicle.SupplyType.valueOf(newVehiclePanel.supplyComboBox.getSelectedItem().toString()),
                                        Integer.parseInt(newVehiclePanel.numberOfDoorsComboBox.getSelectedItem().toString()),
                                        Integer.parseInt(newVehiclePanel.numberOfSeatsComboBox.getSelectedItem().toString()));
                                VehicleGUI.vehicleManager.addVehicle(newVehicle);
                                updateMotorVehicleComponentsWithValues();
                            } catch (WrongLicensePlateException ex) {
                                JOptionPane.showMessageDialog(VehicleFrame.this,
                                        "Formato targa errato", "Messaggio", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } else {
                    updateTextArea(filteredMotorVehicles);
                }
            }
        });
        motorVehiclePanel.add(searchMotorVehiclesButton);
        JButton resetSearchMotorVehiclesButton = new JButton("Reset");
        resetSearchMotorVehiclesButton.addActionListener(e -> {
            motorVehicleLicensePlate.setText("");
            supplyComboBox.setSelectedIndex(-1);
            numberOfSeatsComboBox.setSelectedIndex(-1);
        });
        motorVehiclePanel.add(resetSearchMotorVehiclesButton);

        topPanel.add(motorVehiclePanel);

        // Create the panel for motorcycles
        motorCyclePanel = new JPanel();
        motorCyclePanel.setLayout(new FlowLayout());

        JLabel licensePlateLabel2 = new JLabel("Targa");
        motorCyclePanel.add(licensePlateLabel2);
        JTextField motorCycleLicensePlate = new JTextField(6);
        motorCyclePanel.add(motorCycleLicensePlate);

        JLabel yearLabel = new JLabel("Anno");
        motorCyclePanel.add(yearLabel);
        yearsComboBox = new JComboBox<>();
        motorCyclePanel.add(yearsComboBox);

        JLabel numberOfWheelsLabel = new JLabel("Numero di ruote");
        motorCyclePanel.add(numberOfWheelsLabel);
        numberOfWheelsComboBox = new JComboBox<>();
        motorCyclePanel.add(numberOfWheelsComboBox);

        JButton searchMotorCycleButton = new JButton("Cerca");
        searchMotorCycleButton.addActionListener(e -> {
            if (yearsComboBox.getSelectedIndex() == -1 && numberOfWheelsComboBox.getSelectedIndex() == -1) {
                List<Vehicle> allMotorVehicles = VehicleGUI.vehicleManager.getAllMotorVehicles();
                updateTextArea(allMotorVehicles);
            }
            if (!(motorCycleLicensePlate.getText().matches("[A-Z]{2}[0-9]{5}"))) {
                try {
                    throw new WrongLicensePlateException();
                } catch (WrongLicensePlateException ex) {
                    JOptionPane.showMessageDialog(VehicleFrame.this,
                            "Formato targa errato", "Messaggio", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                List<Vehicle> filteredMotorCycles = VehicleGUI.vehicleManager.searchMotorCycle(motorCycleLicensePlate.getText(),
                        (Integer) yearsComboBox.getSelectedItem(),
                        (Integer) numberOfWheelsComboBox.getSelectedItem());
                if (filteredMotorCycles.isEmpty()) {
                    int result = JOptionPane.showConfirmDialog(VehicleFrame.this,
                            "Nessun ciclomotore con questa targa. Vuoi Inserirlo?",
                            "Selezionare un'opzione",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        InsertMotorCyclePanel newVehiclePanel = new InsertMotorCyclePanel();
                        int option = JOptionPane.showConfirmDialog(VehicleFrame.this, newVehiclePanel,
                                "Inserisci nuovo autoveicolo", JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            try {
                                MotorCycle vehicle = new MotorCycle(newVehiclePanel.brandTextField.getText(),
                                        newVehiclePanel.modelTextField.getText(),
                                        newVehiclePanel.licensePlateTextField.getText(),
                                        Integer.parseInt(newVehiclePanel.yearTextField.getText()),
                                        Integer.parseInt(newVehiclePanel.numberOfWheelsComboBox.getSelectedItem().toString()),
                                        Integer.parseInt(newVehiclePanel.numberOfPassengersComboBox.getSelectedItem().toString()));
                                VehicleGUI.vehicleManager.addVehicle(vehicle);
                                updateMotorCycleComponentsWithValue();
                            } catch (WrongLicensePlateException ex) {
                                JOptionPane.showMessageDialog(VehicleFrame.this,
                                        "Formato targa errato", "Messaggio", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } else {
                    updateTextArea(filteredMotorCycles);
                }
            }
        });
        motorCyclePanel.add(searchMotorCycleButton);
        JButton resetSearchMotorCycleButton = new JButton("Reset");
        resetSearchMotorCycleButton.addActionListener(e -> {
            motorCycleLicensePlate.setText("");
            yearsComboBox.setSelectedIndex(-1);
            numberOfWheelsComboBox.setSelectedIndex(-1);
        });
        motorCyclePanel.add(resetSearchMotorCycleButton);
        motorVehiclePanel.add(resetSearchMotorVehiclesButton);

        motorCyclePanel.setVisible(false);
        topPanel.add(motorCyclePanel);

        this.add(topPanel, BorderLayout.NORTH);

        textArea = new JTextArea(13, 30);
        textArea.setEditable(false);
        this.add(new JScrollPane(textArea), BorderLayout.SOUTH);
    }

    protected void updateMotorVehicleComponentsWithValues() {
        supplyComboBox.removeAllItems();
        for (MotorVehicle.SupplyType supply : VehicleGUI.vehicleManager.getAvailableSupplies()) {
            supplyComboBox.addItem(supply.name());
        }
        supplyComboBox.setSelectedIndex(-1);

        numberOfSeatsComboBox.removeAllItems();
        for (int numberOfSeats : VehicleGUI.vehicleManager.getAvailableNumberOfSeats()) {
            numberOfSeatsComboBox.addItem(numberOfSeats);
        }
        numberOfSeatsComboBox.setSelectedIndex(-1);

        List<Vehicle> allMotorVehicles = VehicleGUI.vehicleManager.getAllMotorVehicles();
        updateTextArea(allMotorVehicles);
    }

    protected void updateMotorCycleComponentsWithValue() {
        yearsComboBox.removeAllItems();
        for (int years : VehicleGUI.vehicleManager.getAvailableYears()) {
            yearsComboBox.addItem(years);
        }
        yearsComboBox.setSelectedIndex(-1);

        numberOfWheelsComboBox.removeAllItems();
        for (int numberOfWheels : VehicleGUI.vehicleManager.getAvailableNumberOfWheels()) {
            numberOfWheelsComboBox.addItem(numberOfWheels);
        }
        numberOfWheelsComboBox.setSelectedIndex(-1);

        List<Vehicle> allMotorCycles = VehicleGUI.vehicleManager.getAllMotorCycles();
        updateTextArea(allMotorCycles);
    }

    private void updateTextArea(List<Vehicle> vehicles) {
        textArea.setText("");
        for (Vehicle v : vehicles) {
            textArea.append(v.toString() + "\n");
        }
    }

    class RadioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "motorVehicle" -> {
                    motorVehiclePanel.setVisible(true);
                    motorCyclePanel.setVisible(false);
                    List<Vehicle> allMotorVehicles = VehicleGUI.vehicleManager.getAllMotorVehicles();
                    updateTextArea(allMotorVehicles);
                }
                case "motorCycle" -> {
                    motorVehiclePanel.setVisible(false);
                    motorCyclePanel.setVisible(true);
                    List<Vehicle> allMotorCycles = VehicleGUI.vehicleManager.getAllMotorCycles();
                    updateTextArea(allMotorCycles);
                }
            }
        }
    }

}
