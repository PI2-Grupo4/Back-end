package com.pi2.backendsolarclean.service;

import com.pi2.backendsolarclean.dao.EquipmentRepository;
import com.pi2.backendsolarclean.entity.Equipment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class EquipmentService {

    @Resource
    private EquipmentRepository repository;

    public Optional<Equipment> findById(Long id) {
        return repository.findById(id);
    }

    public void changeDirection(Long id, boolean direction) {

    }

    public void changeSpeed(Long id, Integer speed) {

    }

    public void power(Long id, boolean isOn) {

    }

}
