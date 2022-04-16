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

}
