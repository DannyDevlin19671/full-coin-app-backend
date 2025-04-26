package com.binevenaghit.react.coin_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

/**
 * @author danieldevlin
 * @date 24/04/2025
 * @project React-SpringBoot-Coin-App
 */

@Entity
@Getter
@Setter
@ToString
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coin_id") // keeps DB column snake_case
    private Long coinId;

    @NotBlank(message = "Description is required")
    @Column(name = "coin_description", unique = true)
    private String coinDescription;

    @Positive(message = "Weight must be greater than 0")
    @Column(name = "coin_weight")
    private double coinWeight;

    @Positive(message = "Price must be greater than 0")
    @Column(name = "coin_price")
    private double coinPrice;

    @NotBlank(message = "Name is required")
    @Column(name = "coin_name")
    private String coinName;

    @Positive(message = "Fineness must be greater than 0")
    @Column(name = "coin_fineness")
    private double coinFineness;

    @NotBlank(message = "Metal type is required")
    @Column(name = "coin_metal")
    private String coinMetal;

    @ManyToOne
    @JoinColumn(name = "mint_id")
    @JsonBackReference
    private Mint mint;

    // ✅ Custom constructor that excludes ID
    public Coin(String coinDescription, double coinWeight, double coinPrice,
                String coinName, double coinFineness, String coinMetal, Mint mint) {
        this.coinDescription = coinDescription;
        this.coinWeight = coinWeight;
        this.coinPrice = coinPrice;
        this.coinName = coinName;
        this.coinFineness = coinFineness;
        this.coinMetal = coinMetal;
        this.mint = mint;
    }

    // ✅ Default constructor
    public Coin() {
    }
}
