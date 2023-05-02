import java.util.List;

public class CarRentalView {
    public void printCars(List<Car> cars) {
        System.out.println("Available cars for rent:");
        for (Car car : cars) {
            System.out.println(car.getMake() + " " + car.getModel() + " " + car.getYear() + " - " + car.getType() + " - $" + car.getPricePerDay() + " per day");
        }
    }

    public void printBill(Car car, int daysRented, double totalCost) {
        System.out.println("\nRental summary:");
        System.out.println("Car: " + car.getMake() + " " + car.getModel() + " " + car.getYear() + " - " + car.getType());
        System.out.println("Days rented: " + daysRented);
        System.out.println("Total cost: $" + totalCost);
    }
}
