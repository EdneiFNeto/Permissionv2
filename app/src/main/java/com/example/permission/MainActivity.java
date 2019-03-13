package com.example.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int myVersion = Build.VERSION.SDK_INT;
        String process_out_calls = Manifest.permission.PROCESS_OUTGOING_CALLS;
        int code = 1;


        if (myVersion > Build.VERSION_CODES.M || myVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (checkPermission(process_out_calls)) {
                requestForPermission(process_out_calls, code);
            }
        }
    }

    public boolean checkPermission(String manifestPermission) {

        int result = ContextCompat.checkSelfPermission(this, manifestPermission);
        return result == PackageManager.PERMISSION_DENIED ? true : false;

    }

    public void requestForPermission(String permissions, int code) {
        ActivityCompat.requestPermissions(this, new String[]{permissions}, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Log.e(TAG, "NOT PERMISSION_DENIED");
                } else {
                    Log.e(TAG, "NOT PERMISSION_DENIED");
                }

                break;

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
