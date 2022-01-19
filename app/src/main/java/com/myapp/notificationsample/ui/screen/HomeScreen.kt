package com.myapp.notificationsample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.myapp.notificationsample.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Notification Sample")

            Button(
                onClick = { viewModel.showNotification(context) },
                modifier = Modifier.padding(top = 64.dp)
            ) {
                Text(text = "Show Notification")
            }
            Button(
                onClick = { viewModel.showNotificationCountUp(context) },
                modifier = Modifier.padding(top = 64.dp)
            ) {
                Text(text = "Show Notification(count up)")
            }
        }
    }
}