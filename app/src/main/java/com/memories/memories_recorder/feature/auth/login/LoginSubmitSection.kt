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
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.components.AppButton
import com.memories.memories_recorder.ui.components.AppTextButton
import com.memories.memories_recorder.ui.theme.dimens

@Composable
fun LoginSubmitSection(
    isLoading: Boolean,
    errorMessage: String?,
    onRegisterClick: () -> Unit,
    onSubmit: () -> Unit,
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
            onClick = onSubmit,
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
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text =stringResource(R.string.not_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = MaterialTheme.dimens.textMd
                )
            )

            AppTextButton(
                text = stringResource(R.string.sign_up),
                onClick = onRegisterClick,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = MaterialTheme.dimens.textMd  ,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}