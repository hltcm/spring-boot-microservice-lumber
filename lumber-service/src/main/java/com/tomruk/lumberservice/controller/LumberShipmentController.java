package com.tomruk.lumberservice.controller;

import com.tomruk.lumberservice.dto.LumberShipmentRequest;
import com.tomruk.lumberservice.service.LumberShipmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lumbershipment")
@RequiredArgsConstructor
public class LumberShipmentController {

    private final LumberShipmentService lumberShipmentService;

    @PostMapping
    @CircuitBreaker(name = "treetype", fallbackMethod = "fallbackMethod")
    public ResponseEntity<String> placeLumberShipment(@RequestBody LumberShipmentRequest lumberShipmentRequest){
        lumberShipmentService.placeLumberShipment(lumberShipmentRequest);
        return new ResponseEntity<>("Lumber Shipment Placed Successfully",HttpStatus.CREATED);
    }

    public ResponseEntity<String> fallbackMethod(LumberShipmentRequest lumberShipmentRequest, RuntimeException runtimeException){
        return new ResponseEntity<>("Oops! Something went wrong, please lumber shipment place after some time!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
