package com.takenzero.sbs.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.takenzero.sbs.R;
import com.takenzero.sbs.model.Header;
import com.takenzero.sbs.model.UserDetailResp;
import com.takenzero.sbs.rest.ApiClient;
import com.takenzero.sbs.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity{
    Header h = new Header();
    private String CLIENT_SERVICE = h.getClientService();
    private String AUTH_KEY = h.getAuthKey();

    ApiInterface apiService;
    SharedPreferences pref;

    NestedScrollView viewContent;
    RelativeLayout viewProgress;

    TextView tvIdUser;
    TextView tvBalance;
    TextView tvTotalDownline;
    TextView tvDownlineLeft;
    TextView tvDownlineRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        viewContent = (NestedScrollView) findViewById(R.id.nested_content);
        viewProgress = (RelativeLayout) findViewById(R.id.view_progress);

        tvIdUser = (TextView)findViewById(R.id.profile_id);
        tvBalance = (TextView) findViewById(R.id.profie_saldo);
        tvTotalDownline = (TextView) findViewById(R.id.profile_tdownline);
        tvDownlineLeft = (TextView) findViewById(R.id.profile_tleft);
        tvDownlineRight = (TextView) findViewById(R.id.profile_tright);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        initToolbar();
        initUserData();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initUserData(){
        showProgress();

        pref = getSharedPreferences("SBS", Context.MODE_PRIVATE);

        Call<UserDetailResp> call = apiService.getUserDetail(CLIENT_SERVICE, AUTH_KEY, pref.getString("Authorization","No Auth"),pref.getString("ID_USER","NO USER"));
        call.enqueue(new Callback<UserDetailResp>() {
            @Override
            public void onResponse(Call<UserDetailResp> call, Response<UserDetailResp> response) {
                if (response.isSuccessful()) switch (response.code()) {
                    case 200:
                        setUserDetail(response.body());
                        break;
                    default:
                        Toast.makeText(ProfileActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<UserDetailResp> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "FAILED -> "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setUserDetail(UserDetailResp resp){
        tvIdUser.setText(resp.getIdUser());
        tvBalance.setText(resp.getActualBalance());
        tvTotalDownline.setText(resp.getTotalDownline());
        tvDownlineLeft.setText(resp.getCountLeft());
        tvDownlineRight.setText(resp.getCountRight());

        hideProgress();
    }

    public void showProgress(){
        viewContent.setVisibility(View.GONE);
        viewProgress.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        viewContent.setVisibility(View.VISIBLE);
        viewProgress.setVisibility(View.GONE);
    }
}
