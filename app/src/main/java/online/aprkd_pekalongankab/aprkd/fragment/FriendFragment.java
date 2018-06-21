package online.aprkd_pekalongankab.aprkd.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import online.aprkd_pekalongankab.aprkd.R;

/**
 * Created by OiX on 22/08/2017.
 */

public class FriendFragment extends Fragment {


    public FriendFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_friend, container, false);
    }
}
