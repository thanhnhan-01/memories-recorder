package com.memories.memories_recorder.feature.auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.memories.memories_recorder.feature.auth.ui.common.AuthHeader
import com.memories.memories_recorder.navigation.Routes
import com.memories.memories_recorder.ui.theme.AppDimens
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    var loginState by remember { mutableStateOf(LoginUiState()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimens.spaceXl)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(Dimens.sectionSpacing)
    ) {
        AuthHeader()

        LoginInputFields(
            loginState = loginState,
            onEmailChange = { loginState = loginState.copy(email = it) },
            onPasswordChange = { loginState = loginState.copy(password = it) },
            onPasswordVisibilityChange = {
                loginState = loginState.copy(passwordVisible = !loginState.passwordVisible)
            },
            onForgotPasswordClick = { navController.navigate(Routes.FORGOT_PASSWORD) },
        )

        LoginSubmitSection(
            isLoading = loginState.isLoading,
            errorMessage = loginState.errorMessage,
            onSubmit = { },
            onModeChange = { },
            onRegisterClick = { navController.navigate(Routes.REGISTER) },
        )
    }
}