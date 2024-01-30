package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
//    override fun onReceive(context: Context, intent: Intent) {
//        Toast.makeText(context, "Boot Complete",
//            Toast.LENGTH_LONG).show()
//    }
override fun onReceive(context: Context, intent: Intent) {
    Toast.makeText(context, "received in MyBroadcastReceiver",
        Toast.LENGTH_SHORT).show()
    abortBroadcast()
}
}