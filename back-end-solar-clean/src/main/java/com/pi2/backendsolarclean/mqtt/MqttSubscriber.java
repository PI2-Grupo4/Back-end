package com.pi2.backendsolarclean.mqtt;

import com.pi2.backendsolarclean.configuration.SpringContext;
import com.pi2.backendsolarclean.service.EquipmentService;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttSubscriber implements MqttCallback {

    private static final String brokerUrl ="tcp://localhost:1883";
    private static final String clientId = "javasub";


    public void subscribe(String topic) {
        MemoryPersistence persistence = new MemoryPersistence();

        try
        {

            MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            System.out.println("Mqtt Connecting to broker: " + brokerUrl);

            sampleClient.connect(connOpts);
            System.out.println("Mqtt Connected");

            sampleClient.setCallback(this);
            sampleClient.subscribe(topic);


        } catch (MqttException me) {
            System.out.println("exception occured");
            System.out.println(me);
        }
    }
    public void connectionLost(Throwable arg0) {

    }

    public void deliveryComplete(IMqttDeliveryToken arg0) {

    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {

        EquipmentService service = SpringContext.getBean(EquipmentService.class);

        String[] payload = message.toString().split(" ");

        System.out.println("| Topic:" + topic);
        System.out.println("| Id: " +payload[0]);
        System.out.println("| Status: " +payload[1]);
        System.out.println("| Speed: " +payload[2]);
        System.out.println("| Direction: " +payload[3]);
        System.out.println("| Battery Status: " +payload[4]);
        System.out.println("| Battery Level: " +payload[5]);
        System.out.println("| Water Consumption: " +payload[6]);
        System.out.println("| Water Level: " +payload[7]);
        System.out.println("-------------------------------------------------");

        service.equipmentInfo(message.toString());

    }
}
