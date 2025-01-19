package org.dev.posapi.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sale_item")
public class SaleItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sale", nullable = false)
    private SaleEntity sale;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private ProductEntity product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(nullable = false)
    private Double subtotal;
}
