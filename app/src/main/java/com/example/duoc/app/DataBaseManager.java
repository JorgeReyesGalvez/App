package com.example.duoc.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Duoc on 28-10-2016.
 */
public class DataBaseManager {
    public static final String TABLE_NAME="contactos";
    //ID del registro de la tabla
    public static final String CN_ID="_id";
    public static final String CN_NAME="nombre";
    public static final String CN_PHONE="telefono";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            +CN_ID+ " integer primary key autoincrement,"
            +CN_NAME+ " tex not null,"
            +CN_PHONE+ " text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();

    }

    private ContentValues generarContentValues(String nom,String tele){
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME,nom);
        valores.put(CN_PHONE,tele);

        return  valores;
    }

    public void InsertarRegistro(String nom,String tele){
        db.insert(TABLE_NAME, null, generarContentValues(nom, tele));
    }

    /*public void InsertarRegistroExecSQL(String nom,String tele){
        db.execSQL("insert into "+TABLE_NAME+" values(null,'"+nom+"','"+CN_PHONE+"')");
    }*/

    public void EliminarRegistro(String nom){
        db.delete(TABLE_NAME,CN_NAME+"=?",new String[]{nom});
    }

    /*public void EliminarMultiplesRegistros(String nom,String nom2){
        db.delete(TABLE_NAME,CN_NAME+"in (?,?)",new String[]{nom,nom2});
    }*/

    public void ModificarRegistroTelefono(String nom,String nuevoTelefono){
        db.update(TABLE_NAME,generarContentValues(nom,nuevoTelefono),CN_NAME+"=?",new String[]{nom});
    }

    public Cursor cargarCursorRegistro(){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_PHONE};

        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }

    public Cursor BuscarContacto(String nom){
        String[] columnas= new String[]{CN_ID,CN_NAME,CN_PHONE};

        return db.query(TABLE_NAME,columnas,CN_NAME+"=?",new String[]{nom},null,null,null);

    }



}
