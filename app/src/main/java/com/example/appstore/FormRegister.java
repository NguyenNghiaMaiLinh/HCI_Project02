package com.example.appstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormRegister extends AppCompatActivity {
    EditText ten;
    EditText ten1;
    EditText dienthoai;
    EditText email1;
    Button button;
    Spinner spinner1;
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
         spinner1 = (Spinner) findViewById(R.id.spinner1);
         button = findViewById(R.id.btnSubmit);
         ten = (EditText) findViewById(R.id.ten);
         ten1 = (EditText) findViewById(R.id.ten1);
         dienthoai = (EditText) findViewById(R.id.dienthoai);
         email1 = (EditText) findViewById(R.id.email);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(FormRegister.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

         spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(FormRegister.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.danhnghieps));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
    }

    public void onSubmit1(View view) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (ten.getText().toString().isEmpty() ) {
           ten.setError("Tên doanh nghiêp đang rỗng");

        } else if (ten1.getText().toString().isEmpty()) {
            ten1.setError("Người đại diện đang rỗng");
        } else if (dienthoai.getText().toString().isEmpty()) {
            dienthoai.setError("Số điện thoại đang rỗng");
        } else if (email1.getText().toString().isEmpty()) {
            email1.setError("Email không đang rỗng");
        } else if (!email1.getText().toString().matches(emailPattern)) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_LONG).show();
//        } else if (!spinner1.callOnClick()) {
//            Toast.makeText(this, "Thành phố chưa được chọn", Toast.LENGTH_LONG).show();
//        } else if (!spinner2.callOnClick()) {
//            Toast.makeText(this, "Loại hình doanh nghiệp chưa được chọn", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
