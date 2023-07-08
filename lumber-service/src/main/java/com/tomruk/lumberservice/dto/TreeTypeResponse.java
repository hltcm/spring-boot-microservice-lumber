package com.tomruk.lumberservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeTypeResponse {
    private String id;
    private String name;
    private Instant createdTs;
    private Instant updatedTs;
}
