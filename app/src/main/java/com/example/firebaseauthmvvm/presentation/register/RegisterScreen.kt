package com.example.firebaseauthmvvm.presentation.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.firebaseauthmvvm.presentation.widgets.PasswordValidationItem

@Composable
fun RegisterScreen(
    state: RegisterState,
    onRegisterClick: (
            String, String, String
            ) -> Unit,
    onPasswordChanged: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val context =  LocalContext.current

    LaunchedEffect(state.user) {
        state.user?.let {
            Toast.makeText(context, "Registration success", Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(state.error) {
        state.error?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Register",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email")
                },
                isError = state.emailError != null,
                supportingText = {
                    state.emailError?.let {
                        Text(it)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    onPasswordChanged(it)
                },
                label = {
                    Text("Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            PasswordValidationItem(
                text = "8+ Characters",
                isValid =
                    state.passwordValidation
                        .hasMinLength
            )

            PasswordValidationItem(
                text = "Lowercase Letter",
                isValid =
                    state.passwordValidation
                        .hasLowerCase
            )

            PasswordValidationItem(
                text = "Uppercase Letter",
                isValid =
                    state.passwordValidation
                        .hasUpperCase
            )

            PasswordValidationItem(
                text = "Number",
                isValid =
                    state.passwordValidation
                        .hasNumber
            )

            PasswordValidationItem(
                text = "Special Character",
                isValid =
                    state.passwordValidation
                        .hasSpecialCharacter
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                },
                label = {
                    Text("Confirm Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                isError = state.confirmPasswordError != null,
                supportingText = {
                    state.confirmPasswordError?.let {
                        Text(it)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                onRegisterClick(
                    email, password, confirmPassword
                )
            },
                enabled = !state.isLoading,
                modifier = Modifier.fillMaxWidth()) {
                Text("Register")
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}