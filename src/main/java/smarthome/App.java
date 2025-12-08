package smarthome;

public class App {
	public static void main(String[] args) {
		System.out.println("Smart Home RMI Application");
		RMIServer.run();
		RMIClient.run();
	}
}
