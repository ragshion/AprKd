package online.aprkd_pekalongankab.aprkd.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.adapter.AlatAdapter;
import online.aprkd_pekalongankab.aprkd.adapter.ArsipAdapter;
import online.aprkd_pekalongankab.aprkd.adapter.KendaraanAdapter;
import online.aprkd_pekalongankab.aprkd.api.Client;
import online.aprkd_pekalongankab.aprkd.api.Service;
import online.aprkd_pekalongankab.aprkd.objek.Alat;
import online.aprkd_pekalongankab.aprkd.objek.Disposisi;
import online.aprkd_pekalongankab.aprkd.objek.PinjamKendaraan;
import online.aprkd_pekalongankab.aprkd.objek.PinjamRuang;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HariFragment extends android.support.v4.app.Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<PinjamRuang> mArrayList;
    private ArsipAdapter mAdapter;
    private ArrayList<PinjamKendaraan> kArrayList;
    private KendaraanAdapter kendaraanAdapter;
    private ArrayList<Alat> alatArrayList;
    private AlatAdapter alatAdapter;
    private MenuItem search;
    private SearchView searchView;

    MaterialDialog materialDialog;
    String bidang="program";

    String ars="0";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public HariFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hari, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        if(getActivity().getIntent().hasExtra("peminjaman")){
            if(getActivity().getIntent().getStringExtra("peminjaman").equalsIgnoreCase("ruang")){
                loadJSON();
            }else if(getActivity().getIntent().getStringExtra("peminjaman").equalsIgnoreCase("kendaraan")){
                loadKendaraan();
            }else if(getActivity().getIntent().getStringExtra("peminjaman").equalsIgnoreCase("alat")){
                loadAlat();
            }
        }else{
            loadJSON();
        }



//        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new GridLayoutManager(getActivity(),3);
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new GridAdapter();
//        recyclerView.setAdapter(adapter);
        return view;
    }

    private void loadJSON(){

        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadHari = serviceAPI.getPeminjamanRuang("hari");
        loadHari.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String faskesString = response.body().toString();

                Type listType = new TypeToken<ArrayList<PinjamRuang>>() {}.getType();
                mArrayList = getTeamListFromJson(faskesString, listType);

                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mAdapter = new ArsipAdapter(mArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void loadKendaraan(){

        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadHari = serviceAPI.getPeminjamanKendaraan("hari");
        loadHari.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String faskesString = response.body().toString();

                Type listType = new TypeToken<ArrayList<PinjamKendaraan>>() {}.getType();
                kArrayList = getTeamListFromJson(faskesString, listType);

                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                kendaraanAdapter = new KendaraanAdapter(kArrayList);
                mRecyclerView.setAdapter(kendaraanAdapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void loadAlat(){

        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadHari = serviceAPI.getPeminjamanAlat("hari");
        loadHari.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String faskesString = response.body().toString();

                Type listType = new TypeToken<ArrayList<Alat>>() {}.getType();
                alatArrayList = getTeamListFromJson(faskesString, listType);

                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                alatAdapter = new AlatAdapter(alatArrayList);
                mRecyclerView.setAdapter(alatAdapter);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
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

}
