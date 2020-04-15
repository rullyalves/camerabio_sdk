package com.virtuspay.camerabiosdk;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;



public class CamerabiosdkPlugin implements FlutterPlugin,MethodChannel.MethodCallHandler {
  private MethodChannel channel;
  private Context context;

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "plugins.virtuspay/camerabio");
    final CamerabiosdkPlugin camerabiosdkPlugin = new CamerabiosdkPlugin();
    camerabiosdkPlugin.setContext(registrar.activity());
    channel.setMethodCallHandler(camerabiosdkPlugin);
  }

  @Override
  public void onMethodCall(MethodCall call, MethodChannel.Result result) {
    Intent intent = new Intent(context,StartActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  public void setContext(Context context) {
    this.context = context;
  }

  public void onAttachedToEngine(FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "plugins.virtuspay/camerabio");
    channel.setMethodCallHandler(this);
    context = flutterPluginBinding.getApplicationContext();
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding flutterPluginBinding) {
   channel.setMethodCallHandler(null);
   channel = null;
   context = null;
  }
}



