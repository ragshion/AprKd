package online.aprkd_pekalongankab.aprkd.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import online.aprkd_pekalongankab.aprkd.R;

/**
 * Created by OiX on 22/08/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet,mDataSet2;
    private int[] mDataSet3;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView, textView2;
        private final ImageView icon;

        public ViewHolder(View v){
            super(v);
            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element "+ getPosition() + " clicked");
                }
            });
            textView = (TextView) v.findViewById(R.id.judul);
            textView2 = (TextView) v.findViewById(R.id.deskripsi);
            icon = (ImageView) v.findViewById(R.id.icon);
        }

        public TextView getTextView(){
            return textView;
        }

        public TextView getTextView2(){
            return textView2;
        }

        public ImageView getImageView(){
            return icon;
        }
    }

    public CustomAdapter(String[] dataSet, String[] dataSet2, int[] dataSet3){
        this.mDataSet = dataSet;
        this.mDataSet2 = dataSet2;
        this.mDataSet3 = dataSet3;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_view, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        viewHolder.getTextView().setText(mDataSet[position]);
        viewHolder.getTextView2().setText(mDataSet2[position]);
        viewHolder.getImageView().setImageResource(mDataSet3[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
