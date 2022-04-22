package com.pi2.backendsolarclean;

import com.pi2.backendsolarclean.mqtt.MqttSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndSolarCleanApplication {

	private static final String topic = "equipment157";

	public static void main(String[] args) {
		SpringApplication.run(BackEndSolarCleanApplication.class, args);
		new MqttSubscriber().subscribe(topic);

	}

}
