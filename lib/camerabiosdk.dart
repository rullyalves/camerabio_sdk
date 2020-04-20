import 'dart:async';

import 'package:flutter/services.dart';

class Camerabiosdk {

  static const MethodChannel _channel =
      const MethodChannel('plugins.virtuspay/camerabio');

  Camerabiosdk() {
    _channel.setMethodCallHandler((call) async {
   print(call.arguments);
    });
  }
}
