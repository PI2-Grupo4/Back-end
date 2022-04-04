package com.pi2.backendsolarclean.dao;

import com.pi2.backendsolarclean.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
