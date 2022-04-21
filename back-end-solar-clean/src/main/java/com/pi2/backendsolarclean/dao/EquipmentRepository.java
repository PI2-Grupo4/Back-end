package com.pi2.backendsolarclean.dao;

import com.pi2.backendsolarclean.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories(basePackages = "com.pi2.backendsolarclean.dao.EquipmentRepository")
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findById(Long id);

    Optional<List<Equipment>> findAllByUserId(Integer id);

}
