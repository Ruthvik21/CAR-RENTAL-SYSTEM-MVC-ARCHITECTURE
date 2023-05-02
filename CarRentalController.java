import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalController {
    private static CarRentalController instance = null;
    private Connection connection = null;

    private CarRentalController() {
        // Initialize the database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/car_rental_system";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CarRentalController getInstance() {
        if (instance == null) {
            instance = new CarRentalController();
        }
        return instance;
    }

    public List<Car> getCars() {
        List<Car> availableCars = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM cars WHERE rented = false";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String type = resultSet.getString("type");
                int year = resultSet.getInt("year");
                double pricePerDay = resultSet.getDouble("price_per_day");
                Car car = CarFactory.createCar(id, make, model, type, year, pricePerDay);
                availableCars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableCars;
    }

    public void rentCar() {
        List<Car> availableCars = getCars();
        if (availableCars.isEmpty()) {
            System.out.println("Sorry, there are no available cars to rent.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Cars:");
        for (int i = 0; i < availableCars.size(); i++) {
            Car car = availableCars.get(i);
            System.out.println((i + 1) + ". " + car.getMake() + " " + car.getModel() + " (" + car.getType() + ")");
        }

        int carIndex;
        do {
            System.out.print("Select a car to rent (1-" + availableCars.size() + "): ");
            carIndex = scanner.nextInt();
        } while (carIndex < 1 || carIndex > availableCars.size());

        Car car = availableCars.get(carIndex - 1);

        int daysRented;
        do {
            System.out.print("Enter the number of days to rent the " + car.getMake() + " " + car.getModel() + ": ");
            daysRented = scanner.nextInt();
        } while (daysRented < 1);

        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE cars SET rented = true WHERE id = " + car.getId();
            statement.executeUpdate(query);

            double totalPrice = daysRented * car.getPricePerDay();
            System.out.println("Rental Summary:");
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Type: " + car.getType());
            System.out.println("Year: " + car.getYear());
            System.out.println("Days Rented: " + daysRented);
            System.out.println("Price Per Day: " + car.getPricePerDay());
            System.out.println("Total Price:" + totalPrice);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
