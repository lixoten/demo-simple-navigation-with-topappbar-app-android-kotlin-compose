package com.lixoten.fido.presentation.fourth_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lixoten.fido.R
import com.lixoten.fido.navigation.Screen

@Composable
fun FourthScreen(
    myStrg: String?,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Received the String: $myStrg",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                navController.popBackStack(
                    Screen.Home.route,
                    inclusive = false)
            }
        ) {
            Text(text = stringResource(id = R.string.home_screen_button))
        }
    }
}