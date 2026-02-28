package com.example.s0801.handle;

public class ErrorResponse {
    private int status;
    private String message;
    private Long timestamp;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }


    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
