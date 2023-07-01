package com.example.testweatherapp.presentation.screens.MainScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * A composable that displays a weather detail with an icon and a label with value.
 * It can be used to display details like wind speed, pressure, and humidity.
 *
 * @param icon An ImageVector representing the icon for the detail.
 * @param label A label for the detail.
 * @param value The value of the detail.
 * @param tint The color to apply to the icon. The default color is white.
 * @param modifier Modifier to apply to this layout's Composable.
 */

@Composable
fun WeatherDetail(
    icon: ImageVector,
    label: String,
    value: String,
    tint: Color = Color(0xFFF7F1F1),
    modifier: Modifier = Modifier
) {
    AssistChip(
        leadingIcon = { Icon(imageVector = icon, contentDescription = label, tint = tint) },
        label = { Text(text = value, modifier = Modifier.padding(vertical = 6.dp)) },
        shape = AssistChipDefaults.shape,
        onClick = {},
        border = AssistChipDefaults.assistChipBorder()
    )

}