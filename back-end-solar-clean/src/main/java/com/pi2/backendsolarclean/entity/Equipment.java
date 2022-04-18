package com.pi2.backendsolarclean.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="equipment")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "direction")
    private boolean direction;

    @Column(name = "water_consumption")
    private BigDecimal waterConsumption;

    @Column(name = "water_level")
    private Integer waterLevel;

    @Column(name = "battery_level")
    private Integer batteryLevel;

    @Column(name = "battery_status")
    private Integer batteryStatus;

    @Column(name = "user_id")
    private Integer user_id;

}