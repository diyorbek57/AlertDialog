package com.ayizor.alertdialog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.showAlertDialog(this, "Hello", "ssss", action -> {
            if (action) {
                Utils.fireToast(getApplicationContext(), "ok");
            } else {
                Utils.fireToast(getApplicationContext(), "Cencel");
            }
        });
    }


}