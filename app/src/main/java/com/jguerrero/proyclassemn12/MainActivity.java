package com.jguerrero.proyclassemn12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // codificar comportamiento de las cosas
        // acceder al boton y dar comportamiento

        //dejar mensaje: parametros: tag, saber el nombre del mensaje - msg, mensaje que se quiere mostrar
        Log.i("MYAPP","Este mensaje aparece cuando carga la pantalla");

        // findViewById() permite buscar los componentes de la clase por su ID de objeto:
        Button calculadora = findViewById(R.id.buttonX);
        Log.i("MYAPP","El valor de button es: " + String.valueOf(calculadora)); // con String.valueOf hace string en modo ejecucion

        // el siguiente manda una interface, tenemos que crear la clase que implemente de la interfaz, o hacer esto:
        calculadora.setOnClickListener(new ButtonClickListener());
        //button.setText("Hacer Click Aqui"); //Cambia el texto del boton
        String txtButton = (String)calculadora.getText(); // obtiene el texto original del boton, y transforma a String

        //Otra forma de acceder a boton: tercera actividad

        Button semana10 = findViewById(R.id.buttonY);
        semana10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MYAPP","Hice click en el boton Actividsad 3 Semana 10");
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

        Button listas = findViewById(R.id.buttonZ);
        listas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MYAPP","Hice click en el boton para listas");
                Intent intent = new Intent(MainActivity.this,ListasActivity.class);
                startActivity(intent);
            }
        });

        Button T3Actividad = findViewById(R.id.T3Button);
        T3Actividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MYAPP","Hice click en el boton para T3Activity");
                Intent intent = new Intent(MainActivity.this,T3Activity.class);
                startActivity(intent);
            }
        });

        Button activityWeb = findViewById(R.id.buttonWeb);
        activityWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MYAPP","Hice click en el boton para T3Activity");
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                startActivity(intent);
            }
        });
        Button mapa = findViewById(R.id.mapaActividad);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MYAPP","Hice click en el boton para T3Activity");
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    class ButtonClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            Log.i("MYAPP","Hice click en el boton Actividad 2 Calculadora");
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
    }
}

