package com.myapp.notificationsample.ui.util

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
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
        /**
         * 通知ID
         */
        var notificationId = 0
    }

    /**
     * 通知の種類
     *
     * @property id チャンネルID
     * @property channelName チャンネル名
     * @property title 通知タイトル
     * @property explanation 説明
     */
    enum class CHANNELS(val id: String, val channelName: String, val title: String, val explanation: String) {
        CHANNEL1("show_sample", "Stand up notification","show Notification", "通知サンプル"),
        CHANNEL2("count_up", "second notification","count up", "カウントアップに関する通知")
    }

    private lateinit var notificationManager: NotificationManager


    // 通知表示
    fun show(context: Context) {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(CHANNELS.CHANNEL1)
        showNotification(CHANNELS.CHANNEL1,"show Notification", context)
    }

    // カウントアップ
    fun showCountUp(context: Context, count: String) {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(CHANNELS.CHANNEL2)
        showNotification(CHANNELS.CHANNEL2, count, context)
    }


    // 通し設定　＆　通知表示
    private fun showNotification(channel: CHANNELS, message: String, context: Context) {
        val builder = NotificationCompat.Builder(context, channel.id)
            // アイコン
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            // タイトル
            .setContentTitle(channel.title)
            // 本文テキスト
            .setContentText(message)
            // 通知の優先度
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        notificationManager.notify(notificationId, builder.build())
        notificationId ++
    }

    // チャンネル登録
    private fun createNotificationChannel(channel: CHANNELS) {
        // チャネル作成
        val notificationChannel = NotificationChannel(channel.id, channel.channelName, NotificationManager.IMPORTANCE_HIGH).also {
            it.enableLights(true)
            it.lightColor = Color.RED
            it.enableVibration(true)
            it.description = "AlarmManager Tests"
        }
        notificationManager.createNotificationChannel(notificationChannel)
    }
}
