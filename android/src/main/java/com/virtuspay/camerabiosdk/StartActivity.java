package com.virtuspay.camerabiosdk;
import com.example.camerabioandroid.camerabiomanager.CallbackCameraBio;
import com.example.camerabioandroid.camerabiomanager.CameraBioManager;
import androidx.annotation.Nullable;
import android.app.Activity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;

public class StartActivity extends FlutterActivity implements CallbackCameraBio {
  private MethodChannel methodChannel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    methodChannel = new MethodChannel(getFlutterView(),"plugins.virtuspay/camerabio");

    CameraBioManager cb = new CameraBioManager(this);
    cb.startCamera();
  }

  @Override
  public void onSuccessCapture(String base64) {
    final Map<String,Object> result = new HashMap<>();
    result.put("image",base64);
    result.put("type","selfie");
   methodChannel.invokeMethod("algo",base64);
  }

  @Override
  public void onSuccessCaptureDocument(String base64) {
    final Map<String,Object> result = new HashMap<>();
    result.put("image",base64);
    result.put("type","document");
  }

  @Override
  public void onFailedCapture(String description) {

  }
}
