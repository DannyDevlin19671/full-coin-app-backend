package com.binevenaghit.react.coin_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for incoming Mint data (creating or updating a Mint) with validation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MintRequest {

    @NotBlank(message = "Mint name must not be blank")
    private String mintName;

    @NotBlank(message = "Mint location must not be blank")
    private String mintLocation;

    @Positive(message = "Year established must be a positive number")
    private int mintYearEstablished;
}