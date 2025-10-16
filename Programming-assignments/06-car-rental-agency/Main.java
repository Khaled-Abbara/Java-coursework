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
            try {
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

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                sc.nextLine(); // clear buffer just in case
            }
        }
    }

    private void createCar() {
        try {
            Car car = new Car();
            System.out.println("\n--- Enter Car Details ---");
            car.setMake(readNonEmpty("Make"));
            car.setModel(readNonEmpty("Model"));
            car.setYear(readPositiveInt("Year"));
            car.setDoorNumber(readPositiveInt("Number of Doors"));
            car.setFuelType(readNonEmpty("Fuel Type"));

            vehicles.add(car);
            System.out.println("Car added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add car. " + e.getMessage());
        }
    }

    private void createMotorcycle() {
        try {
            Motorcycle m = new Motorcycle();
            System.out.println("\n--- Enter Motorcycle Details ---");
            m.setMake(readNonEmpty("Make"));
            m.setModel(readNonEmpty("Model"));
            m.setYear(readPositiveInt("Year"));
            m.setNumberOfWheels(readPositiveInt("Number of Wheels"));
            m.setMotorcycleType(readNonEmpty("Type"));

            vehicles.add(m);
            System.out.println("Motorcycle added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add motorcycle. " + e.getMessage());
        }
    }

    private void createTruck() {
        try {
            Truck t = new Truck();
            System.out.println("\n--- Enter Truck Details ---");
            t.setMake(readNonEmpty("Make"));
            t.setModel(readNonEmpty("Model"));
            t.setYear(readPositiveInt("Year"));
            t.setCargoCapacity(readNonEmpty("Cargo Capacity"));
            t.setTransmissionType(readNonEmpty("Transmission"));

            vehicles.add(t);
            System.out.println("Truck added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add truck. " + e.getMessage());
        }
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

    // ----- Utility Methods -----
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private int readPositiveInt(String label) {
        int value;
        while (true) {
            System.out.print(label + ": ");
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value > 0)
                    return value;
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    private String readNonEmpty(String label) {
        String input;
        do {
            System.out.print(label + ": ");
            input = sc.nextLine().trim();
            if (input.isEmpty())
                System.out.println("This field cannot be empty.");
        } while (input.isEmpty());
        return input;
    }
}
