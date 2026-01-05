package com.pantry.ims.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FOOD")
@Getter
@Setter
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "PRICE")
    private String price;

    @OneToOne
    @JoinColumn(name = "SELLER_ID")
    private SellerEntity sellerEntity;

}
