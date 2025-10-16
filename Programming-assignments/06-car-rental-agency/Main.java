
/**
 * ================================================================
 *                      VEHICLE INFORMATION SYSTEM (VIS)
 * ================================================================
 *
 *
 * ---------------------------------------------------------------
 * 1. INTRODUCTION
 * ---------------------------------------------------------------
 * The Vehicle Information System (VIS) is a modular, console-based Java
 * application that demonstrates core Object-Oriented Programming (OOP)
 * concepts. It enables users to create, manage, and view information about
 * multiple types of vehicles—Cars, Motorcycles, and Trucks—through a
 * structured command-line interface.
 *
 * The program emphasizes software engineering principles such as
 * abstraction, encapsulation, polymorphism, and error handling. Its design
 * is rooted in interface-driven architecture, ensuring a scalable, flexible,
 * and maintainable system for managing various vehicle data models.
 *
 * ---------------------------------------------------------------
 * 2. CORE FUNCTIONALITIES
 * ---------------------------------------------------------------
 * The Vehicle Information System provides the following capabilities:
 *   • Add new vehicle entries for Cars, Motorcycles, or Trucks.
 *   • Store vehicle objects dynamically in memory using an ArrayList.
 *   • Retrieve and display all stored vehicles in a formatted, readable list.
 *   • Validate user input to ensure data consistency and program stability.
 *   • Provide a simple, user-friendly console menu for interaction.
 *
 * Each feature contributes to a cohesive demonstration of OOP and program
 * design best practices suitable for educational and practical applications.
 *
 * ---------------------------------------------------------------
 * 3. HOW TO RUN THE PROGRAM
 * ---------------------------------------------------------------
 * Step 1: Compile the Java source file
 *         > javac Main.java
 *
 * Step 2: Execute the compiled class
 *         > java Main
 *
 * Step 3: Follow the on-screen menu options:
 *         1. Add Car
 *         2. Add Motorcycle
 *         3. Add Truck
 *         4. View All Vehicles
 *         5. Exit
 *
 * All inputs are text-based. The system validates entries and prevents
 * incorrect or empty values to ensure a robust user experience.
 *
 * ---------------------------------------------------------------
 * 4. PROGRAM STRUCTURE OVERVIEW
 * ---------------------------------------------------------------
 * The Vehicle Information System is organized into modular components:
 *
 * (a) Main Class (Main.java)
 *     • Acts as the program’s entry point.
 *     • Instantiates and runs the VehicleInformationSystem class.
 *
 * (b) Interfaces:
 *     • Vehicle – Defines the foundational attributes shared by all vehicles
 *       (make, model, and year).
 *     • CarVehicle – Extends Vehicle behavior with car-specific attributes
 *       (door number and fuel type).
 *     • MotorVehicle – Defines properties unique to motorcycles
 *       (wheel count and motorcycle type).
 *     • TruckVehicle – Defines properties unique to trucks
 *       (cargo capacity and transmission type).
 *
 * (c) Implementation Classes:
 *     • Car – Implements Vehicle and CarVehicle interfaces.
 *     • Motorcycle – Implements Vehicle and MotorVehicle interfaces.
 *     • Truck – Implements Vehicle and TruckVehicle interfaces.
 *       Each class contains private fields, getter/setter methods, and a
 *       toString() override for descriptive display output.
 *
 * (d) Controller Class:
 *     • VehicleInformationSystem – Manages data input, storage, and output.
 *       Handles user commands, validates data, and interacts with the user
 *       through a CLI-driven menu.
 *
 * (e) Utility Methods:
 *     • readInt(), readPositiveInt(), readNonEmpty()
 *       Handle validated user input to ensure safe, correct data processing.
 *
 * ---------------------------------------------------------------
 * 5. INTERFACE DESIGN
 * ---------------------------------------------------------------
 * The interface design in the Vehicle Information System provides a clear
 * and consistent contract for all vehicle types. Each interface defines
 * getter and setter methods for specific attributes, ensuring uniformity
 * across all implementations. This abstraction:
 *
 *   • Promotes reusability and code clarity by separating behavior from
 *     implementation.
 *   • Encourages scalability—new vehicle types can be added easily by
 *     implementing the existing interface structures.
 *   • Guarantees that all vehicle objects, regardless of type, support a
 *     consistent set of operations for data retrieval and modification.
 *
 * The use of interfaces enhances flexibility and promotes cleaner
 * architectural layering, allowing for polymorphic handling of different
 * vehicle objects.
 *
 * ---------------------------------------------------------------
 * 6. CLASS IMPLEMENTATION
 * ---------------------------------------------------------------
 * Each concrete vehicle class (Car, Motorcycle, Truck) translates the
 * interface specifications into tangible, functional code. The classes:
 *
 *   • Contain private attributes that reflect the properties defined by
 *     the interfaces, ensuring encapsulation and data protection.
 *   • Provide public getters and setters to safely access and modify data.
 *   • Override the toString() method to deliver human-readable summaries
 *     of each vehicle’s details when displayed.
 *
 * This approach combines abstraction with implementation, creating a
 * practical model that accurately represents real-world entities while
 * adhering to software design principles.
 *
 * ---------------------------------------------------------------
 * 7. MAIN PROGRAM AND SYSTEM FLOW
 * ---------------------------------------------------------------
 * The main program serves as the interactive layer between the user and
 * the system’s core functionality. Its flow is as follows:
 *
 *   1. The program launches and displays a numbered menu.
 *   2. The user selects an option corresponding to a vehicle type or action.
 *   3. The system prompts for detailed input fields (validated for accuracy).
 *   4. The data is used to instantiate the appropriate vehicle class.
 *   5. The vehicle object is stored in an ArrayList for future access.
 *   6. Users may view all stored entries or exit the program.
 *
 * The process is iterative, meaning users can continuously add and review
 * vehicle records without restarting the program. This design ensures
 * efficient, logical user interaction and system responsiveness.
 *
 * ---------------------------------------------------------------
 * 8. CODE QUALITY AND DESIGN PRINCIPLES
 * ---------------------------------------------------------------
 * The code quality of the Vehicle Information System adheres to Java
 * industry best practices, emphasizing:
 *
 *   • Readability:
 *       - Consistent indentation and naming conventions.
 *       - Logical grouping of code into sections with clear method roles.
 *
 *   • Maintainability:
 *       - Modular structure enabling future updates and extensions.
 *       - Clear separation of data, logic, and user interaction layers.
 *
 *   • Scalability:
 *       - Interface-driven design allows easy introduction of new vehicle
 *         types without modifying core logic.
 *       - Utility methods centralize validation logic for reusability.
 *
 *   • Reusability:
 *       - Common interface contracts allow polymorphic operations across
 *         multiple classes.
 *       - Utility functions and consistent patterns reduce code redundancy.
 *
 * The program’s object-oriented design enables smooth collaboration and
 * long-term maintainability, ensuring the codebase remains clean and
 * adaptable as it evolves.
 *
 * ---------------------------------------------------------------
 * 9. ERROR HANDLING AND VALIDATION
 * ---------------------------------------------------------------
 * The Vehicle Information System incorporates a robust error-handling
 * framework that safeguards against invalid input and unexpected runtime
 * behavior:
 *
 *   • Input Validation:
 *       - readPositiveInt() ensures that numerical fields (like year or
 *         door count) are positive integers.
 *       - readNonEmpty() ensures mandatory text fields (like make or model)
 *         are not left blank.
 *       - readInt() catches and handles non-numeric input gracefully.
 *
 *   • Exception Management:
 *       - try-catch blocks are strategically placed to prevent crashes.
 *       - Meaningful error messages guide users toward corrective actions.
 *       - Scanner buffer clearing prevents infinite loops on invalid input.
 *
 *   • CLI Stability:
 *       - The system recovers smoothly from input errors and continues
 *         operation without terminating.
 *
 * These measures collectively ensure a robust, user-friendly application
 * that maintains reliability even under incorrect user interaction.
 *
 * ---------------------------------------------------------------
 * 10. DOCUMENTATION AND CODE MAINTENANCE
 * ---------------------------------------------------------------
 * The Vehicle Information System is comprehensively documented to assist
 * both learners and developers in understanding its structure and logic.
 *
 * Documentation focuses on:
 *   • Explaining class responsibilities and relationships.
 *   • Clarifying how interfaces define structure and how classes implement
 *     them concretely.
 *   • Detailing method purposes and data flow within the system.
 *   • Providing a clear overview of system behavior for future maintenance.
 *
 * This thorough documentation ensures that other developers can easily
 * navigate, modify, or extend the program without confusion.
 *
 * ---------------------------------------------------------------
 * 11. LEARNING OUTCOMES AND REFLECTION
 * ---------------------------------------------------------------
 * Through developing and analyzing the Vehicle Information System, the
 * following learning outcomes are achieved:
 *
 *   • Understanding of Interface Design:
 *       The project reinforces the concept of defining abstract contracts
 *       that govern class behavior, promoting consistent structures across
 *       different object types.
 *
 *   • Practical Application of Polymorphism:
 *       A single ArrayList<Vehicle> demonstrates how multiple subclasses
 *       can be managed seamlessly using shared interfaces.
 *
 *   • Enhanced Problem-Solving Skills:
 *       Implementing input validation and error handling builds awareness
 *       of real-world software reliability concerns.
 *
 *   • Code Quality Awareness:
 *       Emphasizing readability and modularity prepares developers for
 *       scalable and maintainable software projects.
 *
 * Reflection:
 *   • This system highlights the importance of clean architecture and
 *     modular thinking in program design.
 *   • It serves as an educational stepping stone toward more complex
 *     applications involving persistence (file or database storage) or
 *     graphical interfaces (GUI/JavaFX).
 *
 * ---------------------------------------------------------------
 * 12. CONCLUSION
 * ---------------------------------------------------------------
 * The Vehicle Information System effectively integrates object-oriented
 * principles, robust validation, and modular design into a cohesive and
 * maintainable application. It demonstrates:
 *
 *   • How interfaces define consistent behavioral contracts.
 *   • How classes implement real-world entities through encapsulation.
 *   • How error handling ensures reliability and smooth user experience.
 *   • How structured documentation improves maintainability.
 *
 * Overall, VIS stands as a comprehensive demonstration of good programming
 * practices in Java—highlighting clarity, flexibility, and reliability as
 * the cornerstones of effective software design.
 *
 * ================================================================
 */

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
