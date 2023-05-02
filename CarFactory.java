public class CarFactory {
public static Car createCar(int id,String make, String model, String type, int year, double pricePerDay) {
return new Car(id,make, model, type, year, pricePerDay);
}
}
