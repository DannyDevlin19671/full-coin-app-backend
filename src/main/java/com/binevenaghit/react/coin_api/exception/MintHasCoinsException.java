package com.binevenaghit.react.coin_api.exception;

/**
 * @author danieldevlin
 * @date 26/04/2025
 * @project React-SpringBoot-Coin-App
 */
public class MintHasCoinsException extends RuntimeException {
    public MintHasCoinsException(String message) {
        super(message);
    }
}
