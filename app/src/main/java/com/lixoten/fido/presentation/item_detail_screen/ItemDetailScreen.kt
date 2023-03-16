package com.lixoten.fido.presentation.item_detail_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lixoten.fido.R
import com.lixoten.fido.navigation.Screen

@Composable
fun ItemDetailScreen(
    myInt: Int?,
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    val (text, setText) = remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Received the Integer: $myInt",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = text,
            onValueChange = setText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(
            onClick = {
                navController.navigate(
                    Screen.Fourth.routeWithArgs+text
                )
            }
        ) {
            Text(text = stringResource(id = R.string.fourth_button))
        }
    }
}