package com.myapp.notificationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.myapp.notificationsample.ui.screen.HomeScreen
import com.myapp.notificationsample.ui.theme.NotificationSampleTheme
import com.myapp.notificationsample.ui.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = HomeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationSampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen(viewModel)
                }
            }
        }
    }
}
