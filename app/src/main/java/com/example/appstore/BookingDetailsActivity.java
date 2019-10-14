package com.example.appstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appstore.DashboardStoreActivity;
import android.app.Dialog;

public class BookingDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarBookingDetails);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BookingListActivity.class));
            }
        });
    }

    public void onClickCancel(View view) {

        CancelBookingReasonDialog cdd=new CancelBookingReasonDialog(BookingDetailsActivity.this);
        cdd.show();
    }

    public void onClickHomePage(View view) {
        Intent intent = new Intent(this, DashboardStoreActivity.class);
        Toast.makeText(BookingDetailsActivity.this, "Đã nhận lịch !", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    public void clickToHomeFromDetailsPage(View view) {

        Intent intent = new Intent(this, DashboardStoreActivity.class);
        startActivity(intent);
    }

}
