package com.tomruk.lumberservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name="T_LUMBER_SHIPMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LumberShipment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STACK_NO", nullable = false)
    private Long stackNo;

    @Column(name = "GROUP_ID")
    private Long groupId;

    @Column(name = "TREETYPE_ID")
    private Long treeTypeId;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "VOLUME", scale = 3, precision = 10)
    private BigDecimal volume;

    @Column(name = "CREATED_TS", nullable = false)
    private Instant createdTs;

    @Column(name = "UPDATED_TS")
    private Instant updatedTs;

    @Column(name = "UPDATED_USER")
    private String updatedUser;

    @Column(name = "ISCUT")
    private Boolean isCut;

    @Column(name = "SHIPMENT_NO", unique = true)
    private String shipmentNo;

    @Column(name = "WAREHOUSE")
    private String warehouse;

    @Column(name = "SHIPMENT_DATE")
    private Instant shipmentDate;

    @Column(name = "PLATE")
    private String plate;

    @Column(name = "COUNT")
    private Integer count;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "LUMBER_LIST")
    private List<Lumber> lumberList;
}
