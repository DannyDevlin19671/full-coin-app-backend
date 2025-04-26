package com.binevenaghit.react.coin_api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author danieldevlin
 * @date 26/04/2025
 * @project React-SpringBoot-Coin-App
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MintWithCoinsResponse extends MintResponse {

    private List<CoinResponse> coins;

    public MintWithCoinsResponse(Long mintId, String mintName, String mintLocation, int mintYearEstablished, List<CoinResponse> coins) {
        super(mintId, mintName, mintLocation, mintYearEstablished);
        this.coins = coins;
    }
}
