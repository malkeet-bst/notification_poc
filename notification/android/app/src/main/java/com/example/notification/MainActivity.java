package com.example.notification;



 import io.flutter.embedding.android.FlutterActivity;

 import android.content.Intent;
 import android.os.Build;
 import android.os.Bundle;

 import androidx.annotation.NonNull;

// import io.flutter.app.FlutterActivity;
 import io.flutter.embedding.engine.FlutterEngine;
 import io.flutter.plugin.common.MethodCall;
 import io.flutter.plugin.common.MethodChannel;
 import io.flutter.plugins.GeneratedPluginRegistrant;
 import io.flutter.view.FlutterView;

public class MainActivity extends FlutterActivity {

  private Intent forService;

  @Override
  public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
    super.configureFlutterEngine(flutterEngine);
    forService = new Intent(MainActivity.this, MyService.class);
    new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages")
            .setMethodCallHandler(
                    (call, result) -> {
                        if (call.method.equals("startService")) {
//                          new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages1").invokeMethod("message","msd");
            //               new MethodChannel(getFlutterView(), "com.example.notification.messages1").invokeMethod("message",null);
                          startService();
                          String bar = call.argument("bar"); // .argument returns the correct type
                          String baz = call.argument("baz"); // for the assignment
                          result.success(bar);
                        }
                    }
            );
  }
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    GeneratedPluginRegistrant.registerWith(this);
//    forService = new Intent(MainActivity.this, MyService.class);
//    new MethodChannel(getFlutterView(), "com.example.notification.messages")
//        .setMethodCallHandler(new MethodChannel.MethodCallHandler() {
//          @Override
//          public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
//            if (methodCall.method.equals("startService")) {
////               new MethodChannel(getFlutterView(), "com.example.notification.messages1").invokeMethod("message",null);
//              startService();
//              String bar = methodCall.argument("bar"); // .argument returns the correct type
//              String baz = methodCall.argument("baz"); // for the assignment
//              result.success(bar);
//            }
//          }
//        });
//
//  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    stopService(forService);
  }

  private void startService() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      startForegroundService(forService);
    } else {
      startService(forService);
    }
  }

}
