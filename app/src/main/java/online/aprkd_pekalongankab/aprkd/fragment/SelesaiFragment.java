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
import online.aprkd_pekalongankab.aprkd.adapter.ArsipAdapter;
import online.aprkd_pekalongankab.aprkd.adapter.KesiapanAdapter;
import online.aprkd_pekalongankab.aprkd.api.Client;
import online.aprkd_pekalongankab.aprkd.api.Service;
import online.aprkd_pekalongankab.aprkd.objek.Disposisi;
import online.aprkd_pekalongankab.aprkd.objek.PinjamRuang;
import online.aprkd_pekalongankab.aprkd.utilities.SharedPrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelesaiFragment extends android.support.v4.app.Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<PinjamRuang> mArrayList;
    private KesiapanAdapter mAdapter;
    private MenuItem search;
    private SearchView searchView;

    MaterialDialog materialDialog;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    String id_penanggungjawab, status, jenis;

    SharedPrefManager sharedPrefManager;

    public SelesaiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hari, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        sharedPrefManager = new SharedPrefManager(view.getContext());
        id_penanggungjawab = sharedPrefManager.getSpIdPenanggungjawab();
        status = "in progress";
        jenis = sharedPrefManager.getSpJenis();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        loadJSON(id_penanggungjawab, status, jenis);

        return view;
    }

    private void loadJSON(String id_penanggungjawab, String status, String jenis){

        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadSiap = serviceAPI.getPeminjamanSiap(id_penanggungjawab, status, jenis);
        loadSiap.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                String faskesString = response.body().toString();

                Type listType = new TypeToken<ArrayList<PinjamRuang>>() {}.getType();
                mArrayList = getTeamListFromJson(faskesString, listType);

                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mAdapter = new KesiapanAdapter(mArrayList);
                mRecyclerView.setAdapter(mAdapter);
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
