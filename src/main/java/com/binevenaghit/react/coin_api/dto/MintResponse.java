package com.binevenaghit.react.coin_api.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO for sending Mint data along with its Coins
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MintResponse {
    private Long mintId;
    private String mintName;
    private String mintLocation;
    private int mintYearEstablished;
}
