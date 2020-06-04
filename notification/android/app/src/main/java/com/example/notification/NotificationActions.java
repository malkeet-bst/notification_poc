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
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.view.FlutterView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public class NotificationActions extends FlutterActivity {
//    private FlutterView flutterView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("created");
    }

    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        System.out.println("configure");
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages").invokeMethod("message","msd");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("strated");
//        FlutterEngine flutterEngine=new FlutterEngine();
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger()).invokeMethod("message","msd");
//        FlutterActivity flutterActivity= new FlutterActivity();
//        new MethodChannel(flutterActivity.getFlutterView(), "com.example.notification.messages1").invokeMethod("message",null);
    }
}
