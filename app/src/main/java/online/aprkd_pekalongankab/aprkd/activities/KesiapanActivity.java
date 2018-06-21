package online.aprkd_pekalongankab.aprkd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.Tab.KesiapanAdapter;
import online.aprkd_pekalongankab.aprkd.Tab.MyAdapter;
import online.aprkd_pekalongankab.aprkd.Tab.SiapKetuaAdapter;
import online.aprkd_pekalongankab.aprkd.Tab.SlidingTabLayout;
import online.aprkd_pekalongankab.aprkd.utilities.SharedPrefManager;

public class KesiapanActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefManager = new SharedPrefManager(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mViewPager = findViewById(R.id.vp_tabs);

        if(sharedPrefManager.getSpJenis().equalsIgnoreCase("ketua")){
            mViewPager.setAdapter(new SiapKetuaAdapter(getSupportFragmentManager(), this));
        }else{
            mViewPager.setAdapter(new KesiapanAdapter(getSupportFragmentManager(), this));
        }


        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(KesiapanActivity.this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
