package com.example.appstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
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

public class UpdateServiceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
    boolean image2 = true;
    boolean image3 = true;
    int count = 0;
    TextView textView;

    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_service);

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

        Spinner spinner = findViewById(R.id.spinner1121);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category31, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        close1 = findViewById(R.id.close01111);
        textView = findViewById(R.id.txt_quantity4);
        close2 = findViewById(R.id.close01211);
        close2.setVisibility(View.INVISIBLE);
        close3 = findViewById(R.id.close01311);
        close3.setVisibility(View.INVISIBLE);
        selectImage = findViewById(R.id.selectImage0011);
        imageView1 = (ImageView) findViewById(R.id.imageSP01111);
        imageView2 = (ImageView) findViewById(R.id.imageSP01211);
        imageView3 = (ImageView) findViewById(R.id.imageSP01311);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
//        selectImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
//            }
//        });
    }

    protected Dialog onCreateDialog() {
        return new AlertDialog.Builder(this)
                .setView(R.layout.method_camera_dialog)
                .show();
    }

    public void openMethodCamera1(View view) {
        onCreateDialog();

    }

    public void onThuvien(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
    }

    public void onCamera(View view) {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
        } else {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (image1) {
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView1.setImageBitmap(bitmap);
                    textView.setText("1/3");
                    imageView1.setVisibility(View.VISIBLE);
                    close1.setVisibility(View.VISIBLE);
                    image1 = false;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView1.setImageBitmap(photo);
                textView.setText("1/3");
                close1.setVisibility(View.VISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                image1 = false;
            }
        } else if (image2) {
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView2.setImageBitmap(bitmap);
                    textView.setText("2/3");
                    imageView2.setVisibility(View.VISIBLE);
                    close2.setVisibility(View.VISIBLE);
                    image2 = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView2.setImageBitmap(photo);
                textView.setText("2/3");
                imageView2.setVisibility(View.VISIBLE);
                close2.setVisibility(View.VISIBLE);
                image2 = false;
            }
        } else if (image3) {
            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri uri = data.getData();
                try {
                    count++;
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    imageView3.setImageBitmap(bitmap);
                    textView.setText("3/3");
                    imageView3.setVisibility(View.VISIBLE);
                    close3.setVisibility(View.VISIBLE);
                    image3 = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageView3.setImageBitmap(photo);
                textView.setText("3/3");
                imageView3.setVisibility(View.VISIBLE);
                close3.setVisibility(View.VISIBLE);
                image3 = true;
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
//                    imageView2.setVisibility(View.VISIBLE);
//                    close2.setVisibility(View.VISIBLE);
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
//                    textView.setText("3/3");
//                    imageView3.setVisibility(View.VISIBLE);
//                    close3.setVisibility(View.VISIBLE);
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
//        }
        // }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void close1112(View view) {
        imageView2.setImageResource(R.drawable.ic_image_black_24dp);
        close2.setVisibility(View.INVISIBLE);
        textView.setText("1/3");
        imageView2.setVisibility(View.INVISIBLE);
        image2 = true;
    }

    public void close1111(View view) {
        imageView1.setImageResource(R.drawable.ic_image_black_24dp);
        close1.setVisibility(View.INVISIBLE);
        textView.setText("0/3");
        imageView1.setVisibility(View.INVISIBLE);
        image1 = true;
    }

    public void close1113(View view) {
        imageView3.setImageResource(R.drawable.ic_image_black_24dp);
        close3.setVisibility(View.INVISIBLE);
        textView.setText("2/3");
        imageView3.setVisibility(View.INVISIBLE);
        image3 = true;
    }

    public void clickSave2(View view) {
        Intent intent = new Intent(UpdateServiceActivity.this, Store.class);
        Toast.makeText(UpdateServiceActivity.this, "Thay đổi thông tin thành công !", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
