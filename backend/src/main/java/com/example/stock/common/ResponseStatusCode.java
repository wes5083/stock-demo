package com.example.stock.common;

public enum ResponseStatusCode {
    SUCCESS(1, "success"),
    FAIL(0, "fail"),
    NOTSUPPORT(2,
            "not support");

    private final int value;
    private final String description;

    ResponseStatusCode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
