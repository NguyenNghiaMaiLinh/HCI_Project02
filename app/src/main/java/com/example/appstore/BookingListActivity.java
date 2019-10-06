package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list_store);

    }


    public void onClickToBookingDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingDetailsActivity.class);
        startActivity(intent);

    }
}
