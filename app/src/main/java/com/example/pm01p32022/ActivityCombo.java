package com.example.pm01p32022;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pm01p32022.configuracion.SQLiteConexion;
import com.example.pm01p32022.tablas.Persona;
import com.example.pm01p32022.tablas.Transacciones;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    /*Variables globales*/

    SQLiteConexion conexion;
    Spinner sppersonas;
    EditText nombres, apellidos, correo;

    ArrayList<Persona> lista;
    ArrayList<String> listString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        sppersonas = (Spinner) findViewById(R.id.sppersonas);
        nombres = (EditText) findViewById(R.id.txtnombres_ac);
        apellidos = (EditText) findViewById(R.id.txtapellidos_ac);
        correo = (EditText) findViewById(R.id.txtcorreo_ac);

        ObtenerPersonas();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listString);
        sppersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                    nombres.setText(lista.get(i).getNombre());
                    apellidos.setText(lista.get(i).getApellidos());
                    correo.setText(lista.get(i).getCorreo());

                }catch(Exception ex){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void ObtenerPersonas(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Persona listaPersonas = null;
        lista = new ArrayList<Persona>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Transacciones.TbPersonas, null);

        while(cursor.moveToNext()){
            listaPersonas = new Persona();
            listaPersonas.setId(cursor.getInt(0));
            listaPersonas.setNombre(cursor.getString(1));
            listaPersonas.setApellidos(cursor.getString(2));
            listaPersonas.setEdad(cursor.getInt(3));
            listaPersonas.setCorreo(cursor.getString(4));

            lista.add(listaPersonas);
        }
        cursor.close();
        fillcombo();
    }

    private void fillcombo(){
        listString = new ArrayList<String>();

        for(int i = 0; i < lista.size();i++){
            listString.add(lista.get(i).getNombre() + " " +
                    lista.get(i).getApellidos() + " " +
                    lista.get(i).getCorreo());
        }
    }
}