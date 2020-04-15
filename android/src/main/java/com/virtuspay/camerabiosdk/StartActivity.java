package com.virtuspay.camerabiosdk;
import com.example.camerabioandroid.camerabiomanager.CallbackCameraBio;
import com.example.camerabioandroid.camerabiomanager.CameraBioManager;
import androidx.annotation.Nullable;
import android.app.Activity;
import android.os.Bundle;

public class StartActivity extends Activity implements CallbackCameraBio {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    CameraBioManager cb = new CameraBioManager(this);
    cb.startCamera();
  }

  @Override
  public void onSuccessCapture(String base64) {

  }

  @Override
  public void onSuccessCaptureDocument(String base64) {

  }

  @Override
  public void onFailedCapture(String description) {

  }
}
