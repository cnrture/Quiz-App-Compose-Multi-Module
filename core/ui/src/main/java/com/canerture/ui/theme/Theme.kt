package com.canerture.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object QuizAppTheme {
    val colors: QuizAppColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val icons: QuizAppIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalIcons.current

    val typography: ESimTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun QuizAppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColors provides QuizAppTheme.colors,
        LocalIcons provides QuizAppTheme.icons,
        LocalTypography provides QuizAppTheme.typography,
    ) {
        content()
    }
}