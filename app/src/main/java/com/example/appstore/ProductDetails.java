package com.example.appstore;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.appstore.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ProductDetails extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        TextView oldPrice = findViewById(R.id.oldPrice);
        oldPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar432);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Store.class));
//            }
//        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ProductDescription(), "Mô tả");
        viewPagerAdapter.addFragment(new ProductInfo(), "Chi tiết");
        viewPagerAdapter.addFragment(new ProductFeedback(), "Đánh giá");
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
    public void onClickChoose(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Sản phẩm đã được thêm vào giỏ hàng", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickViewCart(View view) {
        Intent intent = new Intent(getApplicationContext(), UpdateProductActivity.class);
        startActivity(intent);
    }
}
