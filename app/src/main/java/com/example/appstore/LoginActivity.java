package com.example.appstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPass;
    private ProgressDialog progress;
    private static int REGISTER_ACTIVITY = 1;
    private static String ADMIN = "admin";
    private static String PASS = "admin123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userEmail = findViewById(R.id.userName1);
        userPass = findViewById(R.id.userPassword1);
    }
    public void onClickHomePage(View view) {
        String email = userEmail.getText().toString().trim();
        String pass = userPass.getText().toString().trim();
        if (TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(pass).matches()) {
            Toast.makeText(LoginActivity.this, "Tên đăng nhập không được trống", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(LoginActivity.this, "Mật khẩu không được trống", Toast.LENGTH_LONG).show();
        } else if (pass.length() < 6) {
            Toast.makeText(LoginActivity.this, "Mật khẩu phải lớn hơn 6 ký tự", Toast.LENGTH_LONG).show();
        } else if (email.equalsIgnoreCase(ADMIN) && pass.equalsIgnoreCase(PASS)) {
            final KProgressHUD kProgressHUD = KProgressHUDManager.showProgessBar(LoginActivity.this, "Thành công");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onCreateDialog();
                    kProgressHUD.dismiss();

                    // Toast.makeText(Login_Form.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                }
            }, 1000);// = 1 seconds

        } else {
            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_LONG).show();
        }
    }

    protected Dialog onCreateDialog() {
        return new AlertDialog.Builder(this)
                .setView(R.layout.activity_dialog)
                .show();
    }
    public  void onRegister(View view ){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, REGISTER_ACTIVITY);
    }

    public  void onGoogle(View view ){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, REGISTER_ACTIVITY);
    }
    public  void onDangky(View view ){
        Intent intent = new Intent(this, FormRegister.class);
        startActivityForResult(intent, REGISTER_ACTIVITY);
    }
    public void onLienHe(View view){
        Uri uri = Uri.parse("tel:1900 5656");
        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
        //Intent intent1 = new Intent(Intent.ACTION_DIAL, uri);
        // Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent1);
    }
}
