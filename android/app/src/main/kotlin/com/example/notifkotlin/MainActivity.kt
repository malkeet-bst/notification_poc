package com.example.notifkotlin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import com.example.notifkotlin.MyService
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

// import io.flutter.app.FlutterActivity;


class MainActivity : FlutterActivity() {
    companion object {
        var This: MainActivity? = null
        var messenger1: BinaryMessenger? = null
    }


    private var forService: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        This = this;
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        This = this;
        messenger1= flutterEngine.getDartExecutor().getBinaryMessenger()
//        MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages2").invokeMethod("message", "msd");
        forService = Intent(this@MainActivity, MyService::class.java)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.notification.messages")
                .setMethodCallHandler { call: MethodCall, result: MethodChannel.Result ->
                    if (call.method == "startService") {
//                        MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages2").invokeMethod("message","msd");
                        //               new MethodChannel(getFlutterView(), "com.example.notification.messages1").invokeMethod("message",null);
                        startService()
                        val bar = call.argument<String>("bar") // .argument returns the correct type
                        val baz = call.argument<String>("baz")
                        forService!!.putExtra("tournamentName", bar);
                        forService!!.putExtra("message", baz);
                        // for the assignment
                        result.success(bar)
                    }
                }
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
    override fun onDestroy() {
        super.onDestroy()
        stopService(forService)
    }

    private fun startService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(forService)
        } else {
            startService(forService)
        }
    }
}
