
package com.example.notifkotlin
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import com.example.notifkotlin.MyService
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

// import io.flutter.app.FlutterActivity;


class MainActivity : FlutterActivity() {
    private var forService: Intent? = null
    private val CHANNEL = "com.example.notification.messages"

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    var methodResult: MethodChannel.Result? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        forService = Intent(this@MainActivity, MyService::class.java)
//        val channel = MethodChannel(registrar.messenger(), "NAME");
//        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.notification.messages")
//                .setMethodCallHandler { call: MethodCall, result: MethodChannel.Result ->
//                    if (call.method == "startService") {
////                        MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages").invokeMethod("message","msd");
//                        //               new MethodChannel(getFlutterView(), "com.example.notification.messages1").invokeMethod("message",null);
//                        startService()
//                        val bar = call.argument<String>("bar") // .argument returns the correct type
//                        val baz = call.argument<String>("baz")
//                        forService!!.putExtra("tournamentName", bar);
//                        forService!!.putExtra("message", baz);
//                        // for the assignment
//                        result.success(bar)
//                    }
//                }
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        val channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)

        channel.setMethodCallHandler { call, result ->
            methodResult = result
            if (call.method == "startService") {




                //Add you login here
//                MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.notification.messages").invokeMethod("message", "data1", object : MethodChannel.Result {
//                    override fun success(result: Any?) {
//                        println(result)
//                    }
//
//                    override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
//                        println(errorCode)
//                    }
//
//                    override fun notImplemented() {
//                        println("Unrealized getPlatform Method")
//                    }
//                })
                val bar = call.argument<String>("bar") // .argument returns the correct type
                val baz = call.argument<String>("baz")
                forService!!.putExtra("tournamentName", bar);
                forService!!.putExtra("message", baz);
                startService()
//                forService!!.putExtra("channel", channel);


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
