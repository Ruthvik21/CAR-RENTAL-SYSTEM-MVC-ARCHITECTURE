public class Car {
    private String make;
    private String model;
    private String type;
    private int year;
    private double pricePerDay;
    private boolean rented;
    private int id;

    public Car(int id,String make, String model, String type, int year, double pricePerDay) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.rented = false;
        this.id=id;
    }

    public String getMake() {
        return make;
    }
    
    public int getId() {
    	return id;
    }
    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
