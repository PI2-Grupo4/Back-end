package com.pi2.backendsolarclean.enums;

public enum EquipmentSpeedEnum {

    STOPPED(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final Integer speed;

    EquipmentSpeedEnum(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }
}
