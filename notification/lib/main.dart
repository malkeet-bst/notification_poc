import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = const MethodChannel('MethodChannelPlugin');
  final String title;

  _MyHomePageState({Key key, this.title}) : super() {
    platform.setMethodCallHandler(_handleMethod);
  }
  void startServiceInPlatform() async {
    if (Platform.isAndroid) {
      var methodChannel = MethodChannel("com.example.notification.messages");
      String data =
          await methodChannel.invokeMethod("startService", <String, dynamic>{
        'bar': "bar",
        'baz': "baz",
      });
      debugPrint(data);
    }
  }

  Future<dynamic> _handleMethod(MethodCall call) async {
    switch (call.method) {
      case "message":
        debugPrint(call.arguments);
        debugPrint("call.arguments");
        return new Future.value("");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: Center(
        child: RaisedButton(
            child: Text("Show notification"),
            onPressed: () {
              startServiceInPlatform();
            }),
      ),
    );
  }
}
