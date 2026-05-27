package com.example.firebaseauthmvvm.presentation.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PasswordValidationItem(
    text: String,
    isValid: Boolean
) {
    Row {
        Text(
            text =
                if (isValid) "✓"
            else "x"
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = text)
    }
}