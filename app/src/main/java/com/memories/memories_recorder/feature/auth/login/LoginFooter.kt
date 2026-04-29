package com.memories.memories_recorder.feature.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.components.AppButton
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginFooter(
    isLoading: Boolean,
    errorMessage: String?,
    onAction: (LoginAction) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceLg),
    ) {
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        AppButton(
            text = stringResource(R.string.sign_in),
            onClick = { onAction(LoginAction.OnSubmit) },
            isLoading = isLoading,
            fontWeight = FontWeight.Bold,
            backgroundColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(MaterialTheme.dimens.radiusSm),
            modifier = Modifier.fillMaxWidth()
        )

        // Switch mode link (Login <-> Register)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.not_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = MaterialTheme.dimens.textMd
                )
            )

            AppTextButton(
                text = stringResource(R.string.sign_up),
                onClick = { onAction(LoginAction.OnRegisterClick) },
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = MaterialTheme.dimens.textMd,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}