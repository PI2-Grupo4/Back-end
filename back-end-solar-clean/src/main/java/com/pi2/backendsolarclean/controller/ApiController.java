package com.pi2.backendsolarclean.controller;

import com.pi2.backendsolarclean.service.EquipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-controller")
public class ApiController {


    private EquipmentService service;

    @GetMapping("/equipmentInfo")
    public ResponseEntity<?> equipmentInfo(@RequestParam Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

}


