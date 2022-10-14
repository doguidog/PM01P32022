package com.example.pm01p32022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm01p32022.configuracion.SQLiteConexion;
import com.example.pm01p32022.tablas.Transacciones;


//CLASE que captura los datos ingresados del activity_ingresar y los almacena en la base de datos
public class ActivityIngresar extends AppCompatActivity {
    //Creacion de variables
    Button btnagregar;
    EditText nombres, apellidos, edad, correo;

    //Metodo "config" que castea los elementos por su "ID"
    private void config(){
        nombres = (EditText) findViewById(R.id.ai_nombre);
        apellidos = (EditText) findViewById(R.id.textapellido);
        edad = (EditText) findViewById(R.id.ai_edad);
        correo = (EditText) findViewById(R.id.ai_correo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        //Llamado del metodo "config"
        config();

        //Boton agregar a la base de datos con evento "OnClickListener" y ejecuta el metodo "AgregarPersonas"
        btnagregar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AgregarPersonas();
            }
        }
        );
    }

    //Metodo generico que agrega las personas
    private void AgregarPersonas() {

        SQLiteConexion conexion = new SQLiteConexion( this, Transacciones.NameDatabase, null,1 );
        SQLiteDatabase db = conexion.getWritableDatabase();

        //Esta clase se utiliza para almacenar un conjunto de valores que ContentResolver puede procesar.
        ContentValues valores = new ContentValues();

        /*Se almacena en valores cada valor que se ingreso en los campos, primero capturandolos y
         luego castearlos a String*/

        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());

        //Variable Long que almacena el ID que ejecuto el Query ingresar del registro para mostrarlo en el Toast.makeText()
        Long resultado = db.insert(Transacciones.TbPersonas, Transacciones.id, valores);

        /*Crea una instancia de un objeto de aviso
        Usa el método makeText(), que toma los siguientes parámetros:

        -La aplicación de Context
        -El texto que se debe mostrar al usuario
        -La duración en pantalla del aviso

        El método makeText() muestra un objeto Toast inicializado de forma correcta.*/

        Toast.makeText(getApplicationContext(), "Registro Ingresado " + resultado.toString()
        , Toast.LENGTH_SHORT).show();

        //Se cierra la conexion "db"
        db.close();

        //Llamado del metodo "ClearScreen"
        ClearScreen();
    }

    //Metodo generico que limpia los campos
    private void ClearScreen(){
        nombres.setText(" ");
        apellidos.setText(" ");
        edad.setText(" ");
        correo.setText(" ");
    }
}