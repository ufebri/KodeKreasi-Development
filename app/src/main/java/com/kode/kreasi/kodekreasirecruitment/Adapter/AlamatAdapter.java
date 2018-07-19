package com.kode.kreasi.kodekreasirecruitment.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kode.kreasi.kodekreasirecruitment.Model.Alamat;
import com.kode.kreasi.kodekreasirecruitment.R;

import java.util.ArrayList;


public class AlamatAdapter extends RecyclerView.Adapter<AlamatAdapter.AlamatViewHolder> {
    private ArrayList<Alamat> dataList;

    public AlamatAdapter(ArrayList<Alamat> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AlamatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.content_show_data, parent, false);
        return new AlamatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlamatViewHolder holder, int position) {
        holder.tvID.setText(dataList.get(position).getId());
        holder.tvNama.setText(dataList.get(position).getNama());
        holder.tvAlamat.setText(dataList.get(position).getAlamat());
        holder.tvProvinsi.setText(dataList.get(position).getProvinsi());
        holder.tvKota.setText(dataList.get(position).getKota());
        holder.tvTglLahir.setText(dataList.get(position).getTanggal_lahir());
        holder.tvNoHp.setText(dataList.get(position).getNo_hp());
        holder.tvCreatedAt.setText(dataList.get(position).getCreated_at());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class AlamatViewHolder extends RecyclerView.ViewHolder {

        TextView tvID, tvNama, tvAlamat, tvProvinsi, tvKota, tvTglLahir, tvNoHp, tvCreatedAt;

        public AlamatViewHolder(View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvProvinsi = itemView.findViewById(R.id.tv_provinsi);
            tvKota = itemView.findViewById(R.id.tv_kota);
            tvTglLahir = itemView.findViewById(R.id.tv_tgl_lahir);
            tvNoHp = itemView.findViewById(R.id.tv_no_hp);
            tvCreatedAt = itemView.findViewById(R.id.tv_created_at);
        }
    }
}
