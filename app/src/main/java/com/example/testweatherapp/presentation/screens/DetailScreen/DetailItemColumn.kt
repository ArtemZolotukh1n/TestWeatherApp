package com.example.testweatherapp.presentation.screens.DetailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * A composable that displays a detail item in a column format.
 *
 * @param value The value of the detail.
 * @param icon The icon representing the detail.
 * @param label The label for the detail.
 * @param modifier An optional [Modifier] for the composable.
 * @param tint An optional [Color] for the icon's tint.
 */
@Composable
fun DetailItemColumn(
    value: String,
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier.padding(vertical = 8.dp),
    tint: Color = Color(0xFFF7F1F1),
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(2.dp))
        Icon(imageVector = icon, contentDescription = null, tint = tint)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = label, style = MaterialTheme.typography.labelSmall)
    }
}