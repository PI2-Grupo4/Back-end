package com.pi2.backendsolarclean.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="equipment")
@Data
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "speed")
    private String speed;

    @Column(name = "direction")
    private boolean direction;

    @Column(name = "water_consumption")
    private BigDecimal waterConsumption;

    @Column(name = "battery_consumption")
    private int batteryConsumption;

    @Column(name = "battery_level")
    private String batteryLevel;

    @Column(name = "battery_status")
    private String batteryStatus;

}
