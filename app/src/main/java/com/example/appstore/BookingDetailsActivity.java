package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appstore.DashboardStoreActivity;

public class BookingDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details_store);

    }

    public void onClickCancel(View view) {
        Intent intent = new Intent(this, DashboardStoreActivity.class);
        startActivity(intent);
    }

    public void onClickHomePage(View view) {
        Intent intent = new Intent(this, DashboardStoreActivity.class);
        startActivity(intent);
    }

}
