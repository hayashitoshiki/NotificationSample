package com.myapp.notificationsample.ui.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import androidx.core.app.NotificationCompat
import com.myapp.notificationsample.R

/**
 * 通知処処理用クラス
 *
 */
class NotificationManager {

    companion object {
        const val NOTIFICATION_ID = 0
        const val CHANNEL_ID = "primary_notification_channel"
        const val CHANNEL_NAME = "Stand up notification"
    }

    private lateinit var notificationManager: NotificationManager


    // 通知表示
    fun show(context: Context) {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()
        showNotification("show Notification", context)
    }

    // カウントアップ
    fun showCountUp(context: Context, count: String) {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()
        showNotification(count, context)
    }


    // 通し設定　＆　通知表示
    private fun showNotification(title: String, context: Context) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            // アイコン
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            // タイトル
            .setContentTitle(title)
            // 本文テキスト
            .setContentText(title)
            // 通知の優先度
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    // チャンネル登録
    private fun createNotificationChannel() {
        // チャネル作成
        val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).also {
            it.enableLights(true)
            it.lightColor = Color.RED
            it.enableVibration(true)
            it.description = "AlarmManager Tests"
        }
        notificationManager.createNotificationChannel(notificationChannel)
    }
}
