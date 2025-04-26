package com.binevenaghit.react.coin_api.exception;

/**
 * @author danieldevlin
 * @date 25/04/2025
 * @project React-SpringBoot-Coin-App
 */
public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException(String message) {
        super(message);
    }

    public CoinNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
