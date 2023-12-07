package it.unisa.vehiclearchive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class VehicleManager {

    private List<Vehicle> vehicleList;

    public VehicleManager() {
        this.vehicleList = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.vehicleList = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            try {
                String vehicleLine = input.nextLine();
                String[] vehicleValues = vehicleLine.split(",");
                String brand = vehicleValues[0];
                String model = vehicleValues[1];
                String licensePlate = vehicleValues[2];
                int year = Integer.parseInt(vehicleValues[3]);
                if (vehicleValues.length == 7) {
                    MotorVehicle.SupplyType supply = MotorVehicle.SupplyType.valueOf(vehicleValues[4]);
                    int numberOfDoors = Integer.parseInt(vehicleValues[5]);
                    int numberOfSeats = Integer.parseInt(vehicleValues[6]);
                    MotorVehicle motorVehicle = new MotorVehicle(brand, model, licensePlate, year, supply, numberOfDoors, numberOfSeats);
                    this.vehicleList.add(motorVehicle);
                } else if (vehicleValues.length == 6) {
                    int numberOfWheels = Integer.parseInt(vehicleValues[4]);
                    int numberOfPassengers = Integer.parseInt(vehicleValues[5]);
                    MotorCycle motorCycle = new MotorCycle(brand, model, licensePlate, year, numberOfWheels, numberOfPassengers);
                    this.vehicleList.add(motorCycle);
                } else {
                    throw new BadDataFormatException();
                }
            } catch (NoSuchElementException | NumberFormatException ex) {
                throw new BadDataFormatException();
            } catch (WrongLicensePlateException e) {
                throw new RuntimeException(e);
            }
        }
        input.close();
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if (!overwrite) {
            if (file.exists()) {
                throw new FileAlreadyExistsException("Il file già esiste!");
            } else {
                writeUserDataToFile(file);
            }
        } else {
            String tmpFileName = file.getParentFile().getAbsolutePath() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(tmpFileName);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(file);
        for (Vehicle vehicle : this.vehicleList) {
            output.print(vehicle.getBrand());
            output.print("," + vehicle.getModel());
            output.print("," + vehicle.getLicensePlate());
            output.print("," + vehicle.getYear());
            if (vehicle instanceof MotorVehicle) {
                output.print("," + ((MotorVehicle) vehicle).getSupply().name());
                output.print("," + ((MotorVehicle) vehicle).getNumberOfDoors());
                output.print("," + ((MotorVehicle) vehicle).getNumberOfSeats());
            } else if (vehicle instanceof MotorCycle) {
                output.print("," + ((MotorCycle) vehicle).getNumberOfWheels());
                output.print("," + ((MotorCycle) vehicle).getNumberoOfPassengers());
            }
            output.print("\n");
        }
        output.close();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public List<Vehicle> searchMotorVehicle(String licensePlate, MotorVehicle.SupplyType supply, int numberOfSeats) {
        List<Vehicle> filteredMotorVehicles = new ArrayList<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorVehicle mv) {
                if (mv.getLicensePlate().equals(licensePlate) &&
                        mv.getSupply().equals(supply) &&
                        mv.getNumberOfSeats() == numberOfSeats)
                    filteredMotorVehicles.add(mv);
            }
        }
        return filteredMotorVehicles;
    }

    public List<Vehicle> searchMotorCycle(String licensePlate, int year, int numberOfWheels) {
        List<Vehicle> filteredMotorCycles = new ArrayList<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorCycle mc) {
                if (mc.getLicensePlate().equals(licensePlate)
                        && mc.getYear() == year
                        && mc.getNumberOfWheels() == numberOfWheels)
                    filteredMotorCycles.add(mc);
            }
        }
        return filteredMotorCycles;
    }

    public List<Vehicle> getAllMotorVehicles() {
        List<Vehicle> motorVehicles = new ArrayList<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorVehicle mv) {
                motorVehicles.add(mv);
            }
        }
        return motorVehicles;
    }

    public List<Vehicle> getAllMotorCycles() {
        List<Vehicle> motorCycles = new ArrayList<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorCycle mc) {
                motorCycles.add(mc);
            }
        }
        return motorCycles;
    }

    public Set<MotorVehicle.SupplyType> getAvailableSupplies() {
        Set<MotorVehicle.SupplyType> supplySet = new HashSet<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorVehicle mv) {
                supplySet.add(mv.getSupply());
            }
        }
        return supplySet;
    }

    public Set<Integer> getAvailableNumberOfSeats() {
        Set<Integer> numberOfSeatsSet = new HashSet<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorVehicle mv) {
                numberOfSeatsSet.add(mv.getNumberOfSeats());
            }
        }
        return numberOfSeatsSet;
    }

    public Set<Integer> getAvailableYears() {
        Set<Integer> yearSet = new HashSet<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorCycle mc) {
                yearSet.add(mc.getYear());
            }
        }
        return yearSet;
    }

    public Set<Integer> getAvailableNumberOfWheels() {
        Set<Integer> numberOfWheelsSet = new HashSet<>();
        for (Vehicle vehicle : this.vehicleList) {
            if (vehicle instanceof MotorCycle mc) {
                numberOfWheelsSet.add(mc.getNumberOfWheels());
            }
        }
        return numberOfWheelsSet;
    }

}
