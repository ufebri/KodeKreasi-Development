package com.kode.kreasi.kodekreasirecruitment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kode.kreasi.kodekreasirecruitment.Model.Model;
import com.kode.kreasi.kodekreasirecruitment.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adapter extends BaseAdapter {

    private ArrayList<Model> modelList;
    Activity activity;

    // View lookup cache
    private static class ViewHolder {
        TextView tvNama,tvNomor,tvAlamat, tvKota;
    }

    public Adapter(ArrayList<Model> data, Activity activity) {
        this.modelList = data;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = null;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_lihat_data, null);
            holder.tvNama = (TextView)view.findViewById(R.id.tv_item_nama);
            holder.tvNomor = (TextView)view.findViewById(R.id.tv_item_nomor);
            holder.tvAlamat = (TextView)view.findViewById(R.id.tv_item_alamat);
            holder.tvKota = (TextView)view.findViewById(R.id.tv_item_kota);

            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        Model model = modelList.get(position);

        holder.tvNama.setText(model.getNama());
        holder.tvNomor.setText(model.getNo_hp());
        holder.tvKota.setText(model.getKota());
        holder.tvAlamat.setText(model.getAlamat());
        return view;
    }
}
