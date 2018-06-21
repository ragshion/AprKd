package online.aprkd_pekalongankab.aprkd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.Tab.MyAdapter;
import online.aprkd_pekalongankab.aprkd.Tab.SlidingTabLayout;
import online.aprkd_pekalongankab.aprkd.utilities.SharedPrefManager;

public class PinjamAlatActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Drawer navigationDrawerLeft;
    private AccountHeader headerNavigationLeft;
    SharedPrefManager sharedPrefManager;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPrefManager = new SharedPrefManager(this);

        mViewPager=(ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

        //============================================
        //Navigation Drawer

        headerNavigationLeft = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeightRes(R.dimen.HeaderMaterialDrawer)
                .withHeaderBackground(R.color.colorPrimary)
                .withCurrentProfileHiddenInList(true)
                .withSelectionListEnabledForSingleProfile(false)
                .addProfiles(
                        new ProfileDrawerItem().withName("APR & KD").withEmail("App Peminjaman Ruang & Kendaraan Dinas").withIcon(getResources().getDrawable(R.drawable.logo_pekalongankab))
                )
                .build();

        final PrimaryDrawerItem pinjamRuang = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Peminjaman Ruang")
                .withIcon(R.drawable.ic_home_black_24dp);

        PrimaryDrawerItem ruang = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName("Ruang")
                .withIcon(R.drawable.ic_ruang);

        final PrimaryDrawerItem pinjamKendaraan = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName("Peminjaman Kendaraan")
                .withIcon(R.drawable.ic_pinjam_kendaraan);

        PrimaryDrawerItem kendaraan = new PrimaryDrawerItem()
                .withIdentifier(4)
                .withName("Kendaraan")
                .withIcon(R.drawable.ic_kendaraan);

        final PrimaryDrawerItem pinjamAlat = new PrimaryDrawerItem()
                .withIdentifier(5)
                .withName("Peminjaman Peralatan")
                .withIcon(R.drawable.ic_pinjam_alat);

        PrimaryDrawerItem Alat = new PrimaryDrawerItem()
                .withIdentifier(6)
                .withName("Peralatan")
                .withIcon(R.drawable.ic_alat);

        PrimaryDrawerItem login = new PrimaryDrawerItem()
                .withIdentifier(7)
                .withName("Login")
                .withIcon(R.drawable.ic_login);

        PrimaryDrawerItem kesiapan = new PrimaryDrawerItem()
                .withIdentifier(8)
                .withName("Kesiapan")
                .withIcon(R.drawable.ic_siap);

        PrimaryDrawerItem logout = new PrimaryDrawerItem()
                .withIdentifier(9)
                .withName("Logout")
                .withIcon(R.drawable.ic_logout_24dp);

        navigationDrawerLeft = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(headerNavigationLeft)
                .addDrawerItems(
                        pinjamRuang,
                        ruang,
                        new DividerDrawerItem(),
                        pinjamKendaraan,
                        kendaraan,
                        new DividerDrawerItem(),
                        pinjamAlat,
                        Alat,
                        new DividerDrawerItem(),
                        login
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position){
                            case 1:
                                Intent pinjamRng = new Intent(PinjamAlatActivity.this, MainActivity.class);
                                pinjamRng.putExtra("peminjaman","ruang");
                                startActivity(pinjamRng);
                                finish();
                                break;
                            case 2:
                                Intent ruang = new Intent(PinjamAlatActivity.this, RuangActivity.class);
                                startActivity(ruang);
                                navigationDrawerLeft.setSelection(pinjamAlat);
                                break;
                            case 4:
                                Intent pinjamAlt = new Intent(PinjamAlatActivity.this, PinjamKendaraanActivity.class);
                                pinjamAlt.putExtra("peminjaman","kendaraan");
                                startActivity(pinjamAlt);
                                finish();
                                break;
                            case 5:
                                Intent kendaraan = new Intent(PinjamAlatActivity.this, KendaraanActivity.class);
                                startActivity(kendaraan);
                                navigationDrawerLeft.setSelection(pinjamAlat);
                                break;
                            case 8:
                                Intent Alat = new Intent(PinjamAlatActivity.this, AlatActivity.class);
                                startActivity(Alat);
                                navigationDrawerLeft.setSelection(pinjamAlat);
                                break;
                            case 10:
                                if(sharedPrefManager.getSPSudahLogin()){
                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                                    startActivity(new Intent(PinjamAlatActivity.this, MainActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                    break;
                                }else{
                                    Intent login = new Intent(PinjamAlatActivity.this, LoginActivity.class);
                                    startActivity(login);
                                    navigationDrawerLeft.setSelection(pinjamAlat);
                                    break;
                                }

                            case 11:
                                Intent kesiapan = new Intent(PinjamAlatActivity.this, KesiapanActivity.class);
                                startActivity(kesiapan);
                                navigationDrawerLeft.setSelection(pinjamAlat);
                                finish();
                                break;
                        }
                        navigationDrawerLeft.closeDrawer();
                        return true;
                    }
                })
                .build();

        navigationDrawerLeft.setSelection(pinjamAlat);

        //===========
        //BottomBar
//        bottomBar = (BottomBar) findViewById(R.id.bottombar);
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            Fragment fragment = null;
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if(tabId == R.id.tab_home){
//                    fragment = new HomeFragment();
//                }else if(tabId == R.id.tab_explore){
//                    fragment = new MingguFragment();
//                }else if(tabId == R.id.tab_chat){
//                    fragment = new ChatFragment();
//                }else if(tabId == R.id.tab_friend){
//                    fragment = new FriendFragment();
//                }
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.content, fragment)
//                        .commit();
//            }
//        });

        if(sharedPrefManager.getSPSudahLogin()){
            navigationDrawerLeft.removeItem(7);
            navigationDrawerLeft.addItem(logout);
            navigationDrawerLeft.addItem(kesiapan);
        }

    }

    @Override
    public void onBackPressed() {
        confirmQuit();
    }

    private void confirmQuit() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        doubleBackToExitPressedOnce = true;
        Toast.makeText(this,"Tekan kembali sekali lagi untuk Keluar",Toast.LENGTH_SHORT).show();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


}
