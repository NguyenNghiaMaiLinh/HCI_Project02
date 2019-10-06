package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BookingRejectedListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_rejected_list_store);

    }


    public void onClickToBookingRejectedDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingRejectedDetailsActivity.class);
        startActivity(intent);

    }
}
