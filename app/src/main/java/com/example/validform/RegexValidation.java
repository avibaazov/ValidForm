package com.example.validform;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;

public class RegexValidation implements Validation {
    private final View view;
    private final Pattern pattern;
    private final String errorMessage;

    public RegexValidation(View view, Pattern pattern, String errorMessage) {
        this.view = view;
        this.pattern = pattern;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean isValid() {
        String input = getText();
        return pattern.matcher(input).matches();
    }

    @Override
    public void showError() {
        if (!isValid()) {
            setError(errorMessage);
        }
    }

    @Override
    public void clearError() {
        setError(null);
    }



    private String getText() {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString().trim();
        } else if (view instanceof TextInputLayout) {
            return ((TextInputLayout) view).getEditText().getText().toString().trim();
        }
        return "";
    }

    private void setError(String error) {
        if (view instanceof EditText) {
            ((EditText) view).setError(error);
        } else if (view instanceof TextInputLayout) {
            ((TextInputLayout) view).setError(error);
        }
    }
}
