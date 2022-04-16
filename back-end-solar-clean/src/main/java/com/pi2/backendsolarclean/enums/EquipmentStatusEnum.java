package com.pi2.backendsolarclean.enums;

public enum EquipmentStatusEnum {

    STANDBY(0),
    WORKING(1),
    DONE(2),
    ERROR(3);

    private final Integer status;

    EquipmentStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
