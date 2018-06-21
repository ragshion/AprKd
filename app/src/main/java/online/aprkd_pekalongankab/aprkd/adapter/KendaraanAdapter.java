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
import online.aprkd_pekalongankab.aprkd.activities.DetailKendaraanActivity;
import online.aprkd_pekalongankab.aprkd.objek.PinjamKendaraan;
import online.aprkd_pekalongankab.aprkd.objek.PinjamRuang;
import online.aprkd_pekalongankab.aprkd.objek.Ruang;


/**
 * Created by OiX on 23/11/2017.
 */

public class KendaraanAdapter extends RecyclerView.Adapter<KendaraanAdapter.ViewHolder> implements Filterable {
    private ArrayList<PinjamKendaraan> mArrayList;
    private ArrayList<PinjamKendaraan> mFilteredList;

    public KendaraanAdapter(ArrayList<PinjamKendaraan> arrayList){
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public KendaraanAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_pinjam_kendaraan, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(KendaraanAdapter.ViewHolder holder, int i) {
        holder.id = mFilteredList.get(i).getId();
        holder.tv_no_surat.setText(mFilteredList.get(i).getNoSurat());
        holder.tv_peminjam.setText(mFilteredList.get(i).getNamaPeminjam());
        holder.tv_merek.setText(mFilteredList.get(i).getMerk());
        holder.tv_tanggal.setText(mFilteredList.get(i).getTanggalPeminjaman()+" - "+mFilteredList.get(i).getTanggalSelesai());
        holder.tv_acara.setText(mFilteredList.get(i).getAcara());
        holder.tv_status.setText(mFilteredList.get(i).getStatus());
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

                    ArrayList<PinjamKendaraan> filteredList = new ArrayList<>();

                    for (PinjamKendaraan ruang : mArrayList) {


                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<PinjamKendaraan>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_no_surat, tv_peminjam, tv_merek, tv_tanggal,tv_acara,tv_status;
        String id;

        public ViewHolder(View view){
            super(view);

            tv_no_surat = view.findViewById(R.id.tv_no_surat);
            tv_peminjam = view.findViewById(R.id.tv_peminjam);
            tv_merek = view.findViewById(R.id.tv_merek);
            tv_tanggal = view.findViewById(R.id.tv_tanggal);
            tv_acara = view.findViewById(R.id.tv_acara);
            tv_status = view.findViewById(R.id.tv_status);


            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(v.getContext(), DetailKendaraanActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent.putExtra("no_surat",tv_no_surat.getText());
//                        intent.putExtra("acara",tv_acara.getText());
//                        intent.putExtra("tempat",ruang);
//                        intent.putExtra("tanggal",tanggal);
//                        intent.putExtra("waktu",waktu);
//                        intent.putExtra("peserta",peserta);
//                        intent.putExtra("penyelenggara",tv_peminjam.getText());
//                        intent.putExtra("status",status);
                        intent.putExtra("id",id);
                        intent.putExtra("edit","false");
//                        intent.putExtra("foto_kesiapan",foto_kesiapan);

                        v.getContext().startActivity(intent);
                    }
                }
            });

        }
    }
}
