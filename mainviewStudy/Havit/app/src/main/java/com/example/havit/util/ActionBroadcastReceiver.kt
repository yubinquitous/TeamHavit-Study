package com.example.havit.util

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.app.PendingIntent
import android.widget.RemoteViews
import com.example.havit.R


class ActionBroadcastReceiver:BroadcastReceiver() {

    companion object{
        val KEY_ACTION_SOURCE = "org.chromium.customtabsdemos.ACTION_SOURCE"
        val ACTION_ACTION_BUTTON = 1
        val ACTION_MENU_ITEM = 2
        val ACTION_TOOLBAR = 3




    }


    override fun onReceive(context: Context, intent: Intent) {
        val url: String? = intent.getDataString()
        if (url != null) {
            val toastText: String =
                getToastText(context, intent.getIntExtra(KEY_ACTION_SOURCE, -1), url)
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getToastText(context: Context, actionId: Int, url: String): String {
        return when (actionId) {
            ACTION_ACTION_BUTTON -> context.getString(ACTION_ACTION_BUTTON, url)
            ACTION_MENU_ITEM -> context.getString(ACTION_MENU_ITEM, url)
            ACTION_TOOLBAR -> context.getString(ACTION_TOOLBAR, url)
            else -> context.getString(0, url)
        }
    }


}