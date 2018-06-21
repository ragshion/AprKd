package online.aprkd_pekalongankab.aprkd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dd.processbutton.FlatButton;
import com.google.firebase.messaging.FirebaseMessaging;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.api.Client;
import online.aprkd_pekalongankab.aprkd.api.Service;
import online.aprkd_pekalongankab.aprkd.utilities.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    FlatButton btnLogin;
    SharedPrefManager sharedPrefManager;
    MaterialDialog materialDialog;
    MaterialEditText username,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPrefManager = new SharedPrefManager(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLogin(username.getText().toString(), password.getText().toString());

            }
        });
    }

    void requestLogin(String username, String password){
        materialDialog = new MaterialDialog.Builder(this)
                .content("Menunggu...")
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(true)
                .show();
        Service serviceAPI = Client.getClient();
        serviceAPI.loginRequest(username, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                materialDialog.dismiss();
                if(response.isSuccessful()){
                    try{
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        if(jsonRESULTS.getString("error").equalsIgnoreCase("false")){
                            //if login sukses
                            String id_penanggungjawab = jsonRESULTS.getJSONObject("user").getString("id");
                            String jenis = jsonRESULTS.getJSONObject("user").getString("jabatan");
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_ID_PENANGGUNGJAWAB, id_penanggungjawab);
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_JENIS, jenis);
                            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                            FirebaseMessaging.getInstance().subscribeToTopic(sharedPrefManager.getSpIdPenanggungjawab());
                            Toast.makeText(LoginActivity.this, "Selamat Datang", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, KesiapanActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                            finish();
                        }else{
                            //if login gagal
                            String error_msg = jsonRESULTS.getString("error_msg");
                            Toast.makeText(LoginActivity.this, error_msg, Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        Log.d("Error Login",e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                materialDialog.dismiss();
                String error = "Anda Tidak Terhubung Ke Internet, Silahkan Periksa Koneksi Anda";
                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
