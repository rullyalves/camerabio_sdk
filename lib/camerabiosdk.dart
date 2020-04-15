import 'dart:async';

import 'package:flutter/services.dart';

class Camerabiosdk {
  static const MethodChannel _channel =
      const MethodChannel('plugins.virtuspay/camerabio');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
