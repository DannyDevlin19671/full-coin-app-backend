package com.binevenaghit.react.coin_api.model;

/**
 * @author danieldevlin
 * @date 25/04/2025
 * @project React-SpringBoot-Coin-App
 */
public class ErrorResponse {
    private String error;
    private String message;
    private String timestamp;

    public ErrorResponse(String error, String message, String timestamp) {
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}