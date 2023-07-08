package com.tomruk.lumberservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "T_LUMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lumber {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LENGTH")
    private Integer length;

    @Column(name = "VOLUME", scale = 3, precision = 10)
    private BigDecimal volume;

    @Column(name = "CREATED_TS", nullable = false)
    private Instant createdTs;

    @Column(name = "UPDATED_TS")
    private Instant updatedTs;

    @Column(name = "DIAMETER")
    private Integer diameter;
}
