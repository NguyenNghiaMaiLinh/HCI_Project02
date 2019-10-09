package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioButton radioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarId11);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardStoreActivity.class));
            }
        });

        radioGroup = findViewById(R.id.groupb);

    }

    public void rbclick(View view) {
        int rdbtID = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(rdbtID);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void clickToChangePassword(View view) {
        Intent intent = new Intent(getApplicationContext(), ChangePassword.class);
        startActivity(intent);
    }

    public void clickToDangXuat(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void clickToThemTheNganHang(View view) {
        Intent intent = new Intent(getApplicationContext(), TheNganHangActivity.class);
        startActivity(intent);
    }
}
