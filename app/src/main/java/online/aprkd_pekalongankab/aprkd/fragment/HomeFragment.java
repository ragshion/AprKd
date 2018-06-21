package online.aprkd_pekalongankab.aprkd.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import online.aprkd_pekalongankab.aprkd.R;


public class HomeFragment extends Fragment {
    private FragmentTabHost fragmentTabHost;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /*fragmentTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("post").setIndicator("Post"), FriendFragment.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("search").setIndicator("Pencarian"), MingguFragment.class, null);
        */

        return view;
    }
}
