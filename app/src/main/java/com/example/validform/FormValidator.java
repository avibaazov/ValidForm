package com.example.validform;

import android.app.Activity;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class FormValidator {

    private final Map<View, Validation> validations = new HashMap<>();
    private final Activity activity;
    private ValidationResultListener validationResultListener;

    public FormValidator(Activity activity) {
        this.activity = activity;
    }

    // Add regex-based validation
    public FormValidator addValidation(int viewId, String regex, int errorMessageResId) {
        View view = activity.findViewById(viewId);
        String errorMessage = activity.getString(errorMessageResId);
        Pattern pattern = Pattern.compile(regex);
        Validation validation = new RegexValidation(view, pattern, errorMessage);
        validations.put(view, validation);
        return this;
    }

    // Add password confirmation validation
    public FormValidator addPasswordConfirmation(int passwordViewId, int confirmPasswordViewId, int errorMessageResId) {
        View passwordView = activity.findViewById(passwordViewId);
        View confirmPasswordView = activity.findViewById(confirmPasswordViewId);
        String errorMessage = activity.getString(errorMessageResId);
        Validation validation = new ConfirmationValidation(passwordView, confirmPasswordView, errorMessage);
        validations.put(confirmPasswordView, validation);
        return this;
    }

    // Set the validation result listener
    public FormValidator setOnValidationResultListener(ValidationResultListener listener) {
        this.validationResultListener = listener;
        return this;
    }

    // Validate all fields and trigger the callback
    public boolean validate() {
        boolean isValid = true;
        for (Validation validation : validations.values()) {
            if (!validation.isValid()) {
                validation.showError();
                isValid = false;
            } else {
                validation.clearError();
            }
        }
        // Trigger the callback
        if (validationResultListener != null) {
            validationResultListener.onValidationResult(isValid);
        }
        return isValid;
    }

    // Clear all errors
    public void clearAllErrors() {
        for (Validation validation : validations.values()) {
            validation.clearError();
        }
    }
}
