package com.binevenaghit.react.coin_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for incoming Coin data (creating or updating a Coin)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinRequest {

    @NotBlank(message = "Description is required")
    private String coinDescription;

    @Positive(message = "Weight must be greater than 0")
    private double coinWeight;

    @Positive(message = "Price must be greater than 0")
    private double coinPrice;

    @NotBlank(message = "Name is required")
    private String coinName;

    @Positive(message = "Fineness must be greater than 0")
    private double coinFineness;

    @NotBlank(message = "Metal type is required")
    private String coinMetal;

    @Positive(message = "Mint ID must be greater than 0")
    private Long mintId;
}
