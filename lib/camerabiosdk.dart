import 'dart:async';

import 'package:flutter/services.dart';

class Camerabiosdk {
  final Function(Map<String, dynamic> result) onResult;
  static const MethodChannel _channel =
      const MethodChannel('plugins.virtuspay/camerabio');

  Camerabiosdk(this.onResult) {
    _channel.setMethodCallHandler((call) async {
      if(onResult != null){
        onResult(call.arguments)
      }
    });
  }
}
