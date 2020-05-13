package com.example.imeisendingtest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView imei_number;
    Button get_imei;
    String IMEI_Number_Holder;
    TelephonyManager telephonyManager;
    private  static final int PHONE_STATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imei_number = findViewById(R.id.textView1);
        get_imei = findViewById(R.id.button1);
        checkPhoneStata();

        telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);

        get_imei.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                IMEI_Number_Holder = telephonyManager.getDeviceId();
                imei_number.setText(IMEI_Number_Holder);
            }
        });
    }

    private void checkPhoneStata() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE}, PHONE_STATE);

            return;
        }
    }

}
