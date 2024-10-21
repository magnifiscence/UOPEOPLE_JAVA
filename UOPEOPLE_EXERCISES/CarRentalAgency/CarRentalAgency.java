package CarRentalAgency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List to store available vehicles
        List<Vehicle> vehicleInventory = new ArrayList<>();

        while (true) { // Infinite loop to keep the program running
            System.out.println(
                    "Are you a client, a renter, or do you want to exit? (Enter 'client', 'renter', or 'exit'): ");
            String userType = scanner.nextLine().toLowerCase();

            if (userType.equals("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break; // Exit the loop and program
            }

            switch (userType) {
                case "client":
                    handleClient(scanner, vehicleInventory);
                    break;
                case "renter":
                    handleRenter(scanner, vehicleInventory);
                    break;
                default:
                    System.out.println("Invalid user type entered.");
            }
        }

        scanner.close();
    }

    // Method to handle client interactions
    private static void handleClient(Scanner scanner, List<Vehicle> vehicleInventory) {
        if (vehicleInventory.isEmpty()) {
            System.out.println("No vehicles available for rent.");
            return;
        }

        System.out.println("Enter vehicle type to rent (car/motorcycle/truck): ");
        String vehicleType = scanner.nextLine().toLowerCase();

        for (Vehicle vehicle : vehicleInventory) {
            if ((vehicleType.equals("car") && vehicle instanceof Car) ||
                    (vehicleType.equals("motorcycle") && vehicle instanceof Motorcycle) ||
                    (vehicleType.equals("truck") && vehicle instanceof Truck)) {

                displayVehicleDetails(vehicle);
                return;
            }
        }

        System.out.println("No vehicles of type " + vehicleType + " available for rent.");
    }

    // Method to handle renter interactions
    private static void handleRenter(Scanner scanner, List<Vehicle> vehicleInventory) {
        try {
            System.out.println("Enter vehicle type to add (car/motorcycle/truck): ");
            String vehicleType = scanner.nextLine().toLowerCase();

            System.out.println("Enter make: ");
            String make = scanner.nextLine();

            System.out.println("Enter model: ");
            String model = scanner.nextLine();

            System.out.println("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            switch (vehicleType) {
                case "car":
                    Car car = new Car(make, model, year);
                    System.out.println("Enter number of doors: ");
                    car.setNumberOfDoors(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Enter fuel type (petrol/diesel/electric): ");
                    car.setFuelType(scanner.nextLine());
                    vehicleInventory.add(car);
                    break;
                case "motorcycle":
                    Motorcycle motorcycle = new Motorcycle(make, model, year);
                    System.out.println("Enter number of wheels: ");
                    motorcycle.setNumberOfWheels(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Enter type (sport/cruiser/off-road): ");
                    motorcycle.setMotorcycleType(scanner.nextLine());
                    vehicleInventory.add(motorcycle);
                    break;
                case "truck":
                    Truck truck = new Truck(make, model, year);
                    System.out.println("Enter cargo capacity (in tons): ");
                    truck.setCargoCapacity(Double.parseDouble(scanner.nextLine()));
                    System.out.println("Enter transmission type (manual/automatic): ");
                    truck.setTransmissionType(scanner.nextLine());
                    vehicleInventory.add(truck);
                    break;
                default:
                    System.out.println("Invalid vehicle type entered.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    // Method to display details of a vehicle
    private static void displayVehicleDetails(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            displayCarDetails((Car) vehicle);
        } else if (vehicle instanceof Motorcycle) {
            displayMotorcycleDetails((Motorcycle) vehicle);
        } else if (vehicle instanceof Truck) {
            displayTruckDetails((Truck) vehicle);
        }
    }

    // Method to display car details
    public static void displayCarDetails(Car car) {
        System.out.println("Car Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
        System.out.println("Fuel Type: " + car.getFuelType());
    }

    // Method to display motorcycle details
    public static void displayMotorcycleDetails(Motorcycle motorcycle) {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
        System.out.println("Type: " + motorcycle.getMotorcycleType());
    }

    // Method to display truck details
    public static void displayTruckDetails(Truck truck) {
        System.out.println("Truck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());
    }
}
