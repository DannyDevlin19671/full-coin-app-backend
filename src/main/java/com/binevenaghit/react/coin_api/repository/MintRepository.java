package com.binevenaghit.react.coin_api.repository;

import com.binevenaghit.react.coin_api.entity.Mint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author danieldevlin
 * @date 24/04/2025
 * @project React-SpringBoot-Coin-App
 */

@Repository
public interface MintRepository extends JpaRepository<Mint, Long> {
    Optional<Mint> findByMintName(String name);
    Optional<Mint> findByMintLocation(String location);
    List<Mint> findByMintYearEstablished(int yearEstablished);
    Optional<Mint> findByMintId(Long id);
}
