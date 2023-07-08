package com.tomruk.notificationservice.listener;

import com.tomruk.notificationservice.event.LumberShipmentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableKafka
@Component
public class NotificationListener {

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(LumberShipmentEvent lumberShipmentEvent){
        //TODO: Send an email
        log.info("Received Notification from lumber-service. Shipment No - {}", lumberShipmentEvent.getShipmentNo());
    }
}
