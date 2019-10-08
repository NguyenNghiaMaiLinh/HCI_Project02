package com.example.appstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class BookingFinishedDetailsActivity extends AppCompatActivity {
    EditText editTextCustomerComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_finished_details_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarBookingFinishedDetails);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BookingFinishedListActivity.class));
            }
        });

        editTextCustomerComment = findViewById(R.id.editTextCustomerComment);
        editTextCustomerComment.setText("   Dịch vụ tốt, nhân viên thân thiện, vui vẻ. ");
        editTextCustomerComment.setPadding(130, 0, 130, 0);

    }

    public void onClickCancel(View view) {
        Intent intent = new Intent(this, DashboardStoreActivity.class);
        startActivity(intent);
    }

    public void onClickHomePage(View view) {
        Intent intent = new Intent(this, DashboardStoreActivity.class);
        startActivity(intent);
    }

}
