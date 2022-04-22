package com.pi2.backendsolarclean.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublisher {

    public void publish(String content) {
        String topic        = "equipment157";
        //Id;Status;Speed;Direction;Battery Status;Battery Level; Water Consumption; Water Level
        int qos             = 0;
        String broker       = "tcp://localhost:1883";
        String clientId     = "User";

        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            sampleClient.connect(connOpts);
            System.out.println("Connected to broker");
            System.out.println("Publishing message:"+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            sampleClient.close();
        } catch(MqttException me) {

            me.printStackTrace();
        }
    }

}
