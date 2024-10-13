package CarRentalAgency;

import java.util.Scanner;

public class CarRentalAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vehicle type (car/motorcycle/truck): ");
        String vehicleType = scanner.nextLine().toLowerCase();

        switch (vehicleType) {
            case "car":
                Car car = new Car("Toyota", "Corolla", 2020);
                car.setNumberOfDoors(4);
                car.setFuelType("Petrol");
                displayCarDetails(car);
                break;
            case "motorcycle":
                Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2019);
                motorcycle.setNumberOfWheels(2);
                motorcycle.setMotorcycleType("Cruiser");
                displayMotorcycleDetails(motorcycle);
                break;
            case "truck":
                Truck truck = new Truck("Ford", "F-150", 2018);
                truck.setCargoCapacity(2.5);
                truck.setTransmissionType("Automatic");
                displayTruckDetails(truck);
                break;
            default:
                System.out.println("Invalid vehicle type entered.");
        }
        scanner.close();
    }

    public static void displayCarDetails(Car car) {
        System.out.println("Car Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Number of Doors: " + car.getNumberOfDoors());
        System.out.println("Fuel Type: " + car.getFuelType());
    }

    public static void displayMotorcycleDetails(Motorcycle motorcycle) {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
        System.out.println("Type: " + motorcycle.getMotorcycleType());
    }

    public static void displayTruckDetails(Truck truck) {
        System.out.println("Truck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());
    }
}
