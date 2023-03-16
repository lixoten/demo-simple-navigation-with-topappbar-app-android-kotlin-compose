package com.lixoten.fido.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun AppTopBar(
    currentScreenResId: Int,
    canNavigateBack: Boolean,
    navigateUpClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = currentScreenResId)) },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUpClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "stringResource(R.string.back_button)"
                    )
                }
            }
        }
    )
}