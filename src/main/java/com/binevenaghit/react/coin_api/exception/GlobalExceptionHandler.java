package com.binevenaghit.react.coin_api.exception;

import com.binevenaghit.react.coin_api.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author danieldevlin
 * @date 25/04/2025
 * @project React-SpringBoot-Coin-App
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CoinNotFoundException.class)
    public ResponseEntity<?> handleCoinNotFoundException(CoinNotFoundException ex) {
        // Custom error response structure
        ErrorResponse errorResponse = new ErrorResponse("Coin not found", ex.getMessage(), Instant.now().toString());

        // Wrap the error response in a response entity and return 404 NOT_FOUND
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MintNotFoundException.class)
    public ResponseEntity<?> handleMintNotFoundException(MintNotFoundException ex) {
        // Custom error response structure
        ErrorResponse errorResponse = new ErrorResponse("Mint not found", ex.getMessage(), Instant.now().toString());

        // Wrap the error response in a response entity and return 404 NOT_FOUND
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MintHasCoinsException.class)
    public ResponseEntity<?> handleMintHasCoinsException(MintHasCoinsException ex) {
        // Custom error response structure
        ErrorResponse errorResponse = new ErrorResponse("Mint has coins", ex.getMessage(), Instant.now().toString());

        // Wrap the error response in a response entity and return 400 BAD_REQUEST
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Extract field error messages
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        // Join all errors into a single string
        String errorMessage = String.join("; ", errors);

        ErrorResponse errorResponse = new ErrorResponse(
                "Validation failed",
                errorMessage,
                Instant.now().toString()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Invalid request",
                ex.getMessage(),
                Instant.now().toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // You can also handle other exceptions here (e.g. Database exceptions, etc.)
}