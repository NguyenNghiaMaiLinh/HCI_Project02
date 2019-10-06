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

public class DashboardStoreActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

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
    public void onHomeChat(View view){
        Intent intent = new Intent(getApplicationContext(), HomeChatActivity.class);
        startActivity(intent);
    }

    public void clickToBookingFinishedList(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingFinishedListActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
