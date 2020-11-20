package com.jguerrero.proyclassemn12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jguerrero.proyclassemn12.Clases.Contacto;
import com.jguerrero.proyclassemn12.Services.ContactService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_new);

        EditText id = findViewById(R.id.idContact);
        EditText nombre = findViewById(R.id.nameContact);
        EditText numero = findViewById(R.id.phoneContact);
        EditText email = findViewById(R.id.emailContact);
        EditText address = findViewById(R.id.addressContact);
        Button enviar = findViewById(R.id.sendContact);

        //Aca mandamos xde
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Web","Hice click en el boton enviar");

                String idNew = id.getText().toString().trim();
                String nombreNew = nombre.getText().toString().trim();
                String numeroNew = numero.getText().toString().trim();
                String emailNew = email.getText().toString().trim();
                String addressNew = address.getText().toString().trim();

                // para mandar desde un formulario se usa esto:
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://run.mocky.io/v3/") //tiene que finalizar con /
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ContactService service = retrofit.create(ContactService.class);

                // Se crea nuestro nuevo contacto!
                Contacto contacto = new Contacto();
                contacto.setId(idNew);
                contacto.setName(nombreNew);
                contacto.setNumero(numeroNew);
                contacto.setEmail(emailNew);
                //contacto.setAddress(addressNew);

                //Se llama a nuestro post :'D
                Call<Contacto> call = service.create(contacto);

                call.enqueue(new Callback<Contacto>() {
                    @Override
                    public void onResponse(Call<Contacto> call, Response<Contacto> response) {
                        if(response.code() == 200){
                            Log.i("Web","Conexion todo ok :D");
                        }else {
                            Log.i("Web","Conexion nada ok F");
                        }
                    }

                    @Override
                    public void onFailure(Call<Contacto> call, Throwable t) {
                        Log.i("Web","NO pudimos conectarnos al servidor");
                    }
                });

               Intent intent = new Intent(NewContact.this,WebActivity.class);
               startActivity(intent);
            }
        });
    }
}