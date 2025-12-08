
package smarthome;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void run() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            SmartHomeService service = (SmartHomeService) registry.lookup("SmartHomeService");

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\n=== Menu Smart Home ===");
                System.out.println("1 - Ligar luz");
                System.out.println("2 - Desligar luz");
                System.out.println("3 - Trancar porta");
                System.out.println("4 - Destrancar porta");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        service.turnLightOn();
                        break;
                    case 2:
                        service.turnLightOff();
                        break;
                    case 3:
                        service.lockDoor();
                        break;
                    case 4:
                        service.unlockDoor();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);

            scanner.close();

        } catch (Exception e) {
            System.out.println("Erro no cliente RMI!");
            e.printStackTrace();
        }
    }
}
