package com.example.csc_homework3

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DisplayHeading(heading: String){
    Text(text = heading,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineMedium,
        fontSize =  36.sp
    )
}
@Composable
fun DisplayTitle(heading: String){
    Text(text = heading,
        color = MaterialTheme.colorScheme.secondary,
        style = MaterialTheme.typography.titleMedium,
        fontSize =  18.sp

    )
}
@Composable
fun DisplayNormalText(text: String){
    Text(text = text,
        color = Color.Magenta,
        style = MaterialTheme.typography.bodyLarge,
        fontSize =  16.sp
    )
}

