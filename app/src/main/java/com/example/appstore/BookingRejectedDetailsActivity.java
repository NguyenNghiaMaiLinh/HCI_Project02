package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class BookingRejectedDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_rejected_details_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarBookingRejectedDetails);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BookingRejectedListActivity.class));
            }
        });
    }

    public void clickToHomeFromDetailsPage(View view) {

        Intent intent = new Intent(this, DashboardStoreActivity.class);
        startActivity(intent);
    }



}
