package com.example.validform;

import android.view.View;

public interface Validation {
    boolean isValid();
    void showError();
    void clearError();

}
