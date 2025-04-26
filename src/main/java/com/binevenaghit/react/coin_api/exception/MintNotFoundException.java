package com.binevenaghit.react.coin_api.exception;

/**
 * Custom exception thrown when a Mint is not found
 */
public class MintNotFoundException extends RuntimeException {

    public MintNotFoundException(String message) {
        super(message);
    }
}
