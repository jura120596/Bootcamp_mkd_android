package com.example.mkd.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private long userId;
    private String displayName;
    private String token;

    public LoggedInUser(long userId, String displayName, String token) {
        this.userId = userId;
        this.displayName = displayName;
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}
