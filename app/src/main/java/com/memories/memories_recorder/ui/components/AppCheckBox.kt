package com.memories.memories_recorder.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppCheckBox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier.size(24.dp),
        enabled = enabled,
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.primary,
            uncheckedColor = MaterialTheme.colorScheme.outline,
            checkmarkColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}