package com.example.zgadnijslowo.presentation.screens.game

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zgadnijslowo.ui.theme.alertDialogBackgroundColor
import com.example.zgadnijslowo.ui.theme.greenColor
import com.example.zgadnijslowo.ui.theme.textColor

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
            backgroundColor = MaterialTheme.colors.alertDialogBackgroundColor,
            title = {
                Text(
                    text = title,
                    color = MaterialTheme.colors.textColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize
                )
            },
            text = {
                Text(
                    text = message,
                    color = MaterialTheme.colors.textColor,
                )
           },
            confirmButton = {
                Button(
                    onClick = { onConfirm() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = greenColor
                    )
                ) {
                    Text(
                        text = "Play again!",
                        color = Color.White
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent
                    ),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "No, thanks",
                        color = Color.White
                    )
                }
            },
            onDismissRequest = { onDismiss() }
        )
    }

}