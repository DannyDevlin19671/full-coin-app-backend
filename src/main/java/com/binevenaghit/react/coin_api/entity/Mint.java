package com.binevenaghit.react.coin_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

/**
 * @author danieldevlin
 * @date 24/04/2025
 * @project React-SpringBoot-Coin-App
 */

@Entity
@Setter
@Getter
@ToString
public class Mint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mint_id")
    private Long mintId;

    @OneToMany(mappedBy = "mint")
    @JsonIgnore
    private List<Coin> coins;

    @NotBlank(message = "Mint name must not be blank")
    @Column(name = "mint_name", unique = true)
    private String mintName;

    @NotBlank(message = "Mint location must not be blank")
    @Column(name = "mint_location")
    private String mintLocation;

    @Positive(message = "Year established must be a positive number")
    @Column(name = "mint_year_established")
    private int mintYearEstablished;

    public Mint(String mintName, String mintLocation, int mintYearEstablished) {
        this.mintName = mintName;
        this.mintLocation = mintLocation;
        this.mintYearEstablished = mintYearEstablished;
    }

    public Mint() {
    }
}