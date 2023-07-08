package com.tomruk.lumberservice.service;

import com.tomruk.lumberservice.dto.LumberDto;
import com.tomruk.lumberservice.dto.LumberShipmentRequest;
import com.tomruk.lumberservice.dto.TreeTypeResponse;
import com.tomruk.lumberservice.event.LumberShipmentEvent;
import com.tomruk.lumberservice.model.Lumber;
import com.tomruk.lumberservice.model.LumberShipment;
import com.tomruk.lumberservice.repository.LumberShipmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LumberShipmentService {

    private final LumberShipmentRepository lumberShipmentRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String, LumberShipmentEvent> kafkaTemplate;

    public void placeLumberShipment(LumberShipmentRequest lumberShipmentRequest) {
        LumberShipment lumberShipment = new LumberShipment();

        List<Lumber> lumberList = lumberShipmentRequest.getLumberDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();


        lumberShipment.setLumberList(lumberList);
        lumberShipment.setCreatedTs(Instant.now());
        lumberShipment.setStackNo(1L);

        //Call TreeType Service and place LumberShipment if request is success
        TreeTypeResponse[] treeTypeResponse = webClientBuilder.build().get()
                .uri("http://treetype-service/api/treetype")
                .retrieve()
                .bodyToMono(TreeTypeResponse[].class)
                .block();

        lumberShipment.setShipmentNo("kafka-test"+ UUID.randomUUID());

        lumberShipmentRepository.save(lumberShipment);
        kafkaTemplate.send("notificationTopic", new LumberShipmentEvent(lumberShipment.getShipmentNo()));
        log.info("Lumber Shipment Placed Successfully");
    }

    private Lumber mapToDto(LumberDto lumberDto) {
        Lumber lumber = new Lumber();
        lumber.setLength(lumberDto.getLength());
        lumber.setDiameter(lumberDto.getDiameter());
        lumber.setCreatedTs(Instant.now());
        lumber.setVolume(lumberDto.getVolume());
        return lumber;

    }
}
