package it.unisa.carseller;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class CarSeller {
    private List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.cars = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            try {
                String brand = input.nextLine();
                String model = input.nextLine();
                int manufacturingYear = Integer.parseInt(input.nextLine());
                double price = Double.parseDouble(input.nextLine());
                Car car = new Car(brand, model, manufacturingYear, price);
                this.cars.add(car);
            } catch (NoSuchElementException | NumberFormatException ex) {
                System.err.println("Il formato del file è errato!");
                ex.printStackTrace();
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
            String tmpFileName = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(tmpFileName);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(file);
        for (Car car : this.cars) {
            output.println(car.getBrand());
            output.println(car.getModel());
            output.println(car.getManufacturingYear());
            output.println(car.getPrice());
        }
        output.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.cars = (List<Car>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(this.cars);
        output.close();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> returnCarByBrandAndModel(String brand, String model) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand) && car.getModel().equals(model)) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandModelAndYear(String brand, String model, int manufacturingYear) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandAModelYearAndPrice(String brand, String model, int manufacturingYear, int minPrice, int maxPrice) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear
                    && car.getPrice() >= minPrice
                    && car.getPrice() <= maxPrice) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
}