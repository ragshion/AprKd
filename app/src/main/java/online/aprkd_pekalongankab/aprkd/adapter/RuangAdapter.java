package online.aprkd_pekalongankab.aprkd.adapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import online.aprkd_pekalongankab.aprkd.activities.DetailActivity;
import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.objek.PinjamRuang;
import online.aprkd_pekalongankab.aprkd.objek.Ruang;


/**
 * Created by OiX on 23/11/2017.
 */

public class RuangAdapter extends RecyclerView.Adapter<RuangAdapter.ViewHolder> implements Filterable {
    private ArrayList<Ruang> mArrayList;
    private ArrayList<Ruang> mFilteredList;

    public RuangAdapter(ArrayList<Ruang> arrayList){
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public RuangAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_ruang, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RuangAdapter.ViewHolder holder, int i) {
        holder.tv_ruang.setText(mFilteredList.get(i).getNamaRuang());
        holder.tv_fasilitas.setText(mFilteredList.get(i).getFasilitas());
        holder.tv_penanggung_jawab.setText("Penanggung Jawab : "+mFilteredList.get(i).getNama());
        holder.no_hp = mFilteredList.get(i).getNo_hp();
    }

    @Override
    public int getItemCount(){
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilteredList = mArrayList;
                } else {

                    ArrayList<Ruang> filteredList = new ArrayList<>();

                    for (Ruang ruang : mArrayList) {

                        if (ruang.getNamaRuang().toLowerCase().contains(charString) || ruang.getFasilitas().toLowerCase().contains(charString)) {
                            filteredList.add(ruang);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Ruang>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_ruang, tv_fasilitas, tv_penanggung_jawab;
        private ImageView iv_call;
        String no_hp;


        public ViewHolder(View view){
            super(view);

            tv_ruang = view.findViewById(R.id.tv_ruang);
            tv_fasilitas = view.findViewById(R.id.tv_fasilitas);
            tv_penanggung_jawab = view.findViewById(R.id.tv_penanggung_jawab);
            iv_call = view.findViewById(R.id.iv_call);

            iv_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nomor = "tel:"+no_hp.trim();
                    Intent manggilIntent = new Intent(Intent.ACTION_CALL);
                    manggilIntent.setData(Uri.parse(nomor));
                    if(ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        return;
                    }
                    v.getContext().startActivity(manggilIntent);
                }
            });

//            view.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition();
//                    if(pos != RecyclerView.NO_POSITION){
//                        Intent intent = new Intent(v.getContext(), DetailActivity.class);
////                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//                        intent.putExtra("no_surat",tv_no_surat.getText());
////                        intent.putExtra("acara",tv_acara.getText());
////                        intent.putExtra("tempat",ruang);
////                        intent.putExtra("tanggal",tanggal);
////                        intent.putExtra("waktu",waktu);
////                        intent.putExtra("peserta",peserta);
////                        intent.putExtra("penyelenggara",tv_peminjam.getText());
////                        intent.putExtra("status",status);
//                        intent.putExtra("id",id);
//                        intent.putExtra("edit","false");
////                        intent.putExtra("foto_kesiapan",foto_kesiapan);
//
//                        v.getContext().startActivity(intent);
//                    }
//                }
//            });

        }
    }
}
