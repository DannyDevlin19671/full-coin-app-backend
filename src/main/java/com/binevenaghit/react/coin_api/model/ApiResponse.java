package com.binevenaghit.react.coin_api.model;

import java.util.List;

/**
 * @author danieldevlin
 * @date 25/04/2025
 * @project React-SpringBoot-Coin-App
 */
public class ApiResponse<T> {
    private String status;
    private T data;
    private List<String> errors;
    private ErrorResponse error;
    private String timestamp;

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
