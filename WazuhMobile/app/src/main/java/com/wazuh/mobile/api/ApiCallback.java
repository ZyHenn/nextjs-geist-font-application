package com.wazuh.mobile.api;

// COMMENTED OUT - API Callback Interface
// This interface is used for handling API responses
// Uncomment when integrating with actual APIs

/*
public interface ApiCallback<T> {
    void onSuccess(T result);
    void onError(String error);
}
*/

// Placeholder interface for frontend testing
public interface ApiCallback<T> {
    // Placeholder methods - uncomment the actual implementation above when ready
    default void onSuccess(T result) {
        // Placeholder for success callback
    }
    
    default void onError(String error) {
        // Placeholder for error callback
    }
}
