import java.util.ArrayList;
import java.util.List;

public class ManagePetInformation {
    List<Pet> pets = new ArrayList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
        System.out.println("Pet added: " + pet.name);
    }

    public Pet searchPet(String name) {
        for (Pet pet : pets) {
            if (pet.name.equals(name)) {
                System.out.println("Pet found: " + pet.name);
                return pet;
            }
        }
        System.out.println("Pet not found: " + name);
        return null;
    }

    
}
