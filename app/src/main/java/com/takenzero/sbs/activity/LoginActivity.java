package com.takenzero.sbs.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.takenzero.sbs.R;
import com.takenzero.sbs.model.Header;
import com.takenzero.sbs.model.LoginReq;
import com.takenzero.sbs.model.LoginResp;
import com.takenzero.sbs.rest.ApiClient;
import com.takenzero.sbs.rest.ApiInterface;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Header h = new Header();
    private String CLIENT_SERVICE = h.getClientService();
    private String AUTH_KEY = h.getAuthKey();
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
            showAlertDialog("EmptyIDPassword");
        }
    }

    protected void doLogin(String idUser, String password){
        pDialog.setMessage("Sedang login ..");
        showDialog();

        Call<LoginResp> call = apiService.postLogin(CLIENT_SERVICE,AUTH_KEY,new LoginReq(idUser,password));
        call.enqueue(new Callback<LoginResp>() {
            @Override
            public void onResponse(Call<LoginResp>call, Response<LoginResp> response) {
                if (response.isSuccessful()){
                    switch (response.code()){
                        case 200:
//                            Toast.makeText(getApplicationContext(),response.body().getTokenCode(), Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                            finish();
                            break;
                        default:
                            showAlertDialog("Alert204");
                            break;
                    }
                }else{
                    showAlertDialog("AlertDefault");
                }
            }

            @Override
            public void onFailure(Call<LoginResp>call, Throwable t) {
                showAlertDialog("AlertDefault");
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

    private void showAlertDialog(String type) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_alert_defaultfailur);

        if (type.equals("EmptyIDPassword")) {
            dialog.setContentView(R.layout.dialog_alert_emptyuserpassword);
        }
        if (type.equals("Alert204")) {
            dialog.setContentView(R.layout.dialog_alert_wronguserpassword);
        }
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*edtIdUser.setText("");
                edtPassword.setText("");*/
                edtIdUser.requestFocus();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

}