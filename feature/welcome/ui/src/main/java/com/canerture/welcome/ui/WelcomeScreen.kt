package com.canerture.welcome.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
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
import com.canerture.ui.extensions.noRippleClickable
import com.canerture.feature.welcome.ui.R
import com.canerture.ui.components.QuizAppButton
import com.canerture.ui.components.QuizAppButtonType
import com.canerture.ui.components.QuizAppDialog
import com.canerture.ui.components.QuizAppLoading
import com.canerture.ui.components.QuizAppText
import com.canerture.ui.theme.QuizAppTheme
import com.canerture.welcome.ui.WelcomeContract.UiAction
import com.canerture.welcome.ui.WelcomeContract.UiEffect
import com.canerture.welcome.ui.WelcomeContract.UiState
import com.canerture.welcome.ui.components.buildDontHaveAnAccountSpannableText
import com.canerture.welcome.ui.components.buildPolicySpannableText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun WelcomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateLogin: () -> Unit,
    onNavigateRegister: () -> Unit,
    onNavigateHome: () -> Unit,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            UiEffect.NavigateLogin -> onNavigateLogin()
            UiEffect.NavigateRegister -> onNavigateRegister()
            UiEffect.NavigateHome -> onNavigateHome()
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
            Spacer(modifier = Modifier.height(24.dp))
            QuizAppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                text = stringResource(R.string.welcome_title),
                style = QuizAppTheme.typography.paragraph1,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(64.dp))
            QuizAppButton(
                modifier = Modifier.padding(horizontal = 32.dp),
                text = stringResource(R.string.continue_with_google),
                type = QuizAppButtonType.SECONDARY,
                icon = QuizAppTheme.icons.google,
                onClick = { onAction(UiAction.OnLoginWithGoogleClick) },
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = QuizAppTheme.colors.black,
                    thickness = 2.dp,
                )
                QuizAppText(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = stringResource(R.string.or),
                    style = QuizAppTheme.typography.paragraph1,
                    textAlign = TextAlign.Center,
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = QuizAppTheme.colors.black,
                    thickness = 2.dp,
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            QuizAppButton(
                modifier = Modifier.padding(horizontal = 32.dp),
                text = stringResource(R.string.sign_in_with_email),
                type = QuizAppButtonType.PRIMARY,
                onClick = { onAction(UiAction.OnLoginClick) },
            )
            Spacer(modifier = Modifier.height(24.dp))
            QuizAppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable { onAction(UiAction.OnRegisterClick) },
                text = buildDontHaveAnAccountSpannableText(),
                style = QuizAppTheme.typography.paragraph2,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(40.dp))
            QuizAppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                text = buildPolicySpannableText(),
                style = QuizAppTheme.typography.paragraph2,
                textAlign = TextAlign.Center,
            )
        }
    }

    if (uiState.isLoading) QuizAppLoading()

    if (uiState.dialogState != null) {
        QuizAppDialog(
            message = uiState.dialogState.message,
            isSuccess = uiState.dialogState.isSuccess,
            onDismiss = { onAction(UiAction.OnDismissDialog) },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(
        uiState = UiState(),
        uiEffect = emptyFlow(),
        onAction = {},
        onNavigateLogin = {},
        onNavigateRegister = {},
        onNavigateHome = {},
    )
}