package online.aprkd_pekalongankab.aprkd.activities;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.adapter.ListAlatAdapter;
import online.aprkd_pekalongankab.aprkd.adapter.MobilAdapter;
import online.aprkd_pekalongankab.aprkd.adapter.RuangAdapter;
import online.aprkd_pekalongankab.aprkd.api.Client;
import online.aprkd_pekalongankab.aprkd.api.Service;
import online.aprkd_pekalongankab.aprkd.objek.ListAlat;
import online.aprkd_pekalongankab.aprkd.objek.Mobil;
import online.aprkd_pekalongankab.aprkd.objek.Ruang;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlatActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<ListAlat> mArrayList;
    private ListAlatAdapter mAdapter;
    private MenuItem search;
    private SearchView searchView;
    MaterialDialog materialDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruang);
        Toolbar toolbar = findViewById(R.id.ruangToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Daftar Alat");

        reqPermitPhone();

        mRecyclerView = findViewById(R.id.searchTurun);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void loadJSON(){
        materialDialog = new MaterialDialog.Builder(this)
                .content("Menunggu...")
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(true)
                .show();
        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadSearch = serviceAPI.getAlat();
        loadSearch.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                materialDialog.dismiss();
                String faskesString = response.body().toString();

                Type listType = new TypeToken<ArrayList<ListAlat>>() {}.getType();
                mArrayList = getTeamListFromJson(faskesString, listType);

                //Collections.sort(mArrayList,Faskes.BY_JARAK);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mAdapter = new ListAlatAdapter(mArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                materialDialog.dismiss();
                Log.d("Error",t.getMessage());
            }
        });
    }

    public static <T> ArrayList<T> getTeamListFromJson(String jsonString, Type type) {
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

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem cari = menu.findItem(R.id.btnSearch);
        cari.setVisible(false);

        search = menu.findItem(R.id.search);
        searchView  = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (mAdapter != null) {
                    mAdapter.getFilter().filter(newText);

                }
                return true;
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean reqPermitPhone(){
        String permission = Manifest.permission.CALL_PHONE;
        if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
            if(!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)){
                requestPermissions(new String[] {permission}, 101);
            }
        }
        return true;
    }


}
