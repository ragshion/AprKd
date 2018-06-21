package online.aprkd_pekalongankab.aprkd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.adapter.LihatAlatAdapter;
import online.aprkd_pekalongankab.aprkd.api.Client;
import online.aprkd_pekalongankab.aprkd.api.Service;
import online.aprkd_pekalongankab.aprkd.objek.LihatAlat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity{
    public CoordinatorLayout coordinatorLayout;
    public CollapsingToolbarLayout collapsingToolbarLayout;
    public Toolbar toolbar;
    public TextView no_surat,acara,tempat,tanggal,waktu,jumlah_peserta,penyelenggara, status;
    public ImageView foto;
    FloatingActionButton btnEdit;

    private RecyclerView recyclerView;
    private LinearLayoutManager lLayout;

    private List<LihatAlat> faskes = new ArrayList<>();

    String thumbnail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        no_surat = findViewById(R.id.txtDtNoSurat);
        acara = findViewById(R.id.txtDtAcara);
        tempat = findViewById(R.id.txtDtTempat);
        tanggal = findViewById(R.id.txtDtTanggal);
        waktu = findViewById(R.id.txtDtJam);
        jumlah_peserta = findViewById(R.id.txtDtPeserta);
        penyelenggara = findViewById(R.id.txtDtPenyelenggara);
        status = findViewById(R.id.txtDtStatus);

        foto = findViewById(R.id.mainbackdrop);

        btnEdit = findViewById(R.id.btnEdit);


        if(getIntent().getStringExtra("edit").equals("false")){
            btnEdit.setVisibility(View.GONE);
        }

        toolbar = findViewById(R.id.maintoolbar);
        toolbar.setTitle(acara.getText());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = findViewById(R.id.coordinator);
        collapsingToolbarLayout = findViewById(R.id.maincollapsing);
        collapsingToolbarLayout.setTitle(acara.getText());

        lLayout = new LinearLayoutManager(DetailActivity.this);
        recyclerView = findViewById(R.id.recycler_alat);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lLayout);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent formEdit = new Intent(DetailActivity.this,UpdateKesiapan.class);
                formEdit.putExtra("tabel","peminjaman");
                formEdit.putExtra("id",getIntent().getStringExtra("id"));
                startActivity(formEdit);
            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, DetailImage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("foto",thumbnail);
                startActivity(intent);
            }
        });




        loadDetail(getIntent().getStringExtra("id"));
        loadAlat();
    }

    void loadAlat(){
        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadAlat = serviceAPI.getAlatBy(getIntent().getStringExtra("id"));
        loadAlat.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String faskesString = response.body().toString();

                Type listType = new TypeToken<List<LihatAlat>>() {}.getType();
                faskes = getTeamListFromJson(faskesString, listType);

                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(new LihatAlatAdapter(getApplicationContext(), faskes));
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.v("DetailActivity",t.getMessage());
            }
        });
    }

    void loadDetail(String id){
        Service serviceAPI = Client.getClient();
        serviceAPI.getDetailPeminjamanRuang(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
                    no_surat.setText(jsonRESULTS.getJSONObject("data").getString("no_surat"));
                    acara.setText(jsonRESULTS.getJSONObject("data").getString("acara"));
                    tempat.setText(jsonRESULTS.getJSONObject("data").getString("nama_ruang"));
                    tanggal.setText(jsonRESULTS.getJSONObject("data").getString("tanggal"));
                    waktu.setText(jsonRESULTS.getJSONObject("data").getString("waktu"));
                    jumlah_peserta.setText(jsonRESULTS.getJSONObject("data").getString("jumlah_peserta"));
                    penyelenggara.setText(jsonRESULTS.getJSONObject("data").getString("nama_peminjam"));
                    status.setText(jsonRESULTS.getJSONObject("data").getString("status"));

                    thumbnail = getResources().getString(R.string.pathFoto)+jsonRESULTS.getJSONObject("data").getString("foto_kesiapan");

                    if(jsonRESULTS.getJSONObject("data").getString("foto_kesiapan").equals("default")){
                        foto.setImageResource(R.drawable.def);
                    }else{
                        Glide.with(DetailActivity.this)
                                .load(thumbnail)
                                .thumbnail(Glide.with(DetailActivity.this).load(R.drawable.def))
                                .fitCenter()
                                .crossFade()
                                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                                .into(foto);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Log.v("ErrorGetData",e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String error = "Anda Tidak Terhubung Ke Internet, Silahkan Periksa Koneksi Anda";
                Toast.makeText(DetailActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static <T> List<T> getTeamListFromJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }
}
