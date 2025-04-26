package com.binevenaghit.react.coin_api.controller;

import com.binevenaghit.react.coin_api.dto.CoinRequest;
import com.binevenaghit.react.coin_api.dto.CoinResponse;
import com.binevenaghit.react.coin_api.entity.Coin;
import com.binevenaghit.react.coin_api.entity.Mint;
import com.binevenaghit.react.coin_api.mapper.CoinMintMapper;
import com.binevenaghit.react.coin_api.model.ApiResponse;
import com.binevenaghit.react.coin_api.repository.CoinRepository;
import com.binevenaghit.react.coin_api.repository.MintRepository;
import com.binevenaghit.react.coin_api.service.CoinService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author danieldevlin
 * @date 25/04/2025ß
 * @project React-SpringBoot-Coin-App
 */
@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CoinResponse>>> getAllCoins() {
        List<CoinResponse> coins = coinService.getAllCoins();
        ApiResponse<List<CoinResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coins);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/metal")
    public ResponseEntity<ApiResponse<List<CoinResponse>>> getByMetal(@RequestParam String metal) {
        List<CoinResponse> coins = coinService.findByCoinMetal(metal);
        ApiResponse<List<CoinResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coins);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/weight")
    public ResponseEntity<ApiResponse<List<CoinResponse>>> getByWeight(@RequestParam double weight) {
        List<CoinResponse> coins = coinService.findByCoinWeight(weight);
        ApiResponse<List<CoinResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coins);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/fineness")
    public ResponseEntity<ApiResponse<List<CoinResponse>>> getByFineness(@RequestParam double fineness) {
        List<CoinResponse> coins = coinService.findByCoinFineness(fineness);
        ApiResponse<List<CoinResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coins);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/description")
    public ResponseEntity<ApiResponse<CoinResponse>> getByDescription(@RequestParam String description) {
        CoinResponse coin = coinService.findByCoinDescription(description);
        ApiResponse<CoinResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coin);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/price")
    public ResponseEntity<ApiResponse<List<CoinResponse>>> getByPrice(@RequestParam double price) {
        List<CoinResponse> coins = coinService.findByCoinPrice(price);
        ApiResponse<List<CoinResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coins);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/mint")
    public ResponseEntity<ApiResponse<List<CoinResponse>>> getByMintName(@RequestParam String mintName) {
        List<CoinResponse> coins = coinService.findByMint_MintName(mintName);
        ApiResponse<List<CoinResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coins);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CoinResponse>> getById(@PathVariable Long id) {
        CoinResponse coinFound =  coinService.getCoinById(id);
        ApiResponse<CoinResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(coinFound);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<CoinResponse>> createCoin(@RequestBody @Valid CoinRequest coinRequest) {
        CoinResponse newCoin = coinService.createCoin(coinRequest);
        ApiResponse<CoinResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(newCoin);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<CoinResponse>> updateCoin(@PathVariable Long id, @RequestBody @Valid CoinRequest coinRequest) {
        CoinResponse updatedCoin = coinService.updateCoin(id, coinRequest);
        ApiResponse<CoinResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(updatedCoin);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoin(@PathVariable Long id) {
        coinService.deleteCoin(id);

        return ResponseEntity.noContent().build();
    }
}
