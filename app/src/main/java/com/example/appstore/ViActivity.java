package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi);
    }

    public void clickToRutTien(View view) {
        Intent intent = new Intent(getApplicationContext(), RutTienActivity.class);
        startActivity(intent);
    }

    public void clickToLichSuGiaoDich(View view) {
        Intent intent = new Intent(getApplicationContext(), LichSuGiaoDichActivity.class);
        startActivity(intent);
    }
}
