package online.aprkd_pekalongankab.aprkd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.objek.LihatAlat;

public class LihatAlatAdapter extends RecyclerView.Adapter<LihatAlatAdapter.MyViewHolder> {

    private Context mContext;
    private List<LihatAlat> fileList = new ArrayList<>();

    public LihatAlatAdapter(Context mContext, List<LihatAlat> fileList) {
        this.fileList = fileList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_alat, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LihatAlat lihatAlat = fileList.get(position);
        holder.nama_alat.setText(lihatAlat.getNamaPerlengkapan());
        holder.jumlah.setText(lihatAlat.getJumlah());

//        String thumbnail = mContext.getResources().getString(R.string.pathFoto)+filescan.getFileName();
//        holder.foto = thumbnail;
//
//        Glide.with(mContext).load(thumbnail)
//                .thumbnail(Glide.with(mContext).load(R.drawable.elip))
//                .fitCenter()
//                .crossFade()
//                .into(holder.image);
    }


    @Override
    public int getItemCount(){
        return fileList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama_alat, jumlah;

        public MyViewHolder(View view){

            super(view);
            nama_alat = view.findViewById(R.id.nama_alat);
            jumlah = view.findViewById(R.id.jumla_alat);

        }
    }
}

