package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookingProcessingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_processing_list_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarBookingProcessingList);
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


    public void onClickToBookingDetails(View view) {
        Intent intent = new Intent(getApplicationContext(), BookingProcessingDetailsActivity.class);
        startActivity(intent);

    }
}
