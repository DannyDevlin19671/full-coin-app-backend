package com.binevenaghit.react.coin_api;

import com.binevenaghit.react.coin_api.entity.Coin;
import com.binevenaghit.react.coin_api.entity.Mint;
import com.binevenaghit.react.coin_api.repository.MintRepository;
import com.binevenaghit.react.coin_api.repository.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CoinApiApplication {

    private Logger logger = LoggerFactory.getLogger(CoinApiApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(CoinApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(MintRepository mintRepository, CoinRepository coinRepository) {
//        return args -> {
//            // Create Mints
//            Mint royalMint = new Mint("Royal Mint", "United Kingdom", 1986);
//            logger.info("Created Mint: {}", royalMint);
//            Mint usMint = new Mint("United States Mint", "United States", 1792);
//            logger.info("Created Mint: {}", usMint);
//            Mint canadianMint = new Mint("Royal Canadian Mint", "Canada", 1908);
//            logger.info("Created Mint: {}", canadianMint);
//            Mint australianMint = new Mint("Royal Australian Mint", "Australia", 1965);
//            logger.info("Created Mint: {}", australianMint);
//            mintRepository.saveAll(List.of(royalMint, usMint, canadianMint, australianMint));
//            logger.info("Saved all Mints to repository");
//
//            // Create Coins linked to Mints
//            Coin sovereign = new Coin("British gold coin", 7.98, 450.0, "Sovereign", 0.917, "Gold", royalMint);
//            logger.info("Created Coin: {}", sovereign);
//            Coin mapleLeaf = new Coin("Canadian gold coin", 31.1, 1800.0, "Maple Leaf", 0.9999, "Silver", canadianMint);
//            logger.info("Created Coin: {}", mapleLeaf);
//            Coin kangaroo = new Coin("Australian gold coin", 31.1, 1850.0, "Kangaroo", 0.9999, "Silver", australianMint);
//            logger.info("Created Coin: {}", kangaroo);
//            Coin britannia = new Coin("British silver coin", 31.1, 30.0, "Britannia", 0.999, "Silver", royalMint);
//            logger.info("Created Coin: {}", britannia);
//            Coin buffalo = new Coin("American gold coin", 31.1, 1900.0, "Buffalo", 0.9999, "Gold", usMint);
//            logger.info("Created Coin: {}", buffalo);
//
//            coinRepository.saveAll(List.of(sovereign, mapleLeaf, kangaroo, britannia, buffalo));
//            logger.info("Saved all Coins to repository");
//        };
//    }
}
