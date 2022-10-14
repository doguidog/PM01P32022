package com.example.pm01p32022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPrinc extends AppCompatActivity {

    Button btnadd,btnlist,btncombo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princ);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnlist = (Button) findViewById(R.id.btnlist);
        btncombo = (Button) findViewById(R.id.btncombo);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Una intención proporciona una función para realizar un enlace en tiempo de
                ejecución tardío entre el código en diferentes aplicaciones. Su uso más
                significativo es en el lanzamiento de actividades, donde puede considerarse
                 como el pegamento entre actividades.*/

                //Verdadera funcion de esta intencion es mandar a llamar el Activity Ingresar
                Intent intent = new Intent(getApplicationContext(), ActivityIngresar.class);
                startActivity(intent);


            }
        }
        );

        btnlist.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                /*Una intención proporciona una función para realizar un enlace en tiempo de
                ejecución tardío entre el código en diferentes aplicaciones. Su uso más
                significativo es en el lanzamiento de actividades, donde puede considerarse
                 como el pegamento entre actividades.*/

                                          //Verdadera funcion de esta intencion es mandar a llamar el Activity Ingresar
                                          Intent intent = new Intent(getApplicationContext(), ActivityList.class);
                                          startActivity(intent);


                                      }
                                  }
        );

        btncombo.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                /*Una intención proporciona una función para realizar un enlace en tiempo de
                ejecución tardío entre el código en diferentes aplicaciones. Su uso más
                significativo es en el lanzamiento de actividades, donde puede considerarse
                 como el pegamento entre actividades.*/

                                           //Verdadera funcion de esta intencion es mandar a llamar el Activity Ingresar
                                           Intent intent = new Intent(getApplicationContext(), ActivityCombo.class);
                                           startActivity(intent);


                                       }
                                   }
        );
    }
}