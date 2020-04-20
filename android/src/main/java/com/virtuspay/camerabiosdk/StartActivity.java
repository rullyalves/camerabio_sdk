package com.virtuspay.camerabiosdk;
import com.example.camerabioandroid.camerabiomanager.CallbackCameraBio;
import com.example.camerabioandroid.camerabiomanager.CameraBioManager;
import androidx.annotation.Nullable;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.w3c.dom.DocumentType;

import java.util.HashMap;
import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class StartActivity extends FlutterActivity implements CallbackCameraBio, MethodChannel.MethodCallHandler {
  private MethodChannel methodChannel;
  private FlutterEngine flutterEngine;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    flutterEngine = new FlutterEngine(this);
    methodChannel = new MethodChannel(getFlutterView().getDartExecutor().getBinaryMessenger(),"plugins.virtuspay/cam");

    methodChannel.setMethodCallHandler(this);

/*

    public static final int RG_FRENTE = 501;
    public static final int RG_VERSO = 502;
    public static final int CNH = 4;
    public static final int NONE = 99;

 */
    CameraBioManager cb = new CameraBioManager(this);
    cb.startCamera();
   // cb.startCameraDocument(CameraBioManager.RG_FRENTE);
  }

  @Override
  public void onSuccessCapture(final String base64) {
    new Handler(Looper.getMainLooper()).post(
            new Runnable() {
              @Override
              public void run() {
                final Map<String,Object> result = new HashMap<>();
                result.put("image",base64);

                Log.d("ONSUCCESS","CAPTURADO COM SUCESSO");
                methodChannel.invokeMethod("algo",result);

              }
            }
    );



  }

  @Override
  public void onSuccessCaptureDocument(final String base64) {
    new Handler(Looper.getMainLooper()).post(
            new Runnable() {
              @Override
              public void run() {
                final Map<String,Object> result = new HashMap<>();
                result.put("image",base64);
                result.put("type","document");
                Log.d("ONSUCCESSDOCUMENT","CAPTURADO COM SUCESSO");
                methodChannel.invokeMethod("algo",result);
              }
            }

    );
  }

  @Override
  public void onFailedCapture(String description) {
    new Handler(Looper.getMainLooper()).post(new Runnable() {
      @Override
      public void run() {

        Log.d("ONERROR","CAPTURADO COM ERRO");
        methodChannel.invokeMethod("algo","erro");

      }
    });
  }

  @Override
  public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {

  }
}
