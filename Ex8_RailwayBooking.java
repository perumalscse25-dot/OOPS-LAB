class Railway {
    int seats = 2;

    synchronized void bookTicket() {
        while (seats == 0) {
            try {
                System.out.println("No seats available. Booking thread is waiting...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        seats--;
        System.out.println("Ticket Booked Successfully.");
        System.out.println("Available Seats: " + seats);
    }

    synchronized void cancelTicket() {
        seats++;
        System.out.println("Ticket Cancelled Successfully.");
        System.out.println("Available Seats: " + seats);
        notify();
    }
}

class Booking extends Thread {
    Railway r;

    Booking(Railway r) {
        this.r = r;
    }

    public void run() {
        r.bookTicket();
        r.bookTicket();
        r.bookTicket();
    }
}

class Cancellation extends Thread {
    Railway r;

    Cancellation(Railway r) {
        this.r = r;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        r.cancelTicket();
    }
}

public class Ex8_RailwayBooking {
    public static void main(String[] args) {
        Railway r = new Railway();
        Booking b = new Booking(r);
        Cancellation c = new Cancellation(r);

        b.start();
        c.start();
    }
}
