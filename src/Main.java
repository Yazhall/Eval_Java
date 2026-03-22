import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.Neo_Yaz_Bank.model.Client;
import com.Neo_Yaz_Bank.service.BankAccountService;
import com.Neo_Yaz_Bank.service.ClientService;
import com.Neo_Yaz_Bank.service.GestionMenuService;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();
        ClientService clientService = new ClientService(scanner, clients);
        BankAccountService bankAccountService = new BankAccountService(scanner, clients, clientService);
        GestionMenuService menu = new GestionMenuService(scanner,clientService, bankAccountService);
        menu.StartMenu();

    }

}