package online.aprkd_pekalongankab.aprkd.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import online.aprkd_pekalongankab.aprkd.activities.DetailActivity;
import online.aprkd_pekalongankab.aprkd.R;
import online.aprkd_pekalongankab.aprkd.activities.DetailAlatActivity;
import online.aprkd_pekalongankab.aprkd.objek.PinjamRuang;
import online.aprkd_pekalongankab.aprkd.objek.SiapAlat;


/**
 * Created by OiX on 23/11/2017.
 */

public class KesiapanAlatAdapter extends RecyclerView.Adapter<KesiapanAlatAdapter.ViewHolder> implements Filterable {
    private ArrayList<SiapAlat> mArrayList;
    private ArrayList<SiapAlat> mFilteredList;

    public KesiapanAlatAdapter(ArrayList<SiapAlat> arrayList){
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public KesiapanAlatAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_kesiapan, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(KesiapanAlatAdapter.ViewHolder holder, int i) {
        String tanggal, acara;

        tanggal = mFilteredList.get(i).getTanggalPeminjaman();
        tanggal = tanggal.substring(0,6);
        holder.tv_tanggal.setText(tanggal);


        holder.tv_no_surat.setText(mFilteredList.get(i).getNoSurat());
        holder.tv_peminjam.setText(mFilteredList.get(i).getNamaPeminjam());
        holder.tv_acara.setText(mFilteredList.get(i).getNamaPerlengkapan()+"\n"+mFilteredList.get(i).getJumlah());
        holder.tv_status.setText(mFilteredList.get(i).getStatus());

        holder.id = mFilteredList.get(i).getId();

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

                    ArrayList<SiapAlat> filteredList = new ArrayList<>();

                    for (SiapAlat pinjamRuang : mArrayList) {

                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<SiapAlat>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_no_surat, tv_peminjam, tv_acara,tv_tanggal, tv_status;
        private String ruang, tanggal, waktu, peserta, status,id, foto_kesiapan;


        public ViewHolder(View view){
            super(view);

            tv_no_surat = view.findViewById(R.id.tv_no_surat);
            tv_peminjam = view.findViewById(R.id.tv_peminjam);
            tv_acara = view.findViewById(R.id.tv_acara);
            tv_tanggal = view.findViewById(R.id.tv_tanggal);
            tv_status = view.findViewById(R.id.tv_status);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(v.getContext(), DetailAlatActivity.class);
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
                        intent.putExtra("edit","true");
//                        intent.putExtra("foto_kesiapan",foto_kesiapan);

                        v.getContext().startActivity(intent);
                    }
                }
            });

        }
    }
}
