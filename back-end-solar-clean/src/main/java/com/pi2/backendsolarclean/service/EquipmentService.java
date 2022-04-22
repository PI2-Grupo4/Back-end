package com.pi2.backendsolarclean.service;

import com.pi2.backendsolarclean.dao.EquipmentRepository;
import com.pi2.backendsolarclean.entity.Equipment;
import com.pi2.backendsolarclean.mqtt.MqttPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    MqttPublisher publisher = new MqttPublisher();
    @Resource
    private EquipmentRepository repository;

    public Optional<Equipment> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<List<Equipment>> findAllByUserId(Integer id){
        return repository.findAllByUserId(id);
    }

    public void changeDirection(Long id, boolean direction) {
        Equipment equipment = repository.findById(id).get();
        Integer msg = direction ? 1 : 0;

        equipment.setDirection(direction);
        publisher.publish("changeDirection " + id + " " + msg, id);
        repository.save(equipment);
    }

    public void changeSpeed(Long id, Integer speed) {
        Equipment equipment = repository.findById(id).get();

        equipment.setSpeed(speed);
        publisher.publish("changeSpeed " + id + " " + speed, id);
        repository.save(equipment);
    }

    public void power(Long id, Integer status) {
        Equipment equipment = repository.findById(id).get();

        equipment.setStatus(status);
        publisher.publish("changeStatus " + id + " " + status, id);
        repository.save(equipment);
    }

    public void equipmentInfo(String message) {
        String[] payload = message.toString().split(" ");
        Equipment equipment = repository.findById(Long.valueOf(payload[0])).get();

        equipment.setStatus(Integer.valueOf(payload[1]));
        equipment.setSpeed(Integer.valueOf(payload[2]));
        equipment.setDirection(payload[3].contains("1"));
        equipment.setBatteryStatus(Integer.valueOf(payload[4]));
        equipment.setBatteryLevel(Integer.valueOf(payload[5]));
        equipment.setWaterConsumption(new BigDecimal(payload[6]));
        equipment.setWaterLevel(Integer.valueOf(payload[7]));

        repository.save(equipment);
    }

}
