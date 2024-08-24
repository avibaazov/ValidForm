package com.example.validform;

import android.util.Patterns;

public class ValidationPatterns {
    public static final String EMAIL = Patterns.EMAIL_ADDRESS.pattern();
    public static final String PHONE = "^(\\+\\d{1,3}[- ]?)?\\d{3}[- ]?\\d{3}[- ]?\\d{4}$"
            ; // Basic phone number pattern
    public static final String POSTAL_CODE = "^[0-9]{5}(-[0-9]{4})?$"; // US postal code pattern
    public static final String NAME = "[a-zA-Z\\s]+";
    public static final String PASSWORD = ".{6,}"; // At least 6 characters
    public static final String DATE_DDMMYYYY = "^\\d{2}/\\d{2}/\\d{4}$"; // Date format dd/mm/yyyy
    public static final String URL = Patterns.WEB_URL.pattern(); // URL pattern
}
