package com.binevenaghit.react.coin_api.service;

import com.binevenaghit.react.coin_api.dto.MintRequest;
import com.binevenaghit.react.coin_api.dto.MintResponse;
import com.binevenaghit.react.coin_api.dto.MintWithCoinsResponse;
import com.binevenaghit.react.coin_api.entity.Mint;
import com.binevenaghit.react.coin_api.exception.MintHasCoinsException;
import com.binevenaghit.react.coin_api.exception.MintNotFoundException;
import com.binevenaghit.react.coin_api.mapper.CoinMintMapper;
import com.binevenaghit.react.coin_api.repository.MintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Mints
 */
@Service
@RequiredArgsConstructor
public class MintService {

    private final MintRepository mintRepository;
    private final CoinMintMapper mapper;

    // Create a new mint
    public MintResponse createMint(MintRequest mintRequest) {
        Mint mint = new Mint(
                mintRequest.getMintName(),
                mintRequest.getMintLocation(),
                mintRequest.getMintYearEstablished()
        );

        Mint savedMint = mintRepository.save(mint);
        return mapper.toMintResponse(savedMint);
    }

    // Get all mints
    public List<MintResponse> getAllMints() {
        return mintRepository.findAll()
                .stream()
                .map(mapper::toMintResponse)
                .collect(Collectors.toList());
    }

    // Get a mint by ID
    public MintResponse getMintById(Long id) {
        Mint mint = mintRepository.findById(id)
                .orElseThrow(() -> new MintNotFoundException("Mint not found with id " + id));
        return mapper.toMintResponse(mint);
    }

    // Update an existing mint
    public MintResponse updateMint(Long id, MintRequest mintRequest) {
        Mint existingMint = mintRepository.findById(id)
                .orElseThrow(() -> new MintNotFoundException("Mint not found with id " + id));

        existingMint.setMintName(mintRequest.getMintName());
        existingMint.setMintLocation(mintRequest.getMintLocation());
        existingMint.setMintYearEstablished(mintRequest.getMintYearEstablished());

        Mint updatedMint = mintRepository.save(existingMint);
        return mapper.toMintResponse(updatedMint);
    }

    // Delete a mint
    public void deleteMint(Long id) {
        Mint existingMint = mintRepository.findById(id)
                .orElseThrow(() -> new MintNotFoundException("Mint not found with id " + id));

        if(existingMint.getCoins() != null && !existingMint.getCoins().isEmpty()) {
            throw new MintHasCoinsException("Cannot delete mint with associated coins");
        }

         // Delete the mint
        mintRepository.delete(existingMint);
    }

    // Get a mint along with its coins
    public MintWithCoinsResponse getMintWithCoins(Long id) {
        Mint mint = mintRepository.findById(id)
                .orElseThrow(() -> new MintNotFoundException("Mint not found with id " + id));
        return mapper.toMintWithCoinsResponse(mint);
    }
}