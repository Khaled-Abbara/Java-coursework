import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
}

interface Vehicle {
    // getters
    String getMake();

    String getModel();

    int getYear();

    // setters
    void setMake(String make);

    void setModel(String model);

    void setYear(int year);
}

interface CarVehicle {
    // getters
    int getDoorNumber();

    String getFuelType();

    // setters
    void setDoorNumber(int doorNumber);

    void setFuelType(String fuelType);
}

interface MotorVehicle {
    // getters
    int getNumberOfWheels();

    String getMotorcycleType();

    // setters
    void setNumberOfWheels(int numberOfWheels);

    void setMotorcycleType(String motorcycleType);
}

interface TruckVehicle {
    // getters
    String getCargoCapacity();

    String getTransmissionType();

    // setters
    void setCargoCapacity(String cargoCapacity);

    void setTransmissionType(String transmissionType);
}

// ====================== Car ======================
class Car implements Vehicle, CarVehicle {
    private String make;
    private String model;
    private int year;
    private int doorNumber;
    private String fuelType;

    // getters
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getDoorNumber() {
        return doorNumber;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    // setters
    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}

// ====================== MotorCycle ======================
class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

    // getters
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }

    // setters
    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void setMotorcycleType(String motorcycleType) {
        this.motorcycleType = motorcycleType;
    }
}

// ====================== Truck ======================
class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int year;
    private String cargoCapacity;
    private String transmissionType;

    // getters
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    // setters
    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}

class VehicleInformationSystem {
    private Scanner sc;

    public VehicleInformationSystem() {
        sc = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        System.out.println("===== Vehicle Information System =====");

        while (!exit) {
            System.out.println("\nSelect the type of vehicle to create:");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Truck");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    createCar();
                    break;
                case 2:
                    createMotorcycle();
                    break;
                case 3:
                    createTruck();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1–4.");
            }
        }
    }

    // Create a Car object and display details
    private void createCar() {
        Car car = new Car();

        System.out.println("\n--- Enter Car Details ---");
        System.out.print("Make: ");
        car.setMake(sc.nextLine());

        System.out.print("Model: ");
        car.setModel(sc.nextLine());

        System.out.print("Year of Manufacture: ");
        car.setYear(readInt());

        System.out.print("Number of Doors: ");
        car.setDoorNumber(readInt());

        System.out.print("Fuel Type (Petrol/Diesel/Electric): ");
        car.setFuelType(sc.nextLine());

        System.out.println("\n--- Car Information ---");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Doors: " + car.getDoorNumber());
        System.out.println("Fuel Type: " + car.getFuelType());
    }

    // Create a Motorcycle object and display details
    private void createMotorcycle() {
        Motorcycle motorcycle = new Motorcycle();

        System.out.println("\n--- Enter Motorcycle Details ---");
        System.out.print("Make: ");
        motorcycle.setMake(sc.nextLine());

        System.out.print("Model: ");
        motorcycle.setModel(sc.nextLine());

        System.out.print("Year of Manufacture: ");
        motorcycle.setYear(readInt());

        System.out.print("Number of Wheels: ");
        motorcycle.setNumberOfWheels(readInt());

        System.out.print("Motorcycle Type (Sport/Cruiser/Off-road): ");
        motorcycle.setMotorcycleType(sc.nextLine());

        System.out.println("\n--- Motorcycle Information ---");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Wheels: " + motorcycle.getNumberOfWheels());
        System.out.println("Type: " + motorcycle.getMotorcycleType());
    }

    // Create a Truck object and display details
    private void createTruck() {
        Truck truck = new Truck();

        System.out.println("\n--- Enter Truck Details ---");
        System.out.print("Make: ");
        truck.setMake(sc.nextLine());

        System.out.print("Model: ");
        truck.setModel(sc.nextLine());

        System.out.print("Year of Manufacture: ");
        truck.setYear(readInt());

        System.out.print("Cargo Capacity (in tons): ");
        truck.setCargoCapacity(sc.nextLine());

        System.out.print("Transmission Type (Manual/Automatic): ");
        truck.setTransmissionType(sc.nextLine());

        System.out.println("\n--- Truck Information ---");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity());
        System.out.println("Transmission: " + truck.getTransmissionType());
    }

    // Safely read integers with exception handling
    private int readInt() {
        int value;
        while (true) {
            value = sc.nextInt();
            sc.nextLine(); // consume newline
            break;
        }
        return value;
    }
}