package com.example.appstore;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class StoreProduct extends Fragment implements View.OnClickListener {

    TextView editIcon;
    TextView deleteIcon;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_store_product, null, false);
        CardView cardView = root.findViewById(R.id.storeServiceItem);

        editIcon = root.findViewById(R.id.editIcon);
        deleteIcon = root.findViewById(R.id.deleteIcon);
        editIcon.setOnClickListener(this);
        deleteIcon.setOnClickListener(this);
        cardView.setOnClickListener(this);
        return root;
    }
    protected Dialog onCreateDialog(View v) {
CardView cardView = v.findViewById(R.id.storeServiceItem);
        return new AlertDialog.Builder(getContext())
                .setIcon(R.drawable.ic_question_green_24dp)
                .setTitle("Bạn có chắc muốn xoá sản phẩm này chứ?")
                .setPositiveButton("Xác nhận",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StoreProduct.this.startActivity(new Intent(getContext(), Store.class));
                            }
                        })
                .setNegativeButton("Quay lại",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StoreProduct.this.startActivity(new Intent(getContext(), Store.class));
                            }
                        })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editIcon:
                startActivity(new Intent(getContext(), UpdateProductActivity.class));
                break;

            case R.id.deleteIcon:
                System.out.println(onCreateDialog(v));
                break;
            case R.id.storeServiceItem:
                startActivity(new Intent(getContext(), ProductDetails.class));
                break;
        }
    }
}