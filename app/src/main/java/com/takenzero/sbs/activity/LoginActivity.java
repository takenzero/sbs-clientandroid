package com.takenzero.sbs.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.takenzero.sbs.R;
import com.takenzero.sbs.model.LoginReq;
import com.takenzero.sbs.model.LoginResp;
import com.takenzero.sbs.rest.ApiClient;
import com.takenzero.sbs.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edtIdUser;
    EditText edtPassword;
    MaterialRippleLayout btnLogin;
    ApiInterface apiService;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtIdUser = (EditText) findViewById(R.id.login_id_user);
        edtPassword = (EditText) findViewById(R.id.login_password);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        btnLogin = (MaterialRippleLayout) findViewById(R.id.login_btnSignIn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idUser = edtIdUser.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                checkUserPassword(idUser, password);
            }
        });

    }

    protected void checkUserPassword(String idUser, String password){
        if ((idUser.length() > 0) && (password.length() > 0)){
            doLogin(idUser, password);
        }else{
            Toast.makeText(getApplicationContext(),"Username dan Password tidak boleh kosong", Toast.LENGTH_LONG).show();
        }
    }

    protected void doLogin(String idUser, String password){
        pDialog.setMessage("Sedang login ..");
        showDialog();

        Call<LoginResp> call = apiService.postLogin("frontend-client","b277d4b4311ff79f65a20929bfba09d5",new LoginReq(idUser,password));
        call.enqueue(new Callback<LoginResp>() {
            @Override
            public void onResponse(Call<LoginResp>call, Response<LoginResp> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),response.body().getTokenCode(), Toast.LENGTH_LONG).show();
                }else{
                    switch (response.code()){
                        /*case 404:
                            default:*/
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResp>call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        hideDialog();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}