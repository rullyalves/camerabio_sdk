import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:camerabiosdk/camerabiosdk.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        floatingActionButton: FloatingActionButton(onPressed:(){
          MethodChannel("plugins.virtuspay/cam").setMethodCallHandler((call) async{
            print(call.arguments);
          });
          
          MethodChannel("plugins.virtuspay/camerabio").invokeMethod("x");
        }),
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on'),
        ),
      ),
    );
  }
}
