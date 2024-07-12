public class Booking {
    Pet pet;
    String startDate;
    String endDate;
    boolean isActive;
    double totalCost;

    public Booking(Pet pet, String startDate, String endDate, double totalCost) {
        this.pet = pet;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.isActive = true;
    }

    public void cancelBooking() {
        this.isActive = false;
        System.out.println("Booking cancelled for " + pet.name);
    }

    
}
