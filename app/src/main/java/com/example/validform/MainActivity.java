package com.example.validform;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;
    private FormValidator formValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.registerButton);

        formValidator = new FormValidator(this)
                .addValidation(R.id.emailEditText, ValidationPatterns.EMAIL, R.string.error_invalid_email)
                .addValidation(R.id.passwordEditText, ValidationPatterns.PASSWORD, R.string.error_short_password)
                .addValidation(R.id.nameEditText, ValidationPatterns.NAME, R.string.error_invalid_name)
                .addPasswordConfirmation(R.id.passwordEditText, R.id.confirmPasswordEditText, R.string.error_password_mismatch)
                .addValidation(R.id.phoneEditText, ValidationPatterns.PHONE, R.string.error_invalid_phone)
                .addValidation(R.id.postalCodeEditText, ValidationPatterns.POSTAL_CODE, R.string.error_invalid_postal_code)

                .setOnValidationResultListener(isValid -> {
                    if (isValid) {
                        Toast.makeText(this, "Form is valid! Proceeding with registration.", Toast.LENGTH_SHORT).show();
                        // Handle valid form
                    } else {
                        Toast.makeText(this, "Please correct the errors in the form.", Toast.LENGTH_SHORT).show();
                        // Handle invalid form
                    }
                });

        registerButton.setOnClickListener(v -> formValidator.validate());
    }
}