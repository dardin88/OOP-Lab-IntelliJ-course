package it.unisa.vehiclearchive.gui;

import it.unisa.vehiclearchive.MotorVehicle;

import javax.swing.*;
import java.awt.*;

public class InsertMotorVehiclePanel extends JPanel {

    protected final JTextField brandTextField;
    protected final JTextField modelTextField;
    protected final JTextField licensePlateTextField;
    protected final JTextField yearTextField;
    protected final JComboBox<String> supplyComboBox;
    protected final JComboBox<Integer> numberOfDoorsComboBox;
    protected final JComboBox<Integer> numberOfSeatsComboBox;

    public InsertMotorVehiclePanel() {
        this.setLayout(new GridLayout(8, 1));

        JPanel brandPanel = new JPanel();
        brandPanel.setLayout(new FlowLayout());
        JLabel brandLabel = new JLabel("Marca");
        brandPanel.add(brandLabel);
        brandTextField = new JTextField(10);
        brandPanel.add(brandTextField);
        this.add(brandPanel);

        JPanel modelPanel = new JPanel();
        modelPanel.setLayout(new FlowLayout());
        JLabel modelLabel = new JLabel("Modello");
        modelPanel.add(modelLabel);
        modelTextField = new JTextField(10);
        modelPanel.add(modelTextField);
        this.add(modelPanel);

        JPanel licensePanel = new JPanel();
        licensePanel.setLayout(new FlowLayout());
        JLabel licensePlateLabel = new JLabel("Targa");
        licensePanel.add(licensePlateLabel);
        licensePlateTextField = new JTextField(6);
        licensePanel.add(licensePlateTextField);
        this.add(licensePanel);

        JPanel yearPanel = new JPanel();
        yearPanel.setLayout(new FlowLayout());
        JLabel yearLabel = new JLabel("Anno");
        yearPanel.add(yearLabel);
        yearTextField = new JTextField(4);
        yearPanel.add(yearTextField);
        this.add(yearPanel);

        JPanel supplyPanel = new JPanel();
        supplyPanel.setLayout(new FlowLayout());
        JLabel supplyLabel = new JLabel("Alimentazione");
        supplyPanel.add(supplyLabel);
        supplyComboBox = new JComboBox<>();
        for (MotorVehicle.SupplyType st : MotorVehicle.SupplyType.values()) {
            supplyComboBox.addItem(st.name());
        }
        supplyPanel.add(supplyComboBox);
        this.add(supplyPanel);

        JPanel numberOfDoorsPanel = new JPanel();
        numberOfDoorsPanel.setLayout(new FlowLayout());
        JLabel numberOfDoorsLabel = new JLabel("Numero di porte");
        numberOfDoorsPanel.add(numberOfDoorsLabel);
        numberOfDoorsComboBox = new JComboBox<>();
        numberOfDoorsComboBox.addItem(3);
        numberOfDoorsComboBox.addItem(5);
        numberOfDoorsPanel.add(numberOfDoorsComboBox);
        this.add(numberOfDoorsPanel);

        JPanel numberOfSeatsPanel = new JPanel();
        numberOfSeatsPanel.setLayout(new FlowLayout());
        JLabel numberOfSeatsLabel = new JLabel("Numero di posti");
        numberOfSeatsPanel.add(numberOfSeatsLabel);
        numberOfSeatsComboBox = new JComboBox<>();
        numberOfSeatsComboBox.addItem(4);
        numberOfSeatsComboBox.addItem(5);
        numberOfSeatsPanel.add(numberOfSeatsComboBox);
        this.add(numberOfSeatsPanel);
    }

}
