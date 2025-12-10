package smarthome;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
	public static void main(String[] args) {
        try {
            SmartHomeService service = new SmartHomeServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SmartHomeService", service);
            System.out.println("Servidor RMI pronto!");
            RMIClient.run();
        } catch (Exception e) {
            System.out.println("Erro no servidor RMI!");
            e.printStackTrace();
        }
    }
}
