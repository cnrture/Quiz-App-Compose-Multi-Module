package com.canerture.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canerture.ui.extensions.collectWithLifecycle
import com.canerture.feature.splash.ui.R
import com.canerture.ui.component.AnimatedLinearProgress
import com.canerture.ui.components.QuizAppText
import com.canerture.ui.theme.QuizAppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SplashScreen(
    uiEffect: Flow<SplashContract.UiEffect>,
    onNavigateWelcome: () -> Unit,
    onNavigateHome: () -> Unit,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            SplashContract.UiEffect.NavigateWelcome -> onNavigateWelcome()
            SplashContract.UiEffect.NavigateHome -> onNavigateHome()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(QuizAppTheme.colors.background),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = QuizAppTheme.icons.starPattern,
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier.size(112.dp),
                imageVector = QuizAppTheme.icons.star,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(40.dp))
            QuizAppText(
                text = stringResource(R.string.app_name),
                style = QuizAppTheme.typography.heading1,
            )
            Spacer(modifier = Modifier.height(76.dp))
            AnimatedLinearProgress()
            Spacer(modifier = Modifier.height(76.dp))
            QuizAppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                text = stringResource(R.string.splash_screen_title),
                style = QuizAppTheme.typography.heading2,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(16.dp))
            QuizAppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                text = stringResource(R.string.splash_screen_subtitle),
                style = QuizAppTheme.typography.paragraph1,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(
        uiEffect = emptyFlow(),
        onNavigateWelcome = {},
        onNavigateHome = {},
    )
}