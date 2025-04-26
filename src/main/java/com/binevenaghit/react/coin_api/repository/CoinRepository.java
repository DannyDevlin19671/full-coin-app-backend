package com.binevenaghit.react.coin_api.repository;

import com.binevenaghit.react.coin_api.entity.Coin;
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
public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findByCoinDescription(String coinDescription);
    List<Coin> findByCoinMetal(String coinMetal);
    List<Coin> findByCoinWeight(double coinWeight);
    List<Coin> findByCoinPrice(double coinPrice);
    List<Coin> findByCoinFineness(double coinFineness);
    boolean existsByCoinDescription(String coinDescription);
    //List<Coin> findByMint(Mint mint); // OR:
    List<Coin> findByMint_MintName(String mintName); // Nested field lookup
    Optional<Coin> findByCoinId(Long coinId);
    void deleteById(Long id);
    //boolean existsByCoinNameAndCoinDescription(String coinName, String coinDescription);
}
