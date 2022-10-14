package com.example.pm01p32022.tablas;


//CLASE que crea la base de datos
public class Transacciones {

    //Nombre de la base de datos
    public static final String NameDatabase = "PM01DB";

    /* Creacion de las tablas de la DB*/
    public static final String TbPersonas = "personas";

    /* Creacion de los campos de la tabla*/
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    //DDL: Crea,elimina Tablas
    public static final String CTPersonas = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " nombre TEXT, apellidos TEXT, edad INTEGER, correo TEXT)";

    public static final String GetPersonas = "SELECT * FROM " +Transacciones.TbPersonas;

    public static final String DropTPersonas = "DROP TABLE IF EXISTS personas";

}
