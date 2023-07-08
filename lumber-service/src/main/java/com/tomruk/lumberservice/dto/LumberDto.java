package com.tomruk.lumberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LumberDto {
    private Long id;
    private Integer length;
    private BigDecimal volume;
    private Instant createdTs;
    private Instant updatedTs;
    private Integer diameter;
}
