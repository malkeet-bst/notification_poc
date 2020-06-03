package com.example.notification;

import android.app.Service;
import android.content.Intent;
import android.app.PendingIntent;

import android.os.Build;
import android.os.IBinder;

import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    private static FlutterEngine flutterEngine;
    private FlutterView flutterView;

    @Override
    public void onCreate() {
        super.onCreate();
        Intent snoozeIntent = new Intent(this, MyService.class);
        snoozeIntent.setAction("ACTION_SNOOZE");
        snoozeIntent.putExtra("EXTRA_NOTIFICATION_ID", 0);
        PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(this, 0, snoozeIntent, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // NotificationCompat.Builder builder = new
            // NotificationCompat.Builder(this,"messages")
            // .setContentText("This is running in Background")
            // .setContentTitle("Flutter Background")
            // .setSmallIcon(R.drawable.ic_android_black_24dp);
            // String channelName = "wingquest.stablekernel.io/speech";
            // MethodChannel(getFlutterView(),
            // channelName).invokeMethod("didRecieveTranscript", "utterance");
            // String[] args = getArgsFromIntent(getIntent());
            // setContentView(R.layout.flutter_view_layout);
            // if (flutterEngine == null) {
            // flutterEngine = new FlutterEngine(this, args);
            // flutterEngine.getDartExecutor().executeDartEntrypoint(
            // DartEntrypoint.createDefault()
            // );
            // }

            // flutterView = findViewById(R.id.flutter_view);
            // flutterView.attachToFlutterEngine(flutterEngine);
            // MethodChannel(flutterView,
            // "flutter.rortega.com.basicchannelcommunication").invokeMethod("message",
            // "Hello from native host");
            // Intent intent = new Intent(this, MyService.class);
            // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "messages")
                    .setSmallIcon(R.drawable.ic_android_black_24dp).setContentTitle("My notification")
                    .setContentText("Hello MSD!").setAutoCancel(true);
                    // .setContentIntent(pendingIntent)
//                    .addAction(R.drawable.ic_snooze, "Exit", snoozePendingIntent)
//                    .setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0));

            startForeground(101, builder.build());
        }

    }
    

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
