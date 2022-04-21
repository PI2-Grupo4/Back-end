package com.pi2.backendsolarclean.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PowerRequest {

    private Long id;

    //1 = Ligado, 2 = Limpando, 3 = Desligado
    private Integer status;

}
