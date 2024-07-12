public class Billing {
    Booking booking;
    boolean isPaid;

    public Billing(Booking booking) {
        this.booking = booking;
        this.isPaid = false;
    }

    public void processPayment() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("Payment processed for booking of " + booking.pet.name);
        } else {
            System.out.println("Payment already made for booking of " + booking.pet.name);
        }
    }
}

