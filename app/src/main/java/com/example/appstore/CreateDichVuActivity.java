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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateDichVuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView selectImage;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView close1;
    ImageView close2;
    ImageView close3;
TextView textView;
    private int REQUEST_CODE = 1;
    RadioGroup radioGroup;
    int count = 0;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dich_vu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarIdCreate12);
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


        Spinner spinner = findViewById(R.id.spinnerDichVu1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        close1 = findViewById(R.id.close1);
        close1.setVisibility(View.INVISIBLE);
        close2 = findViewById(R.id.close2);
        close2.setVisibility(View.INVISIBLE);
        close3 = findViewById(R.id.close3);
        close3.setVisibility(View.INVISIBLE);
        selectImage = findViewById(R.id.selectImage12);
        imageView1 = (ImageView) findViewById(R.id.imageSP1);
        imageView1.setVisibility(View.INVISIBLE);
        imageView2 = (ImageView) findViewById(R.id.imageSP2);
        imageView3 = (ImageView) findViewById(R.id.imageSP3);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        textView =findViewById(R.id.txt_quantity1);
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
                    imageView1.setVisibility(View.VISIBLE);
                    textView.setText("1/3");
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
                    textView.setText("2/3");
                    close2.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
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
                    textView.setText("3/3");
                    close3.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.VISIBLE);
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

    public void close112(View view) {
        imageView2.setImageResource(R.drawable.ic_image_black_24dp);
        close2.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        textView.setText("1/3");
    }

    public void close111(View view) {
        imageView1.setImageResource(R.drawable.ic_image_black_24dp);
        close1.setVisibility(View.INVISIBLE);
        imageView1.setVisibility(View.INVISIBLE);
        textView.setText("0/3");
    }

    public void close113(View view) {
        imageView3.setImageResource(R.drawable.ic_image_black_24dp);
        close3.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        textView.setText("2/3");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void them1(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardStoreActivity.class);
        startActivity(intent);
    }


}
