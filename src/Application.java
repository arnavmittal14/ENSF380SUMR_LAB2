import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static ManageClientInformation clientManager = new ManageClientInformation();
    private static ManagePetInformation petManager = new ManagePetInformation();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nYYC Pet Resort Management System");
            System.out.println("1. Add Client");
            System.out.println("2. Search Client");
            System.out.println("3. Add Pet");
            System.out.println("4. Search Pet");
            System.out.println("5. Create Care Profile");
            System.out.println("6. Print Care Profile");
            System.out.println("7. Add Booking");
            System.out.println("8. Cancel Booking");
            System.out.println("9. Process Payment");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addClient(scanner);
                    break;
                case 2:
                    searchClient(scanner);
                    break;
                case 3:
                    addPet(scanner);
                    break;
                case 4:
                    searchPet(scanner);
                    break;
                case 5:
                    createCareProfile(scanner);
                    break;
                case 6:
                    printCareProfile(scanner);
                    break;
                case 7:
                    addBooking(scanner);
                    break;
                case 8:
                    cancelBooking(scanner);
                    break;
                case 9:
                    processPayment(scanner);
                    break;
                case 10:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addClient(Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        Client client = new Client(name, phoneNumber, address);
        clientManager.addClient(client);
    }

    private static void searchClient(Scanner scanner) {
        System.out.print("Enter client name to search: ");
        String name = scanner.nextLine();
        clientManager.searchClient(name);
    }

    private static void addPet(Scanner scanner) {
        System.out.print("Enter pet name: ");
        String petName = scanner.nextLine();
        System.out.print("Enter breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        Client owner = clientManager.searchClient(ownerName);
        if (owner != null) {
            Pet pet = new Pet(petName, breed, age, owner);
            petManager.addPet(pet);
        } else {
            System.out.println("Owner not found. Please add the client first.");
        }
    }

    private static void searchPet(Scanner scanner) {
        System.out.print("Enter pet name to search: ");
        String petName = scanner.nextLine();
        petManager.searchPet(petName);
    }

    private static void createCareProfile(Scanner scanner) {
        System.out.print("Enter pet name for care profile: ");
        String petName = scanner.nextLine();
        Pet pet = petManager.searchPet(petName);
        if (pet != null) {
            System.out.print("Enter feeding instructions: ");
            String feedingInstructions = scanner.nextLine();
            System.out.print("Enter medication list: ");
            String medicationList = scanner.nextLine();
            System.out.print("Enter medication instructions: ");
            String medicationInstructions = scanner.nextLine();
            CareProfile careProfile = new CareProfile(pet, feedingInstructions, medicationList, medicationInstructions);
            System.out.println("Care profile created for " + petName);
        } else {
            System.out.println("Pet not found.");
        }
    }

    private static void printCareProfile(Scanner scanner) {
        System.out.print("Enter pet name to print care profile: ");
        String petName = scanner.nextLine();
        Pet pet = petManager.searchPet(petName);
        if (pet != null) {
            CareProfile careProfile = new CareProfile(pet, "Example Feeding Instructions", "Example Medication List", "Example Medication Instructions");
            careProfile.printCareInstructions();
        } else {
            System.out.println("Pet not found.");
        }
    }

    private static void addBooking(Scanner scanner) {
        System.out.print("Enter pet name for booking: ");
        String petName = scanner.nextLine();
        Pet pet = petManager.searchPet(petName);
        if (pet != null) {
            System.out.print("Enter start date (YYYY-MM-DD): ");
            String startDate = scanner.nextLine();
            System.out.print("Enter end date (YYYY-MM-DD): ");
            String endDate = scanner.nextLine();
            System.out.print("Enter total cost: ");
            double totalCost = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            Booking booking = new Booking(pet, startDate, endDate, totalCost);
            bookings.add(booking);
            System.out.println("Booking added for " + petName);
        } else {
            System.out.println("Pet not found.");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter pet name to cancel booking: ");
        String petName = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.pet.name.equals(petName) && booking.isActive) {
                booking.cancelBooking();
                return;
            }
        }
        System.out.println("Active booking not found for " + petName);
    }

    private static void processPayment(Scanner scanner) {
        System.out.print("Enter pet name to process payment: ");
        String petName = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.pet.name.equals(petName) && booking.isActive) {
                Billing billing = new Billing(booking);
                billing.processPayment();
                return;
            }
        }
        System.out.println("Active booking not found for " + petName);
    }
}
