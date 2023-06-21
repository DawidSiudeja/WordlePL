package com.example.zgadnijslowo.presentation.screens.game

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EndGameDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    message: String,
    title: String,
) {

    if(showDialog) {
        AlertDialog(
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                Button(
                    onClick = { onConfirm() }
                ) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text(text = "No, thanks")
                }
            },
            onDismissRequest = { onDismiss() }
        )
    }

}