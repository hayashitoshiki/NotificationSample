package com.myapp.notificationsample.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.myapp.notificationsample.ui.util.NotificationManager

class HomeViewModel: ViewModel() {

    private val notificationManager = NotificationManager()
    private var count = 1

    fun showNotification(context: Context) {
        notificationManager.show(context)
    }
    fun showNotificationCountUp(context: Context) {
        notificationManager.showCountUp(context, count.toString())
        count ++
    }
}