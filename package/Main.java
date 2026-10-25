import converter.DataConverter;
import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        System.out.print("From (bytes/kb/mb/gb/tb): ");
        String from = sc.next();

        System.out.print("To (bytes/kb/mb/gb/tb): ");
        String to = sc.next();

        double result = DataConverter.convert(value, from, to);

        System.out.println("Result = " + result + " " + to);
    }
}