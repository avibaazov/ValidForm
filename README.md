# ValidForm - Android Form Validation Library

**ValidForm** is a simple yet powerful form validation library for Android, designed to make form validation easy and customizable. Whether you're building a registration form, login screen, or profile update form, ValidForm provides all the tools you need to validate user input effectively.

## Features

- **Pre-defined Validation Patterns**: Includes common patterns for email, phone numbers, postal codes, etc.
- **Auto-Focus on First Error**: Automatically focus on the first invalid field, guiding users to correct errors quickly.
- **Password Confirmation**: Validate that two fields (e.g., password and confirm password) match.
- **Error Message Customization**: Customize how and where error messages are displayed.

## Installation

To clone this repository, use the following link:

```
git clone https://github.com/avibaazov/ValidForm.git
```
## Usage

### 1. Initialize `FormValidator`

Create an instance of `FormValidator` in your `Activity` or add validations:

```java
FormValidator formValidator = new FormValidator(this)
        .addValidation(R.id.nameEditText, ValidationPatterns.NAME, R.string.error_invalid_name)
        .addValidation(R.id.emailEditText, ValidationPatterns.EMAIL, R.string.error_invalid_email)
        .addPasswordConfirmation(R.id.passwordEditText, R.id.confirmPasswordEditText, R.string.error_password_mismatch)
        .setAutoFocusOnFirstError(true)
        .setOnValidationResultListener(isValid -> {
            if (isValid) {
                // Handle valid form submission
                Toast.makeText(this, "Form is valid! Proceeding with registration.", Toast.LENGTH_SHORT).show();
            } else {
                // Handle invalid form submission
                Toast.makeText(this, "Please correct the errors in the form.", Toast.LENGTH_SHORT).show();
            }
        });
```
### 2. Use Pre-defined Patterns

ValidForm provides pre-defined patterns for common validation needs:

```java
formValidator.addValidation(R.id.phoneEditText, ValidationPatterns.PHONE, R.string.error_invalid_phone);
formValidator.addValidation(R.id.creditCardEditText, ValidationPatterns.CREDIT_CARD, R.string.error_invalid_credit_card);
```
5. Handle Validation Results

Handle validation results through a callback:

```java

formValidator.setOnValidationResultListener(isValid -> {
    if (isValid) {
        // Proceed with form submission
    } else {
        // Show error message
    }
});
```
## Explanation of Methods

- **`.addValidation(int viewId, String pattern, int errorMessageResId)`**:
  - **Purpose**: This method adds a validation rule to the specified input field.
  - **Parameters**:
    - `viewId`: The ID of the input field to be validated (e.g., `R.id.nameEditText`).
    - `pattern`: A regex pattern or pre-defined pattern from `ValidationPatterns` that the input should match (e.g., `ValidationPatterns.NAME`).
    - `errorMessageResId`: The resource ID of the error message to be displayed if validation fails (e.g., `R.string.error_invalid_name`).
  - **Example**:
    ```java
    formValidator.addValidation(R.id.nameEditText, ValidationPatterns.NAME, R.string.error_invalid_name);
    ```

- **`.addPasswordConfirmation(int passwordViewId, int confirmPasswordViewId, int errorMessageResId)`**:
  - **Purpose**: This method ensures that the value in the confirmation field matches the value in the original password field.
  - **Parameters**:
    - `passwordViewId`: The ID of the original password input field (e.g., `R.id.passwordEditText`).
    - `confirmPasswordViewId`: The ID of the confirmation password input field (e.g., `R.id.confirmPasswordEditText`).
    - `errorMessageResId`: The resource ID of the error message to be displayed if the passwords do not match (e.g., `R.string.error_password_mismatch`).
  - **Example**:
    ```java
    formValidator.addPasswordConfirmation(R.id.passwordEditText, R.id.confirmPasswordEditText, R.string.error_password_mismatch);
    ```

- **`.setAutoFocusOnFirstError(boolean autoFocus)`**:
  - **Purpose**: This method configures the form to automatically focus on the first input field that fails validation.
  - **Parameters**:
    - `autoFocus`: A boolean value that, if set to `true`, enables auto-focus on the first invalid field. If set to `false`, auto-focus is disabled.
  - **Example**:
    ```java
    formValidator.setAutoFocusOnFirstError(true);
    ```

Each of these methods contributes to making the form validation process smooth and user-friendly by ensuring that inputs are validated according to the defined rules, and that the user is guided to correct errors efficiently.

## Screenshots

![image](https://github.com/user-attachments/assets/4868a91c-99a0-4929-a4df-bffac025ab06)
![image](https://github.com/user-attachments/assets/8d55144f-c1ab-486e-ae33-eff433ed965f)
