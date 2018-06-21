package online.aprkd_pekalongankab.aprkd.Tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.fragment.BulanFragment;
import online.aprkd_pekalongankab.aprkd.fragment.ChatFragment;
import online.aprkd_pekalongankab.aprkd.fragment.HariFragment;
import online.aprkd_pekalongankab.aprkd.fragment.MingguFragment;
import online.aprkd_pekalongankab.aprkd.fragment.HomeFragment;


/**
 * Created by OiX on 22/08/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"A","B","C"};
    int[] icon = new int[]{R.drawable.ic_hari,R.drawable.ic_minggu,R.drawable.ic_bulan};
    private int heightIcon;
    private int widthIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int)(24*scale+0.5f);
        widthIcon = (int)(64*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if(position==0){
            frag = new HariFragment();
        }else if(position==1){
            frag = new MingguFragment();
        }else if(position==2){
            frag = new BulanFragment();
        }
        /**else if(position==3){
            frag = new FriendFragment();
        }*/

        Bundle b = new Bundle();
        b.putInt("position",position);
        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,widthIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }
}
