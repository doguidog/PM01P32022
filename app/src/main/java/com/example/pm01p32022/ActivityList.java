package com.example.pm01p32022;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm01p32022.configuracion.SQLiteConexion;
import com.example.pm01p32022.tablas.Persona;
import com.example.pm01p32022.tablas.Transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listperson;
    ArrayList<Persona> lista;
    ArrayList<String> listaconcatenada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);

        listperson = (ListView) findViewById(R.id.listperson);

        GetListPerson();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaconcatenada);

        listperson.setAdapter(adp);

        listperson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(getApplicationContext(),  listaconcatenada.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetListPerson() {
        SQLiteDatabase db = conexion.getReadableDatabase(); //Base de datos en modo de lectura
        Persona listpersonas = null;

        lista = new ArrayList<Persona>(); //Lista de objetos del tipo personas

        Cursor cursor = db.rawQuery(Transacciones.GetPersonas, null);

        while(cursor.moveToNext()){
            listpersonas = new Persona();
            listpersonas.setId(cursor.getInt(0));
            listpersonas.setNombre(cursor.getString(1));
            listpersonas.setApellidos(cursor.getString(2));
            listpersonas.setEdad(cursor.getInt(3));
            listpersonas.setCorreo(cursor.getString(4));

            lista.add(listpersonas);

            cursor.close();

            LlenarLista();
        }
    }

    private void LlenarLista (){
        listaconcatenada = new ArrayList<String>();

        for(int i = 0;i < lista.size();i++){
            listaconcatenada.add(lista.get(i).getNombre() + " " +
                    lista.get(i).getApellidos() + " " +
                    lista.get(i).getCorreo());
        }
    }
}