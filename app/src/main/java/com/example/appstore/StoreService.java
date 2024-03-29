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

public class StoreService extends Fragment implements View.OnClickListener {
    TextView editIcon;
    TextView deleteIcon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_store_service, null, false);
//        CardView cardView = root.findViewById(R.id.storeServiceItem);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getContext(), BookingService.class));
//            }
//        });
        CardView cardView = root.findViewById(R.id.storeServiceItem1);
        editIcon = root.findViewById(R.id.editIcon);
        deleteIcon = root.findViewById(R.id.deleteIcon);
        editIcon.setOnClickListener(this);
        deleteIcon.setOnClickListener(this);
        cardView.setOnClickListener(this);

        Intent intent = getActivity().getIntent();
        if (Boolean.parseBoolean(intent.getStringExtra("isDel")) == true){
            cardView.setVisibility(View.GONE);
        }
        return root;
    }

    protected Dialog onCreateDialog() {
        return new AlertDialog.Builder(getContext())
                .setIcon(R.drawable.ic_question_green_24dp)
                .setTitle("Bạn có chắc muốn xoá dịch vụ này chứ?")
                .setPositiveButton("Xác nhận",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getContext(), Store.class);
                                intent.putExtra("isDel", "true");
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Quay lại",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StoreService.this.startActivity(new Intent(getContext(), Store.class));
                            }
                        })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editIcon:
                startActivity(new Intent(getContext(), UpdateServiceActivity.class));
                break;

            case R.id.deleteIcon:
                onCreateDialog();
                break;
            case R.id.storeServiceItem1:
                startActivity(new Intent(getContext(), ServicesDetailsActivity.class));
                break;

        }
    }


}