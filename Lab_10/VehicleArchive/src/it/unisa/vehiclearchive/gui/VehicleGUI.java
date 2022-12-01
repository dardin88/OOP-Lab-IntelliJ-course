package it.unisa.vehiclearchive.gui;

import it.unisa.vehiclearchive.VehicleManager;

import javax.swing.*;

public class VehicleGUI {

    protected final static VehicleManager vehicleManager = new VehicleManager();

    public static void main(String[] args) {
        JFrame vehicleFrame = new VehicleFrame();
        vehicleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vehicleFrame.setVisible(true);
    }
}
