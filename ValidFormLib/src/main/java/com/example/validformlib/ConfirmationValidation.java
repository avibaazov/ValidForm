package com.example.validformlib;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

public class ConfirmationValidation implements Validation {
    private final View passwordView;
    private final View confirmPasswordView;
    private final String errorMessage;

    public ConfirmationValidation(View passwordView, View confirmPasswordView, String errorMessage) {
        this.passwordView = passwordView;
        this.confirmPasswordView = confirmPasswordView;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isValid() {
        String password = getText(passwordView);
        String confirmPassword = getText(confirmPasswordView);
        return password.equals(confirmPassword);
    }

    @Override
    public void showError() {
        if (!isValid()) {
            setError(confirmPasswordView, errorMessage);
        }
    }

    @Override
    public void clearError() {
        setError(confirmPasswordView, null);
    }

    private String getText(View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString().trim();
        } else if (view instanceof TextInputLayout) {
            return ((TextInputLayout) view).getEditText().getText().toString().trim();
        }
        return "";
    }

    private void setError(View view, String error) {
        if (view instanceof EditText) {
            ((EditText) view).setError(error);
        } else if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setError(error);
        }
    }
}
