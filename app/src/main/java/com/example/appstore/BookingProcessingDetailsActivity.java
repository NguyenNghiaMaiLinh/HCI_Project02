package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookingProcessingDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_processing_details_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarBookingProcessingDetails);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BookingProcessingListActivity.class));
            }
        });
    }

    public void onClickCancel(View view) {

        RejectBookingReasonDialog cdd=new RejectBookingReasonDialog(BookingProcessingDetailsActivity.this);
        cdd.show();
    }


    public void clickToHomeFromDetailsPage(View view) {

        Intent intent = new Intent(this, DashboardStoreActivity.class);
                startActivity(intent);
    }

    public void onClickDone(View view) {

        Intent intent = new Intent(this, BookingFinishedListActivity.class);
        startActivity(intent);
    }


}
