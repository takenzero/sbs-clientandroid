package com.takenzero.sbs.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.takenzero.sbs.R;
import com.takenzero.sbs.adapter.DashboardAdapter;
import com.takenzero.sbs.data.DataGenerator;
import com.takenzero.sbs.model.DashboardCategory;
import com.takenzero.sbs.session.Session;
import com.takenzero.sbs.util.Tools;
import com.takenzero.sbs.widget.SpacingItemDecoration;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DashboardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        session = new Session(this);
//        Snackbar.make(parent_view, "ID User from Session: "+session.getIdUser(), Snackbar.LENGTH_SHORT).show();
        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Saffanah Bersama Sukses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 8), true));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        List<DashboardCategory> items = DataGenerator.getDashboardCategory(this);

        mAdapter = new DashboardAdapter(this, items);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new DashboardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, DashboardCategory obj, int position) {
                switch (position){
                    case 5:
                        showConfirmationExit();
                        break;
                    case 1:
                        goToDownline();
                        break;
                    case 0:
                        goToProfile();
                        break;
                    default:
                        Toast.makeText(DashboardActivity.this, "Item: " + obj.title + " Position: " + position + " clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void showConfirmationExit() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirmation_exitapp);

        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        ((AppCompatButton) dialog.findViewById(R.id.bt_close_no)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ((AppCompatButton) dialog.findViewById(R.id.bt_close_yes)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    private void goToProfile(){
        Intent i = new Intent(DashboardActivity.this, ProfileActivity.class);
        startActivity(i);
    }

    private void goToDownline(){
        Intent i = new Intent(DashboardActivity.this, DownlineAllActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        showConfirmationExit();
    }
}