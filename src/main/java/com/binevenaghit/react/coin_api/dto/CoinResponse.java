package com.binevenaghit.react.coin_api.dto;

/**
 * @author danieldevlin
 * @date 26/04/2025
 * @project React-SpringBoot-Coin-App
 */

import lombok.*;

/**
 * DTO for sending Coin data with mint ID
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CoinResponse {

    private Long coinId;
    private String coinDescription;
    private double coinWeight;
    private double coinPrice;
    private String coinName;
    private double coinFineness;
    private String coinMetal;
    private Long mintId; // <--- Only the ID of the Mint
}
