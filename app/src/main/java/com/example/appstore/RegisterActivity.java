package com.example.appstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;

public class RegisterActivity extends AppCompatActivity {
    private EditText userEmail;
    private EditText userPass;
    private EditText userPassConfirm;
    private EditText userName;
    private RadioButton check;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userEmail = (EditText) findViewById(R.id.userEmai3);
        userPass = (EditText) findViewById(R.id.userPassword3);
        userPassConfirm = (EditText) findViewById(R.id.userConfirm3);
        userName = (EditText) findViewById(R.id.userName3);
        check = (RadioButton) findViewById(R.id.radioButton3);
        btnRegister = findViewById(R.id.btnRegister);
    }
    public  void onExit(View view){
        finish();
        moveTaskToBack(true);
    }
    public void onCLickDoneInput(View view) {
        finish();
        moveTaskToBack(true);
    }
    public  void onClickHomePage(View view){
        String email = userEmail.getText().toString().trim();
        String pass = userPass.getText().toString().trim();
        String username = userName.getText().toString().trim();
        String passConfirm = userPassConfirm.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (TextUtils.isEmpty(email) ) {
            Toast.makeText(this, "Email không được trống", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Mật khẩu không được để trống", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Tài khoản không được để trống", Toast.LENGTH_LONG).show();
        } else if (!email.matches(emailPattern)) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_LONG).show();
        } else if (!passConfirm.equals(pass)) {
            Toast.makeText(this, "Mật khẩu không giống nhau", Toast.LENGTH_LONG).show();
        } else if (pass.length() < 6) {
            Toast.makeText(this, "Mật khẩu phải lớn hơn 6 ký tự", Toast.LENGTH_LONG).show();
        } else if (!check.isChecked()) {
            Toast.makeText(this, "Bạn phải chấp nhận điều khoản của chúng tôi", Toast.LENGTH_LONG).show();
        } else {
            final KProgressHUD kProgressHUD = KProgressHUDManager.showProgessBar(RegisterActivity.this, "Thành công");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    kProgressHUD.dismiss();
                    onOpenDialog();
                }
            }, 1000);// = 1 seconds
        }
    }
    protected Dialog onCreateDialog() {
        return new AlertDialog.Builder(this)
                .setView(R.layout.activity_dialog)
                .show();
    }
    protected Dialog onOpenDialog() {
        return new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_location)
                .setTitle("Cho phép Nhà Vườn truy cập cị trí của thiết bị này?")
                .setPositiveButton("Cho phép",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                onCreateDialog();
                            }
                        })
                .setNegativeButton("Từ chối",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                onCreateDialog();
                            }
                        })
                .show();
    }
}
