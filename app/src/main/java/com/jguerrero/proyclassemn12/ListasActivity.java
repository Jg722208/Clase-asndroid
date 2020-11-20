package com.jguerrero.proyclassemn12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jguerrero.proyclassemn12.Adapters.ContactAdapter;


import java.util.ArrayList;
import java.util.List;

public class ListasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        RecyclerView rv = findViewById(R.id.rvContacts);

        rv.setHasFixedSize(true); // con true, es porque sabemos cuantos elementos vamos a tener, optimiza app
        rv.setLayoutManager(new LinearLayoutManager(this));
        //este de abajo es el mas importante :'3
        List<String> data = new ArrayList<>();
        data.add("Elemento 1");
        data.add("Elemento 2");
        data.add("Elemento 3");
        data.add("Elemento 4");

        ArrayList<Agenda> contactos = new ArrayList<>();
        contactos.add(new Agenda("Juan","965884978"));
        contactos.add(new Agenda("Lucho","995262290"));
        contactos.add(new Agenda("Pancho","942556859"));
        contactos.add(new Agenda("Pablo","918576489"));
        contactos.add(new Agenda("Pancracio","931195696"));

        rv.setAdapter(new ContactAdapter(contactos));
    }

    public class Agenda {
        public Agenda(String nombre, String numero) {
            this.nombre = nombre;
            this.numero = numero;
        }
        private String nombre;
        private String numero;

        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getNumero() {
            return numero;
        }
        public void setNumero(String numero) {
            this.numero = numero;
        }
    }

}

