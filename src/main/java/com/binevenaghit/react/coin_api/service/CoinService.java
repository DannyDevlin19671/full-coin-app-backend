package com.binevenaghit.react.coin_api.service;

import com.binevenaghit.react.coin_api.dto.CoinRequest;
import com.binevenaghit.react.coin_api.dto.CoinResponse;
import com.binevenaghit.react.coin_api.entity.Coin;
import com.binevenaghit.react.coin_api.entity.Mint;
import com.binevenaghit.react.coin_api.exception.CoinNotFoundException;
import com.binevenaghit.react.coin_api.mapper.CoinMintMapper;
import com.binevenaghit.react.coin_api.repository.CoinRepository;
import com.binevenaghit.react.coin_api.repository.MintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Coins
 * @author danieldevlin
 * @date 25/04/2025
 */
@Service
@RequiredArgsConstructor
public class CoinService {

    private final CoinRepository coinRepository;
    private final MintRepository mintRepository;
    private final CoinMintMapper mapper;

    // Get all coins
    public List<CoinResponse> getAllCoins() {
        return coinRepository.findAll()
                .stream()
                .map(mapper::toCoinResponse)
                .collect(Collectors.toList());
    }

    // Get a coin by ID
    public CoinResponse getCoinById(Long id) {
        Coin coin = coinRepository.findByCoinId(id)
                .orElseThrow(() -> new CoinNotFoundException("Coin not found with id " + id));
        return mapper.toCoinResponse(coin);
    }

    public CoinResponse createCoin(CoinRequest coinRequest) {
        if (coinRepository.existsByCoinDescription(coinRequest.getCoinDescription())) {
            throw new IllegalArgumentException("Coin description must be unique");
        }

        Mint mint = mintRepository.findById(coinRequest.getMintId())
                .orElseThrow(() -> new IllegalArgumentException("Mint not found"));

        Coin coin = new Coin(
                coinRequest.getCoinDescription(),
                coinRequest.getCoinWeight(),
                coinRequest.getCoinPrice(),
                coinRequest.getCoinName(),
                coinRequest.getCoinFineness(),
                coinRequest.getCoinMetal(),
                mint
        );

        Coin savedCoin = coinRepository.save(coin);
        return mapper.toCoinResponse(savedCoin);
    }

    // Update an existing coin
    public CoinResponse updateCoin(Long id, CoinRequest coinRequest) {
        Coin existingCoin = coinRepository.findById(id)
                .orElseThrow(() -> new CoinNotFoundException("Coin not found with id " + id));

        // Optional: check description uniqueness if description is changing
        if (!existingCoin.getCoinDescription().equals(coinRequest.getCoinDescription()) &&
                coinRepository.existsByCoinDescription(coinRequest.getCoinDescription())) {
            throw new IllegalArgumentException("Coin description must be unique");
        }

        Mint mint = mintRepository.findById(coinRequest.getMintId())
                .orElseThrow(() -> new IllegalArgumentException("Mint not found"));

        existingCoin.setCoinName(coinRequest.getCoinName());
        existingCoin.setCoinDescription(coinRequest.getCoinDescription());
        existingCoin.setCoinMetal(coinRequest.getCoinMetal());
        existingCoin.setCoinWeight(coinRequest.getCoinWeight());
        existingCoin.setCoinPrice(coinRequest.getCoinPrice());
        existingCoin.setCoinFineness(coinRequest.getCoinFineness());
        existingCoin.setMint(mint);

        Coin updatedCoin = coinRepository.save(existingCoin);
        return mapper.toCoinResponse(updatedCoin);
    }

    // Delete a coin
    public void deleteCoin(Long id) {
        Coin existingCoin = coinRepository.findById(id)
                .orElseThrow(() -> new CoinNotFoundException("Coin not found with id " + id));
        coinRepository.delete(existingCoin);
    }

    // Find coins by metal
    public List<CoinResponse> findByCoinMetal(String metal) {
        return coinRepository.findByCoinMetal(metal)
                .stream()
                .map(mapper::toCoinResponse)
                .collect(Collectors.toList());
    }

    // Find coins by price
    public List<CoinResponse> findByCoinPrice(double price) {
        return coinRepository.findByCoinPrice(price)
                .stream()
                .map(mapper::toCoinResponse)
                .collect(Collectors.toList());
    }

    // Find coins by weight
    public List<CoinResponse> findByCoinWeight(Double weight) {
        return coinRepository.findByCoinWeight(weight)
                .stream()
                .map(mapper::toCoinResponse)
                .collect(Collectors.toList());
    }

    // Find coins by fineness
    public List<CoinResponse> findByCoinFineness(Double fineness) {
        return coinRepository.findByCoinFineness(fineness)
                .stream()
                .map(mapper::toCoinResponse)
                .collect(Collectors.toList());
    }

    // Find coin by description
    public CoinResponse findByCoinDescription(String description) {
        Coin coin = coinRepository.findByCoinDescription(description)
                .orElseThrow(() -> new CoinNotFoundException("Coin not found with description " + description));
        return mapper.toCoinResponse(coin);
    }

    // Find coins by mint name
    public List<CoinResponse> findByMint_MintName(String mintName) {
        return coinRepository.findByMint_MintName(mintName)
                .stream()
                .map(mapper::toCoinResponse)
                .collect(Collectors.toList());
    }
}