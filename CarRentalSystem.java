import java.util.List;
public class CarRentalSystem {
public static void main(String[] args) {
CarRentalController controller = CarRentalController.getInstance();
CarRentalView view = new CarRentalView();
List<Car> availableCars = controller.getCars();
view.printCars(availableCars);
controller.rentCar();
}
}