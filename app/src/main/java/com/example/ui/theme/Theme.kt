package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = TerracottaDark,
    onPrimary = Color(0xFF561802),
    primaryContainer = TerracottaContainerDark,
    onPrimaryContainer = TerracottaContainer,
    secondary = SageDark,
    onSecondary = Color(0xFF10371F),
    secondaryContainer = SageContainerDark,
    onSecondaryContainer = SageContainer,
    tertiary = OchreDark,
    onTertiary = Color(0xFF422C00),
    tertiaryContainer = OchreContainerDark,
    onTertiaryContainer = OchreContainer,
    background = StudioNight,
    onBackground = ChalkText,
    surface = StudioSurface,
    onSurface = ChalkText,
    surfaceVariant = StudioCard,
    onSurfaceVariant = ChalkMuted,
    outline = DarkOutline
)

private val LightColorScheme = lightColorScheme(
    primary = TerracottaPrimary,
    onPrimary = Color.White,
    primaryContainer = TerracottaContainer,
    onPrimaryContainer = OnTerracottaContainer,
    secondary = SageSecondary,
    onSecondary = Color.White,
    secondaryContainer = SageContainer,
    onSecondaryContainer = OnSageContainer,
    tertiary = OchreTertiary,
    onTertiary = Color.White,
    tertiaryContainer = OchreContainer,
    onTertiaryContainer = OnOchreContainer,
    background = CreamPaper,
    onBackground = CharcoalInk,
    surface = CardPaper,
    onSurface = CharcoalInk,
    surfaceVariant = WarmLinen,
    onSurfaceVariant = PencilSlate,
    outline = SoftOutline
)

val TekenStapShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

@Composable
fun TekenStapTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = TekenStapShapes,
        content = content
    )
}
