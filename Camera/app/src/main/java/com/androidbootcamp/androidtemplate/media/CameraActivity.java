package com.androidbootcamp.androidtemplate.media;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidbootcamp.androidtemplate.R;
import com.androidbootcamp.androidtemplate.fragments.OnCamerActionListener;


public class CameraActivity extends AppCompatActivity implements OnCamerActionListener {

    private final  int REQUEST_CAMERA= 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    public void sendPhoto(String path) {
        Bundle bundle= new Bundle();
        bundle.putString("PATH",path);
        Intent intent= new Intent();
        intent.putExtras(bundle);

        setResult(REQUEST_CAMERA,intent);
        finish();
    }
}
