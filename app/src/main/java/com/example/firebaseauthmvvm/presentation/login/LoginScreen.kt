package com.example.firebaseauthmvvm.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebaseauthmvvm.presentation.widgets.PasswordValidationItem

@Composable
fun LoginScreen (
    state: LoginState,
    onLoginClick: (String, String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    LaunchedEffect(state.user) {
        state.error?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    Box(
        modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text("Email")
                },
                isError = state.emailValidationError != null,
                supportingText = {
                    state.emailValidationError?.let {
                        Text(text = it)
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordValidationItem(
                text = "8+ Characters",
                isValid = state.passwordValidationError.hasMinLength
            )

            PasswordValidationItem(
                text = "Number",
                isValid = state.passwordValidationError.hasNumber
            )

            PasswordValidationItem(
                text = "Lowercase Letter",
                isValid = state.passwordValidationError.hasLowerCase
            )

            PasswordValidationItem(
                text = "Uppercase Letter",
                isValid = state.passwordValidationError.hasUpperCase
            )

            PasswordValidationItem(
                text = "Special Character",
                isValid = state.passwordValidationError.hasSpecialCharacter
            )

            Button(
                onClick = {
                    onLoginClick(email, password)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            TextButton(
                onClick = onRegisterClick
            ) {

                Text(
                    text = "Create Account"
                )
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}