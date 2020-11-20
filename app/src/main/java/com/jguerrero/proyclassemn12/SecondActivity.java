package com.jguerrero.proyclassemn12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView concatenar;
    double n1,n2,res;
    String Operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button boton1 = findViewById(R.id.button1);
        Button boton2 = findViewById(R.id.button2);
        Button boton3 = findViewById(R.id.button3);
        Button boton4 = findViewById(R.id.button4);
        Button boton5 = findViewById(R.id.button5);
        Button boton6 = findViewById(R.id.button6);
        Button boton7 = findViewById(R.id.button7);
        Button boton8 = findViewById(R.id.button8);
        Button boton9 = findViewById(R.id.button9);
        Button botonZ = findViewById(R.id.button0);
        Button botonClear = findViewById(R.id.buttonClear);
        Button botonPlus = findViewById(R.id.buttonPlus);
        Button botonMin = findViewById(R.id.buttonMin);
        Button botonPor = findViewById(R.id.buttonPor);
        Button botonDiv = findViewById(R.id.buttonDiv);
        Button botonEqu = findViewById(R.id.buttonEquals);
        TextView tvdisplay = findViewById(R.id.resultTextView);

        botonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "+");
            }
        });

        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "1");
            }
        });
        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "2");
            }
        });
        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "3");
            }
        });
        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "4");
            }
        });
        boton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "5");
            }
        });
        boton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "6");
            }
        });
        boton7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "7");
            }
        });
        boton8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "8");
            }
        });
        boton9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "9");
            }
        });
        botonZ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                concatenar = (TextView)findViewById(R.id.resultTextView);
                tvdisplay.setText(concatenar.getText().toString() + "0");
            }
        });
        botonClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvdisplay.setText("");
            }
        });
    }
}