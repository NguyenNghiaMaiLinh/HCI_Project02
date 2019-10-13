package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CreatePhanBonActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button selectImage;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView close1;
    ImageView close2;
    ImageView close3;

    private int REQUEST_CODE = 1;
    RadioGroup radioGroup;
    int count = 0;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_phan_bon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarIdCreate11);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DashboardStoreActivity.class));
            }
        });


        Spinner spinner = findViewById(R.id.spinnerphanbon1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category4, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        close1 = findViewById(R.id.close11);
        close1.setVisibility(View.INVISIBLE);
        close2 = findViewById(R.id.close12);
        close2.setVisibility(View.INVISIBLE);
        close3 = findViewById(R.id.close13);
        close3.setVisibility(View.INVISIBLE);
        selectImage = findViewById(R.id.selectImage012);
        imageView1 = (ImageView) findViewById(R.id.imageSP11);
        imageView2 = (ImageView) findViewById(R.id.imageSP12);
        imageView3 = (ImageView) findViewById(R.id.imageSP13);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (count == 0) {
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView1.setImageBitmap(bitmap);
                    close1.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (count == 1) {
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView2.setImageBitmap(bitmap);

                    close2.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (count == 2) {
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView3.setImageBitmap(bitmap);
                    close3.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void them(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardStoreActivity.class);
        startActivity(intent);
    }
}
