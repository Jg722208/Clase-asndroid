package com.jguerrero.proyclassemn12.Adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jguerrero.proyclassemn12.ListasActivity;
import com.jguerrero.proyclassemn12.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

// la clase adapter necesita extender de Adapter y mandar el ViewHolder
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private static final int permisoCall = 1001;

    ArrayList<ListasActivity.Agenda> mData;

    public ContactAdapter(ArrayList<ListasActivity.Agenda> contactos) {
        mData = contactos;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // el context lo tiene el ViewGroup
        Context context = parent.getContext();

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ContactViewHolder vh = new ContactViewHolder(v,context); // este necesita un view, y para hacerlo tenemos que instanciar todon lo de arriba
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) { //es como si fuera el create
        Context context = holder.context;

        TextView nombre = holder.itemView.findViewById(R.id.tvNombre);
        TextView numero = holder.itemView.findViewById(R.id.tvNumero);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);

        Button llamar = holder.itemView.findViewById(R.id.Llamar);
        Button sms = holder.itemView.findViewById(R.id.SMS);

        String nom = String.valueOf(mData.get(position).getNombre());
        String num = String.valueOf(mData.get(position).getNumero());
        nombre.setText(nom);
        numero.setText(num);

        Picasso.get().load("https://e39a9f00db6c5bc097f9-75bc5dce1d64f93372e7c97ed35869cb.ssl.cf1.rackcdn.com/img-U-6u2gUf.jpg").into(imageView);

        //String text = mData.get(position);
        //nombre.setText(text);

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    String celular = num;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel: " + celular));
                    context.startActivity(intent);
                }else{
                    String[] permisos = new String[] {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions((Activity) context, permisos, permisoCall);
                }

            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celular = num;
                //String mensaje = message.getText().toString();
                Uri uri = Uri.parse("smsto:"+celular);
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri); // Abre la app para mensaje: porque es ACTION_DIAL, no necesita permisos
                //intent.putExtra("sms_body", mensaje);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { // retornar el tamaño de la lista, o de elementos
        return mData.size();
    }

    // Por cada clase adapter necesito un ViewHolder, por eso esta clase existe aca:
    public class ContactViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public ContactViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }
    }

}