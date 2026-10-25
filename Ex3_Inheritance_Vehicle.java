import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String model;
    String manufacturer;
    double price;

    Vehicle(String vehicleNumber, String model, String manufacturer, double price) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    void display() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Model          : " + model);
        System.out.println("Manufacturer   : " + manufacturer);
        System.out.println("Price          : " + price);
    }
}

class Car extends Vehicle {
    Car(String v, String m, String man, double p) {
        super(v, m, man, p);
    }

    void bill() {
        double tax = price * 0.05;
        double insurance = 10000;
        double total = price + tax + insurance;
        System.out.println("\n***** CAR BILL *****");
        display();
        System.out.println("Road Tax   : " + tax);
        System.out.println("Insurance  : " + insurance);
        System.out.println("Total Cost : " + total);
    }
}

class Bike extends Vehicle {
    Bike(String v, String m, String man, double p) {
        super(v, m, man, p);
    }

    void bill() {
        double tax = price * 0.03;
        double insurance = 3000;
        double total = price + tax + insurance;
        System.out.println("\n***** BIKE BILL *****");
        display();
        System.out.println("Road Tax   : " + tax);
        System.out.println("Insurance  : " + insurance);
        System.out.println("Total Cost : " + total);
    }
}

class Truck extends Vehicle {
    Truck(String v, String m, String man, double p) {
        super(v, m, man, p);
    }

    void bill() {
        double tax = price * 0.10;
        double insurance = 15000;
        double total = price + tax + insurance;
        System.out.println("\n***** TRUCK BILL *****");
        display();
        System.out.println("Road Tax   : " + tax);
        System.out.println("Insurance  : " + insurance);
        System.out.println("Total Cost : " + total);
    }
}

public class Ex3_Inheritance_Vehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Manufacturer: ");
        String manufacturer = sc.nextLine();

        System.out.print("Enter Vehicle Price: ");
        double price = sc.nextDouble();

        System.out.println("\n1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Car c = new Car(number, model, manufacturer, price);
                c.bill();
                break;
            case 2:
                Bike b = new Bike(number, model, manufacturer, price);
                b.bill();
                break;
            case 3:
                Truck t = new Truck(number, model, manufacturer, price);
                t.bill();
                break;
            default:
                System.out.println("Invalid Choice");
        }
        sc.close();
    }
}
