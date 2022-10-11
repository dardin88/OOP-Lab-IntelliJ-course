import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSeller {
    private final List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String brand = input.nextLine();
            String model = input.nextLine();
            int manufacturingYear = Integer.parseInt(input.nextLine());
            double price = Double.parseDouble(input.nextLine());
            Car car = new Car(brand, model, manufacturingYear, price);
            this.cars.add(car);
        }
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