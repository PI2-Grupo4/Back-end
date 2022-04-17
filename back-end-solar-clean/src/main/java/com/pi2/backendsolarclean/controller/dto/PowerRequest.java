package com.pi2.backendsolarclean.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PowerRequest {

    private Long id;

    private boolean isOn;

}
