package com.patrycjabielan.sdp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class VehiclesApp {
    private final static Logger logger = LoggerFactory.getLogger(VehiclesApp.class);

    private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    private static boolean quit = false;

    private static Vehicle car1 = new Car("BMW", 250);
    private static Vehicle car2 = new Car("Fiat", 150);
    private static Vehicle bicycle1 = new Bicycle("Ecobike", 50);
    private static Vehicle bicycle2 = new Bicycle("Alpina", 70);
    private static Vehicle plane1 = new Plane("Boeing", 1045);
    private static Vehicle plane2 = new Plane("Airbus", 1000);
    private static Vehicle ship1 = new Ship("Norwegian Cruise Line", 40);
    private static Vehicle ship2 = new Ship("Cunard Line", 55);


    public static void main(String[] args) {
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(bicycle1);
        vehicles.add(bicycle2);
        vehicles.add(plane1);
        vehicles.add(plane2);
        vehicles.add(ship1);
        vehicles.add(ship2);

        showVehicles();
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            logger.info("Choose the option: car, bicycle, plane, ship, all or exit");
            String option = scanner.nextLine();
            chooseOption(option.toLowerCase());
        }
    }

    public static void chooseOption(String option) {
        switch (option) {
            case "car":
                compareSpeed(car1, car2);
                break;
            case "bicycle":
                compareSpeed(bicycle1, bicycle2);
                break;
            case "plane":
                compareSpeed(plane1, plane2);
                break;
            case "ship":
                compareSpeed(ship1, ship2);
                break;
            case "all":
                Vehicle theFastestVehicle = Collections.max(vehicles, Comparator.comparing(Vehicle::getMaxSpeed));
                logger.info(theFastestVehicle.getManufacturer() + " is the fastest in the Vehicle class (max speed = " +
                            theFastestVehicle.getMaxSpeed() + "km/h)");
                break;
            case "exit":
                logger.info("Bye!");
                quit = true;
                break;
            default:
                logger.error("Invalid value");
                break;
        }
    }

    public static void compareSpeed(Vehicle vehicle1, Vehicle vehicle2) {

        if (vehicle1.getMaxSpeed() > vehicle2.getMaxSpeed()) {
            logger.info("Vehicle " + vehicle1.getManufacturer() + " (" + vehicle1.getClass().getSimpleName() +
                        " class) is the fastest one in this group (max speed = " + vehicle1.getMaxSpeed() + " km/h)");
        } else {
            logger.info("Vehicle " + vehicle2.getManufacturer() + " (" + vehicle2.getClass().getSimpleName() +
                        " class) is the fastest one in this group (max speed = " + vehicle2.getMaxSpeed() + " km/h)");
        }
    }

    public static void showVehicles() {
        logger.info("The list of your vehicles:");
        for (Vehicle vehicle : vehicles) {
            logger.info(1 + vehicles.indexOf(vehicle) + ". " + vehicle.getManufacturer());
        }
    }
}
