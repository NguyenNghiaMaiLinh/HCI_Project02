package com.example.appstore;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.appstore.utils.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Store extends AppCompatActivity {

    private TabLayout tabStore;
    private ViewPager viewStore;
    BottomNavigationView bottomNavigationView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_store);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewStore = findViewById(R.id.viewStore);
        setupViewPager(viewStore);

        tabStore = findViewById(R.id.tabStore);
        tabStore.setupWithViewPager(viewStore);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new StoreProduct(), "Cây cảnh");
        viewPagerAdapter.addFragment(new StoreService(), "Dịch vụ");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected Dialog onCreateDialog() {
        return new AlertDialog.Builder(this)
                .setView(R.layout.form_create_category_dialog)
                .show();
    }
    public void clickToFromCreate(View view) {
        onCreateDialog();
    }
    public void clickToCreateProduct(View view) {
        startActivity(new Intent(getApplicationContext(), CreateProductActivity.class));
    }
//    public void clickMap(View view) {
//        startActivity(new Intent(getApplicationContext(), Map.class));
//    }
    public void clickToCreateDichvu(View view) {
        startActivity(new Intent(getApplicationContext(), CreateDichVuActivity.class));
    }
}
