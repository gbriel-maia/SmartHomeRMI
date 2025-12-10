package smarthome;

import org.eclipse.paho.client.mqttv3.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.io.InputStream;
import java.util.Properties;

public class SmartHomeServiceImpl extends UnicastRemoteObject implements SmartHomeService {
    private MqttClient mqttClient;
    private Properties props;
    
    protected SmartHomeServiceImpl() throws RemoteException {
        super();
        loadProperties();
        try {
            mqttClient = new MqttClient(props.getProperty("mqtt.broker"), props.getProperty("mqtt.clientId"));
            mqttClient.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadProperties() {
        props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("mqtt.properties")) {
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void turnLightOn() throws RemoteException {
        publish(props.getProperty("mqtt.topic.light"), "ON");
        subscribe(props.getProperty("mqtt.topic.response"));
    }

    @Override
    public void turnLightOff() throws RemoteException {
        publish(props.getProperty("mqtt.topic.light"), "OFF");
        subscribe(props.getProperty("mqtt.topic.response"));
    }

    @Override
    public void lockDoor() throws RemoteException {
        publish(props.getProperty("mqtt.topic.door"), "LOCK");
        subscribe(props.getProperty("mqtt.topic.response"));
    }

    @Override
    public void unlockDoor() throws RemoteException {
        publish(props.getProperty("mqtt.topic.door"), "UNLOCK");
        subscribe(props.getProperty("mqtt.topic.response"));
    }
    
    @Override
    public void TempRead() throws RemoteException {
        publish(props.getProperty("mqtt.topic.temp"), "READ");
        subscribe(props.getProperty("mqtt.topic.response"));
    }

    private void publish(String topic, String message) {
        try {
            mqttClient.publish(topic, new MqttMessage(message.getBytes()));
            System.out.println("Publicado via MQTT: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void subscribe(String topic) {
        try {
            mqttClient.subscribe(topic, (t, m) -> {
                System.out.println("Mensagem recebida no tópico " + t + ": " + new String(m.getPayload()));
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
