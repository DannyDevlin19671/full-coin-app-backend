package com.binevenaghit.react.coin_api.mapper;

import com.binevenaghit.react.coin_api.dto.CoinResponse;
import com.binevenaghit.react.coin_api.dto.MintResponse;
import com.binevenaghit.react.coin_api.dto.MintWithCoinsResponse;
import com.binevenaghit.react.coin_api.entity.Coin;
import com.binevenaghit.react.coin_api.entity.Mint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoinMintMapper {

    public CoinResponse toCoinResponse(Coin coin) {
        return new CoinResponse(
                coin.getCoinId(),
                coin.getCoinDescription(),
                coin.getCoinWeight(),
                coin.getCoinPrice(),
                coin.getCoinName(),
                coin.getCoinFineness(),
                coin.getCoinMetal(),
                coin.getMint() != null ? coin.getMint().getMintId() : null
        );
    }

    public MintResponse toMintResponse(Mint mint) {
        return new MintResponse(
                mint.getMintId(),
                mint.getMintName(),
                mint.getMintLocation(),
                mint.getMintYearEstablished()
        );
    }

    public MintWithCoinsResponse toMintWithCoinsResponse(Mint mint) {
        List<CoinResponse> coinResponses = mint.getCoins()
                .stream()
                .map(this::toCoinResponse)
                .collect(Collectors.toList());

        return new MintWithCoinsResponse(
                mint.getMintId(),
                mint.getMintName(),
                mint.getMintLocation(),
                mint.getMintYearEstablished(),
                coinResponses
        );
    }
}
