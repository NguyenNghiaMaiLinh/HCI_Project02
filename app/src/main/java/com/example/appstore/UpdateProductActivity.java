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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class UpdateProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView selectImage;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView close1;
    ImageView close2;
    ImageView close3;
    ImageView imageView;
    private int REQUEST_CODE = 1;
    RadioGroup radioGroup;
    RadioButton radioButton;
    boolean image1 = false;
    boolean image2= false;
    boolean image3= true;
    int count = 0;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarId11232);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Store.class));
            }
        });

        Spinner spinner = findViewById(R.id.spinner112);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category6, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        close1 = findViewById(R.id.close0111);
        close2 = findViewById(R.id.close0121);
        close3 = findViewById(R.id.close0131);
        close3.setVisibility(View.INVISIBLE);
        selectImage = findViewById(R.id.selectImage001);
        textView = findViewById(R.id.txt_quantity3);
        imageView1 = (ImageView) findViewById(R.id.imageSP0111);
        imageView2 = (ImageView) findViewById(R.id.imageSP0121);
        imageView3 = (ImageView) findViewById(R.id.imageSP0131);
        imageView3.setVisibility(View.INVISIBLE);
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
        if( image1){
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView1.setImageBitmap(bitmap);
                    textView.setText("1/3");
                    close1.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.VISIBLE);
                    image1 = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if(image2){
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView2.setImageBitmap(bitmap);
                    textView.setText("2/3");
                    close2.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    image2 =false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if(image3){
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView3.setImageBitmap(bitmap);
                    textView.setText("2/3");
                    close3.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.VISIBLE);
                    image3 =false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        if (count == 0) {
//            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//                Uri uri = data.getData();
//                try {
//                    count++;
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                    imageView2.setImageBitmap(bitmap);
//                    textView.setText("2/3");
//                    close2.setVisibility(View.VISIBLE);
//                    imageView2.setVisibility(View.VISIBLE);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } else if (count == 1) {
//            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//                Uri uri = data.getData();
//                try {
//                    count++;
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                    imageView3.setImageBitmap(bitmap);
//                    textView.setText("2/3");
//                    close3.setVisibility(View.VISIBLE);
//                    imageView3.setVisibility(View.VISIBLE);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } else if (count == 2) {
//            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//                Uri uri = data.getData();
//                try {
//                    count++;
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                    imageView1.setImageBitmap(bitmap);
//                    close1.setVisibility(View.VISIBLE);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
////        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void close2(View view) {
        imageView2.setImageResource(R.drawable.ic_image_black_24dp);
        close2.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        textView.setText("1/3");
        image2= true;
    }
    public void close1(View view) {
        imageView1.setImageResource(R.drawable.ic_image_black_24dp);
        close1.setVisibility(View.INVISIBLE);
        imageView1.setVisibility(View.INVISIBLE);
        textView.setText("0/3");
        image1= true;
    }
    public void close3(View view) {
        imageView3.setImageResource(R.drawable.ic_image_black_24dp);
        close3.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        textView.setText("2/3");
        image3= true;
    }
    public void clickSave(View view) {
        Intent intent = new Intent(getApplicationContext(), Store.class);
        Toast.makeText(UpdateProductActivity.this, "Thay đổi thông tin thành công !", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

}
