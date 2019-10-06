package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class DashboardStoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_store);
    }

    public void clickToCreateProduct(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateProductActivity.class);
        startActivity(intent);
    }

    public void clickToBookingList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingListActivity.class);
        startActivity(intent);
    }
}
