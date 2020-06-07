package com.example.notifkotlin
//import com.example.gametvflutter.R
import android.app.PendingIntent
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.notifkotlin.MainActivity
import com.example.notifkotlin.R
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant


class MyService : Service() {
    private val flutterView: FlutterView? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            val flutterEngine =  FlutterEngine(this.applicationContext)
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        val channel = MethodChannel(MainActivity.messenger1, "com.example.notification.messages")

            if(intent.action==Intent.ACTION_ANSWER){
                println("exiting")
                val flutterEngine =  FlutterEngine(this)
                if (flutterEngine != null) {

                    channel.invokeMethod("message","msd", object : MethodChannel.Result {
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
//                    MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.example.notification.messages").invokeMethod("message","msd");
//                    MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.notification.messages")
//                    flutterEngine.platformChannel.channel
//                            .invokeMethod("message","msd")
                };
//                stopSelf()
            }else {
//                val tournamentName: String = intent!!.getStringExtra("tournamentName")
//                val message: String = intent!!.getStringExtra("message")
                val intent = Intent(this, MyService::class.java)
                intent.setAction(Intent.ACTION_ANSWER)
//        intent.action = "Play"
                val pendingIntent = PendingIntent.getService(
                        this,
                        101,
                        intent,
                        PendingIntent.FLAG_CANCEL_CURRENT
                )
//        val Play = Intent(this, MyService::class.java)
//        Play.setAction(Intent.ACTION_ANSWER)
//        Play.action = "Play"
//        Play.putExtra("back", 0)
//        Play.putExtra("play", 1)
//        Play.putExtra("next", 0)
//        val pIntentback = PendingIntent.getBroadcast(this.applicationContext, 0, Play, PendingIntent.FLAG_UPDATE_CURRENT)

//        val broadcastIntent = Intent(this, NotificationReceiver::class.java)
//        broadcastIntent.putExtra("toastMessage", message)
//        val actionIntent = PendingIntent.getBroadcast(this,
//                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT)
                val builder = NotificationCompat.Builder(this, "messages")
                        .setSmallIcon(R.drawable.ic_launcher).setContentTitle("tournamentName")
                        .setContentText("message")
//                        .setPriority(NotificationCompat.PRIORITY_HIGH)
//                        .setCategory(NotificationCompat.CATEGORY_CALL)
//                .setContentIntent(pendingIntent)
                        .addAction(R.drawable.ic_launcher, "Exit", pendingIntent)
                        .setContentIntent(PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), 0))
                startForeground(101, builder.build())
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun startForegroundService(service: Intent?): ComponentName? {
        return super.startForegroundService(service)
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
    }
    companion object {
        private val flutterEngine: FlutterEngine? = null
    }
}
