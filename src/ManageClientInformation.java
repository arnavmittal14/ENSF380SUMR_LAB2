import java.util.ArrayList;
import java.util.List;

public class ManageClientInformation {
    List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
        System.out.println("Client added: " + client.name);
    }

    public Client searchClient(String name) {
        for (Client client : clients) {
            if (client.name.equals(name)) {
                System.out.println("Client found: " + client.name + "\nAddress: " +client.address + "\nPhone number: " + client.phoneNumber);
                return client;
            }
        }
        System.out.println("Client not found: " + name);
        return null;
    }

    
}
