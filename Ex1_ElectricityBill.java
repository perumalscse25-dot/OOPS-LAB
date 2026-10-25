import java.util.Scanner;

class ElectricityBill {
    int consumerNo;
    String consumerName;
    int previousReading, currentReading;
    char type;
    double bill;

    void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        consumerNo = sc.nextInt();

        System.out.print("Enter Consumer Name: ");
        consumerName = sc.next();

        System.out.print("Enter Previous Month Reading: ");
        previousReading = sc.nextInt();

        System.out.print("Enter Current Month Reading: ");
        currentReading = sc.nextInt();

        System.out.print("Enter Type of Connection (D/C): ");
        type = sc.next().charAt(0);
    }

    void calculate() {
        int units = currentReading - previousReading;

        if (type == 'D' || type == 'd') {
            if (units <= 100)
                bill = units * 1.50;
            else if (units <= 200)
                bill = 100 * 1.50 + (units - 100) * 3;
            else if (units <= 500)
                bill = 100 * 1.50 + 100 * 3 + (units - 200) * 4.50;
            else
                bill = 100 * 1.50 + 100 * 3 + 300 * 4.50 + (units - 500) * 7;
        } else {
            if (units <= 100)
                bill = units * 2.50;
            else if (units <= 200)
                bill = 100 * 2.50 + (units - 100) * 5;
            else if (units <= 500)
                bill = 100 * 2.50 + 100 * 5 + (units - 200) * 6.50;
            else
                bill = 100 * 2.50 + 100 * 5 + 300 * 6.50 + (units - 500) * 9;
        }
    }

    void display() {
        System.out.println("\n--- ELECTRICITY BILL ---");
        System.out.println("Consumer Number : " + consumerNo);
        System.out.println("Consumer Name   : " + consumerName);
        System.out.println("Units Consumed  : " + (currentReading - previousReading));
        System.out.println("Connection Type : " + ((type == 'D' || type == 'd') ? "Domestic" : "Commercial"));
        System.out.println("Total Bill      : Rs." + bill);
    }
}

public class Ex1_ElectricityBill {
    public static void main(String[] args) {
        ElectricityBill obj = new ElectricityBill();
        obj.getData();
        obj.calculate();
        obj.display();
    }
}
