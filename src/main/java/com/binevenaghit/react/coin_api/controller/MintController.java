package com.binevenaghit.react.coin_api.controller;

import com.binevenaghit.react.coin_api.model.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.binevenaghit.react.coin_api.dto.MintRequest;
import com.binevenaghit.react.coin_api.dto.MintResponse;
import com.binevenaghit.react.coin_api.dto.MintWithCoinsResponse;
import com.binevenaghit.react.coin_api.service.MintService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/mints")
@RequiredArgsConstructor
public class MintController {

    private final MintService mintService;

    @PostMapping
    public ResponseEntity<ApiResponse<MintResponse>> createMint(@RequestBody @Valid MintRequest mintRequest) {
        MintResponse createdMint = mintService.createMint(mintRequest);
        ApiResponse<MintResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(createdMint);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MintResponse>>> getAllMints() {
        List<MintResponse> mints = mintService.getAllMints();
        ApiResponse<List<MintResponse>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(mints);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MintResponse>> getMintById(@PathVariable Long id) {
        MintResponse mint = mintService.getMintById(id);
        ApiResponse<MintResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(mint);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<MintResponse>> updateMint(@PathVariable Long id, @RequestBody @Valid MintRequest mintRequest) {
        MintResponse updatedMint = mintService.updateMint(id, mintRequest);
        ApiResponse<MintResponse> response = new ApiResponse<>();
        response.setStatus("success");
        response.setData(updatedMint);
        response.setTimestamp(Instant.now().toString());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMint(@PathVariable Long id) {
        mintService.deleteMint(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/coins/{id}")
    public ResponseEntity<MintWithCoinsResponse> getMintWithCoins(@PathVariable Long id) {
        MintWithCoinsResponse mintWithCoins = mintService.getMintWithCoins(id);
        return ResponseEntity.ok(mintWithCoins);
    }
}
