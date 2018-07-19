package com.kode.kreasi.kodekreasirecruitment.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir.Rajaongkir;
import com.kode.kreasi.kodekreasirecruitment.Model.RajaOngkir.ResultsProvince;
import com.kode.kreasi.kodekreasirecruitment.R;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder> {

    private List<ResultsProvince> dataList;

    public ProvinceAdapter(List<ResultsProvince> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ProvinceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.content_show_provinci, parent,false);
        return new  ProvinceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvinceViewHolder holder, int position) {
        holder.tvIdProvince.setText(dataList.get(position).getProvince_id());
        holder.tvNameProvince.setText(dataList.get(position).getProvince());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ProvinceViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdProvince, tvNameProvince;

        public ProvinceViewHolder(View itemView) {
            super(itemView);

            tvIdProvince = itemView.findViewById(R.id.tv_provinsi_id);
            tvNameProvince = itemView.findViewById(R.id.tv_provinsi_name);
        }
    }

    public void updateProvince(List<Rajaongkir> rajaongkirs){

    }
}
