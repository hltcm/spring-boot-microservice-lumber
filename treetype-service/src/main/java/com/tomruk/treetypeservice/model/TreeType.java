package com.tomruk.treetypeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(value = "treetype")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TreeType {
	@Id
	private String id;
	private String name;
	private Instant createdTs;
	private Instant updatedTs;
}
