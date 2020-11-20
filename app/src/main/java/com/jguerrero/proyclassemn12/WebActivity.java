package com.jguerrero.proyclassemn12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.jguerrero.proyclassemn12.Adapters.WebAdapter;
import com.jguerrero.proyclassemn12.Clases.Address;
import com.jguerrero.proyclassemn12.Clases.Contacto;
import com.jguerrero.proyclassemn12.Services.ContactService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        RecyclerView rv = findViewById(R.id.rvContactsWeb);
        Button crear = findViewById(R.id.newContact);
        Button irA = findViewById(R.id.mapaActividad);
               // mapsGoogle);

        Address address = new  Address();

        address.setLatitud("-7.15639");
        address.setLongitud("-78.5156");

        Contacto contacto = new Contacto();
        contacto.setId("20");
        contacto.setName("Edwin");
        contacto.setEmail("edwin@gmail.com");
        contacto.setNumero("932182696");
        //contacto.setAddress (address); //falta
        String c = "Hello world";

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MYAPP","Hice click en el boton para Crear nuevo contacto");
                Intent intent = new Intent(WebActivity.this,NewContact.class);
                intent.putExtra("name",c);
                intent.putExtra("code",10);
                //mandar una clase, se manda como string, en este caso Gson, convitiendo en string
                String clase = new Gson().toJson(contacto);
                intent.putExtra("clase",clase);
                startActivity(intent);
            }
        });

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        Log.i("Web","Iniciando Adapter con web");
        //CALL API UWU
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                //.baseUrl("https://webhook.site/") //tiene que finalizar con /
                .addConverterFactory(GsonConverterFactory.create())
                .build();
                ContactService service = retrofit.create(ContactService.class);

        Call<List<Contacto>> agenda = service.getAll();
        //Call<List<Contacto>> agenda = service.getByQuery("Konosuba"); //con este de aca se obtienen los datos

        agenda.enqueue(new Callback<List<Contacto>>() {
            @Override
            public void onResponse(Call<List<Contacto>> call, Response<List<Contacto>> response) {
                if(response.code() == 200){
                    Log.i("Web","Conexion todo ok :D");
                    List<Contacto> agenda  = response.body();
                    rv.setAdapter(new WebAdapter(agenda));
                    Log.i("Web",new Gson().toJson(agenda));
                }else {
                    Log.i("Web","Conexion nada ok F");
                }
            }

            @Override
            public void onFailure(Call<List<Contacto>> call, Throwable t) {
                Log.i("Web","NO pudimos conectarnos al servidor");
            }
        });

        Log.i("Web","Llenando Adapter con web");

    }
}