package com.example.notification

import android.os.Bundle
import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

//import io.flutter.embedding.android.FlutterView;
//import io.flutter.embedding.android.FlutterActivity;
class Notif : FlutterActivity() {
    //    private FlutterView flutterView;
    //    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    //        super.configureFlutterEngine(flutterEngine);
    //        System.out.println("configure");
    ////        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages").invokeMethod("message","msd");
    //    }
    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
//        GeneratedPluginRegistrant.registerWith(this)
        val methodChannel = MethodChannel(flutterView, "MethodChannelPlugin")
        methodChannel.invokeMethod("message", "leave_call", object : MethodChannel.Result {
            override fun success(result: Any?) {
                println(result)
            }

            override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
                println(errorCode)
            }

            override fun notImplemented() {
                println("Unrealized getPlatform Method")
            }
        })
    }
}