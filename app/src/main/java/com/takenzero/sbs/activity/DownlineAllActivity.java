package com.takenzero.sbs.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.takenzero.sbs.R;
import com.takenzero.sbs.adapter.AdapterDownline;
import com.takenzero.sbs.model.DownlineDetail;
import com.takenzero.sbs.model.DownlineResp;
import com.takenzero.sbs.model.Header;
import com.takenzero.sbs.rest.ApiClient;
import com.takenzero.sbs.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownlineAllActivity extends AppCompatActivity {
    Header h = new Header();
    private String CLIENT_SERVICE = h.getClientService();
    private String AUTH_KEY = h.getAuthKey();

    ApiInterface apiService;
    SharedPreferences pref;

    private RecyclerView recyclerView;
    private AdapterDownline mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downline_all);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        initToolbar();
        getDownline();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Downline");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void getDownline(){
        pref = getSharedPreferences("SBS", Context.MODE_PRIVATE);
//        Toast.makeText(DownlineAllActivity.this, pref.getString("Authorization","No Auth")+" -> "+pref.getString("ID_USER","NO USER"), Toast.LENGTH_LONG).show();
        Call<DownlineResp> call = apiService.getDownline(CLIENT_SERVICE, AUTH_KEY, pref.getString("Authorization","No Auth"),pref.getString("ID_USER","NO USER"));
        call.enqueue(new Callback<DownlineResp>() {
            @Override
            public void onResponse(Call<DownlineResp> call, Response<DownlineResp> response) {
                if (response.isSuccessful()) switch (response.code()) {
                    case 200:
                        List<DownlineDetail> downlineList = response.body().getDownline();
                        initDownline(downlineList);
                        Log.d(DownlineAllActivity.class.getSimpleName(), "Number of downline received: " + downlineList.size());
                        break;
                    default:
                        Toast.makeText(DownlineAllActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                        break;
                }

//                Toast.makeText(DownlineAllActivity.this, CLIENT_SERVICE+" -> "+pref.getString("ID_USER","NO USER"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DownlineResp> call, Throwable t) {
                Toast.makeText(DownlineAllActivity.this, "FAILED -> "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initDownline(List<DownlineDetail> downlineList){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
