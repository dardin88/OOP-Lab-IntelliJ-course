package it.unisa.vehiclearchive.gui;

import javax.swing.*;
import java.awt.*;

public class InsertMotorCyclePanel extends JPanel {

    protected final JTextField brandTextField;
    protected final JTextField modelTextField;
    protected final JTextField licensePlateTextField;
    protected final JTextField yearTextField;
    protected final JComboBox<Integer> numberOfWheelsComboBox;
    protected final JComboBox<Integer> numberOfPassengersComboBox;

    public InsertMotorCyclePanel() {
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

        JPanel numberOfWheelsPanel = new JPanel();
        numberOfWheelsPanel.setLayout(new FlowLayout());
        JLabel numberOfDoorsLabel = new JLabel("Numero di ruote");
        numberOfWheelsPanel.add(numberOfDoorsLabel);
        numberOfWheelsComboBox = new JComboBox<>();
        numberOfWheelsComboBox.addItem(2);
        numberOfWheelsComboBox.addItem(3);
        numberOfWheelsPanel.add(numberOfWheelsComboBox);
        this.add(numberOfWheelsPanel);

        JPanel numberOfPassengersPanel = new JPanel();
        numberOfPassengersPanel.setLayout(new FlowLayout());
        JLabel numberOfPassengersLabel = new JLabel("Numero di passeggeri");
        numberOfPassengersPanel.add(numberOfPassengersLabel);
        numberOfPassengersComboBox = new JComboBox<>();
        numberOfPassengersComboBox.addItem(1);
        numberOfPassengersComboBox.addItem(2);
        numberOfPassengersPanel.add(numberOfPassengersComboBox);
        this.add(numberOfPassengersPanel);
    }

}
