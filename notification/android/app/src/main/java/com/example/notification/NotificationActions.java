package com.example.notification;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//import io.flutter.embedding.android.FlutterView;
//import io.flutter.embedding.android.FlutterActivity;
 import io.flutter.app.FlutterActivity;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class NotificationActions extends FlutterActivity {
//    private FlutterView flutterView;


//    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
//        super.configureFlutterEngine(flutterEngine);
//        System.out.println("configure");
////        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages").invokeMethod("message","msd");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
        MethodChannel methodChannel = new MethodChannel(getFlutterView(), "MethodChannelPlugin");
        methodChannel.invokeMethod("message", "leave_call", new MethodChannel.Result() {
            @Override
            public void success(@Nullable Object result) {
                System.out.println(result);
            }

            @Override
            public void error(String errorCode, @Nullable String errorMessage, @Nullable Object errorDetails) {
                System.out.println(errorCode);
            }

            @Override
            public void notImplemented() {
                System.out.println("Unrealized getPlatform Method");
            }
        });

    }
}
