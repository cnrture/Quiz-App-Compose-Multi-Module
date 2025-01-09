package com.canerture.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.canerture.ui.extensions.boldBorder
import com.canerture.ui.theme.QuizAppTheme

@Composable
fun QuizAppLinearProgress(
    modifier: Modifier = Modifier,
    value: Float,
    maxValue: Float = 100f,
    thickness: Dp = 24.dp,
    progressColor: Color = QuizAppTheme.colors.yellow,
    backgroundColor: Color = QuizAppTheme.colors.softGray,
) {
    val progress = 1f / maxValue * value
    Canvas(
        modifier = modifier
            .height(thickness)
            .boldBorder(100)
    ) {
        drawRoundRect(
            color = backgroundColor,
            size = size.copy(width = size.width),
            cornerRadius = CornerRadius(100f)
        )

        drawRoundRect(
            color = progressColor,
            size = size.copy(width = size.width * progress),
            cornerRadius = CornerRadius(100f)
        )
    }
}