public class CareProfile {
    Pet pet;
    String feedingInstructions;
    String medicationList;
    String medicationInstructions;

    public CareProfile(Pet pet, String feedingInstructions, String medicationList, String medicationInstructions) {
        this.pet = pet;
        this.feedingInstructions = feedingInstructions;
        this.medicationList = medicationList;
        this.medicationInstructions = medicationInstructions;
    }

    public void printCareInstructions() {
        System.out.println("Care Profile for " + pet.name);
        System.out.println("Feeding Instructions: " + feedingInstructions);
        System.out.println("Medication List: " + medicationList);
        System.out.println("Medication Instructions: " + medicationInstructions);
    }
}

