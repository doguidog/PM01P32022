package com.example.pm01p32022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Vamos a declarar los elementos globales (text) y los botones
    EditText txtnombre, txtapellido;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vamos a declarar los objetos y castearlos a EditText y Button
        //Basicamente estamos amarrando en la parte logica los elementos

        txtnombre = (EditText) findViewById(R.id.textnombre);
        txtapellido = (EditText) findViewById(R.id.textapellido);
        btnagregar = (Button) findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "Hola", Toast.LENGTH_SHORT).show();
                //Ponemos una instancia de MainActivity2
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                //Le agregamos los elementos y los captura el MainActivity2
                intent.putExtra( "nombre", txtnombre.getText().toString());
                intent.putExtra( "apellido", txtapellido.getText().toString());

                startActivity(intent);
            }
        });

    }
}