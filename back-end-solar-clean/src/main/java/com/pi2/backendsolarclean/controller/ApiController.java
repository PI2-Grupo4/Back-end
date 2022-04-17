package com.pi2.backendsolarclean.controller;

import com.pi2.backendsolarclean.controller.dto.ChangeDirectionRequest;
import com.pi2.backendsolarclean.controller.dto.ChangeSpeedRequest;
import com.pi2.backendsolarclean.controller.dto.PowerRequest;
import com.pi2.backendsolarclean.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EquipmentService service;

    @GetMapping("/equipmentInfo")
    public ResponseEntity<?> equipmentInfo(@RequestParam(value = "id") int id) {
        return ResponseEntity.ok(service.findById((long) id));
    }

    @PutMapping("/changeDirection")
    public ResponseEntity<?> changeDirection(@RequestBody ChangeDirectionRequest request) {
        service.changeDirection(request.getId(), request.isDirection());
        return ResponseEntity.ok(new Response("Changed Direction"));
    }

    @PutMapping("/changeSpeed")
    public ResponseEntity<?> changeSpeed(@RequestBody ChangeSpeedRequest request) {
        service.changeSpeed(request.getId(), request.getSpeed());
        return ResponseEntity.ok(new Response("Changed Speed"));
    }

    @PutMapping("/power")
    public ResponseEntity<?> power(@RequestBody PowerRequest request) {
        service.power(request.getId(), request.isItOn());
        return ResponseEntity.ok(request.isItOn() ?
                new Response("The equipment is turned on") : new Response("The equipment is turned off"));
    }



}


