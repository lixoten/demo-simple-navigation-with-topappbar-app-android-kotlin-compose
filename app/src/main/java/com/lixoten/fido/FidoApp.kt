package com.lixoten.fido

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lixoten.fido.presentation.DemoScreens

@Composable
fun FidoApp() {
    DemoScreens()
}

@Preview(showBackground = true)
@Composable
fun DefaultAppPreview() {
    DemoScreens()
}