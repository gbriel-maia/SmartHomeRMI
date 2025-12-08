package smarthome;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SmartHomeService extends Remote {
    void turnLightOn() throws RemoteException;
    void turnLightOff() throws RemoteException;
    void lockDoor() throws RemoteException;
    void unlockDoor() throws RemoteException;
}
