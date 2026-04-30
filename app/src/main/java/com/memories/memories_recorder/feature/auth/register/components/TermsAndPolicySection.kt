package com.memories.memories_recorder.feature.auth.register.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memories.memories_recorder.R
import com.memories.memories_recorder.ui.components.AppCheckBox
import com.memories.memories_recorder.ui.components.AppTextButton

@Composable
fun TermsAndPolicySection(
    isAccepted: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!isAccepted) },
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppCheckBox(
            checked = isAccepted,
            onCheckedChange = onCheckedChange
        )

        Text(
            text = stringResource(R.string.accept),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp)
        )

        AppTextButton(
            text = stringResource(R.string.term_condition),
            onClick = {},
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            ),
        )

        Text(
            text = stringResource(R.string.and),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp)
        )

        AppTextButton(
            text = stringResource(R.string.privacy_policy),
            onClick = {},
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            ),
        )
    }
}