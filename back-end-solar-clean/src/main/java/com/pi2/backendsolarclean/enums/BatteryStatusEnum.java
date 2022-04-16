package com.pi2.backendsolarclean.enums;

public enum BatteryStatusEnum {

    CHARGING(0),
    DISCHARGING(1),
    FULL(2);

    private final Integer status;

    BatteryStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
