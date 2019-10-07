package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarId11);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardStoreActivity.class));
            }
        });
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
