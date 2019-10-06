package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BookingFinishedListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_finished_list_store);

    }


    public void onClickToBookingFinishedDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingFinishedDetailsActivity.class);
        startActivity(intent);

    }
}
