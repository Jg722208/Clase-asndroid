package com.jguerrero.proyclassemn12.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jguerrero.proyclassemn12.Clases.Contacto;
import com.jguerrero.proyclassemn12.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WebAdapter extends RecyclerView.Adapter<WebAdapter.ConWebViewHolder> {

    List<Contacto> mData;
    public WebAdapter(List<Contacto> agenda) {
        mData = agenda;
    }

    @NonNull
    @Override
    public ConWebViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_web, parent, false);
        WebAdapter.ConWebViewHolder vh = new WebAdapter.ConWebViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ConWebViewHolder holder, int position) {
        Context context = holder.context;

        TextView nombre = holder.itemView.findViewById(R.id.tvNombreWeb);
        TextView numero = holder.itemView.findViewById(R.id.tvNumeroWeb);
        TextView email = holder.itemView.findViewById(R.id.tvEmailWeb);
        TextView address = holder.itemView.findViewById(R.id.tvAddressWeb);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);

        String nom = String.valueOf(mData.get(position).getName());
        //String num = String.join("\n", mData.get(position).getPhones()); // asi como aca se mandan listas de parametros en una lista xde
        String num = String.valueOf(mData.get(position).getNumero());
        String ema = String.valueOf(mData.get(position).getEmail());
        String add = String.valueOf(mData.get(position).getAddress());
        nombre.setText(nom);
        numero.setText(num);
        email.setText(ema);
        address.setText(add);

        Picasso.get().load("https://e39a9f00db6c5bc097f9-75bc5dce1d64f93372e7c97ed35869cb.ssl.cf1.rackcdn.com/img-U-6u2gUf.jpg").into(imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ConWebViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public ConWebViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }
    }
}
