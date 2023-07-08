package com.tomruk.lumberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LumberShipmentRequest {
    private Long id;
    private Long stackNo;
    private Long groupId;
    private Long treeTypeId;
    private Long companyId;
    private Long supplierId;
    private BigDecimal volume;
    private Instant createdTs;
    private Instant updatedTs;
    private String updatedUser;
    private Boolean isCut;
    private String shipmentNo;
    private String warehouse;
    private Instant shipmentDate;
    private String plate;
    private Integer count;
    private List<LumberDto> lumberDtoList;
}
