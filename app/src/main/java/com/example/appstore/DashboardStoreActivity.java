package com.example.appstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.google.android.material.navigation.NavigationView;

public class DashboardStoreActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_store);
    }

    public void clickToCreateProduct(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateProductActivity.class);
        startActivity(intent);
    }

    public void clickToVi(View view) {
        Intent intent = new Intent(getApplicationContext(), ViActivity.class);
        startActivity(intent);
    }

    public void clickToBookingList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingListActivity.class);
        startActivity(intent);
    }

    public void onHomeChat1(View view) {
        Intent intent = new Intent(this, HomeChatActivity.class);
        startActivity(intent);
    }

    public void clickToBookingFinishedList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingFinishedListActivity.class);
        startActivity(intent);
    }
    public void clickToBookingRejectedList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingRejectedListActivity.class);
        startActivity(intent);
    }
    public void clickToBookingProcessingList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingProcessingListActivity.class);
        startActivity(intent);
    }
    public void onLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void clickToDoanhThu(View view) {
        Intent intent = new Intent(getApplicationContext(), DoanhThuActivity.class);
        startActivity(intent);
    }

    public void clickToLichSuBanHang(View view) {
        Intent intent = new Intent(getApplicationContext(), LichSuBanHangActivity.class);
        startActivity(intent);
    }
}
