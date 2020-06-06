package com.example.notifkotlin
import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

//import io.flutter.embedding.android.FlutterView;
//import io.flutter.embedding.android.FlutterActivity;
class NotificationActions : FlutterActivity() {
        override fun onStart() {
                super.onStart()
        }

        override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
                super.onCreate(savedInstanceState, persistentState)
        }
        override fun onCreate(savedInstanceState: Bundle) {
                super.onCreate(savedInstanceState)
//        GeneratedPluginRegistrant.registerWith(this)
//                val methodChannel = MethodChannel(flutterView, "com.example.notification.messages1")
//                methodChannel.invokeMethod("message", "leave_call", object : MethodChannel.Result {
//                        override fun success(result: Any?) {
//                                println(result)
//                        }
//
//                        override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
//                                println(errorCode)
//                        }
//
//                        override fun notImplemented() {
//                                println("Unrealized getPlatform Method")
//                        }
//                })
        }
}