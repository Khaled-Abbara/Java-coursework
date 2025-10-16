import java.util.*;

// ====================== Main ======================
public class Main {
    public static void main(String[] args) {
        VehicleInformationSystem vis = new VehicleInformationSystem();
        vis.start();
    }
}

// ====================== Interfaces ======================
interface Vehicle {
    String getMake();

    String getModel();

    int getYear();

    void setMake(String make);

    void setModel(String model);

    void setYear(int year);
}

interface CarVehicle {
    int getDoorNumber();

    String getFuelType();

    void setDoorNumber(int doorNumber);

    void setFuelType(String fuelType);
}

interface MotorVehicle {
    int getNumberOfWheels();

    String getMotorcycleType();

    void setNumberOfWheels(int numberOfWheels);

    void setMotorcycleType(String motorcycleType);
}

interface TruckVehicle {
    String getCargoCapacity();

    String getTransmissionType();

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

    @Override
    public String toString() {
        return "Car - " + make + " " + model + " (" + year + "), Doors: " + doorNumber + ", Fuel: " + fuelType;
    }
}

// ====================== Motorcycle ======================
class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

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

    @Override
    public String toString() {
        return "Motorcycle - " + make + " " + model + " (" + year + "), Wheels: " + numberOfWheels + ", Type: "
                + motorcycleType;
    }
}

// ====================== Truck ======================
class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int year;
    private String cargoCapacity;
    private String transmissionType;

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

    @Override
    public String toString() {
        return "Truck - " + make + " " + model + " (" + year + "), Capacity: " + cargoCapacity + ", Transmission: "
                + transmissionType;
    }
}

// ====================== VehicleInformationSystem ======================
class VehicleInformationSystem {
    private Scanner sc;
    private List<Vehicle> vehicles; // store all vehicles

    public VehicleInformationSystem() {
        sc = new Scanner(System.in);
        vehicles = new ArrayList<>();
    }

    public void start() {
        boolean exit = false;
        System.out.println("===== Vehicle Information System =====");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Car");
            System.out.println("2. Add Motorcycle");
            System.out.println("3. Add Truck");
            System.out.println("4. View All Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> createCar();
                case 2 -> createMotorcycle();
                case 3 -> createTruck();
                case 4 -> viewVehicles();
                case 5 -> {
                    System.out.println("Exiting program. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please select 1–5.");
            }
        }
    }

    private void createCar() {
        Car car = new Car();
        System.out.println("\n--- Enter Car Details ---");
        System.out.print("Make: ");
        car.setMake(sc.nextLine());
        System.out.print("Model: ");
        car.setModel(sc.nextLine());
        System.out.print("Year: ");
        car.setYear(readInt());
        System.out.print("Number of Doors: ");
        car.setDoorNumber(readInt());
        System.out.print("Fuel Type: ");
        car.setFuelType(sc.nextLine());

        vehicles.add(car);
        System.out.println("✅ Car added successfully!");
    }

    private void createMotorcycle() {
        Motorcycle m = new Motorcycle();
        System.out.println("\n--- Enter Motorcycle Details ---");
        System.out.print("Make: ");
        m.setMake(sc.nextLine());
        System.out.print("Model: ");
        m.setModel(sc.nextLine());
        System.out.print("Year: ");
        m.setYear(readInt());
        System.out.print("Number of Wheels: ");
        m.setNumberOfWheels(readInt());
        System.out.print("Type: ");
        m.setMotorcycleType(sc.nextLine());

        vehicles.add(m);
        System.out.println("✅ Motorcycle added successfully!");
    }

    private void createTruck() {
        Truck t = new Truck();
        System.out.println("\n--- Enter Truck Details ---");
        System.out.print("Make: ");
        t.setMake(sc.nextLine());
        System.out.print("Model: ");
        t.setModel(sc.nextLine());
        System.out.print("Year: ");
        t.setYear(readInt());
        System.out.print("Cargo Capacity: ");
        t.setCargoCapacity(sc.nextLine());
        System.out.print("Transmission: ");
        t.setTransmissionType(sc.nextLine());

        vehicles.add(t);
        System.out.println("✅ Truck added successfully!");
    }

    private void viewVehicles() {
        System.out.println("\n===== Stored Vehicles =====");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles have been added yet.");
        } else {
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println((i + 1) + ". " + vehicles.get(i));
            }
        }
    }

    private int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
