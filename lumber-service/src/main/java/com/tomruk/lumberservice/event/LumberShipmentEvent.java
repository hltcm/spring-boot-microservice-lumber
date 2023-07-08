package com.tomruk.lumberservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LumberShipmentEvent {
    private String shipmentNo;
}
