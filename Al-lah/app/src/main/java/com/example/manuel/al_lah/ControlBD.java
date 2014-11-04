package com.example.manuel.al_lah;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Manuel on 14/10/2014.
 */
public class ControlBD {

    public static final String TABLE_NAME = "Asignaturas";
    public static final String CN_ID = "Id";
    public static final String CN_NAME = "Nombre";
    public static final String CN_PROFESOR = "Profesor";
    public static final String CN_AYUDANTE = "Ayudante";
  /*public static final String CN_NOTAS = "Notas"<
    public static final String CN_Horario = "Horario";
    public static final String CN_ICON = "Icono";
    public static final String CN_COLOR = "Color";
     */

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " (" +CN_ID+ "integer primary key autoincrement," +CN_NAME+ "text not null,"
            +CN_PROFESOR+ "text," +CN_AYUDANTE+ "text);";

    public static final String TABLE_NAME2 = "Semestre";
    public static final String CN_ID2 = "Id";
    public static final String CN_NAME2 = "Nombre";

    public static final String CREATE_TABLE2 = "create table " +TABLE_NAME2+ " (" +CN_ID2+ "integer primary key autoincrement,"
            +CN_NAME2+ "text not null);";

    public static final String TABLE_NAME3 = "Notas";
    public static final String CN_ID3 = "Id";
    public static final String CN_NAME3 = "Nombre";
    public static final String CN_NOTA3 = "Nota";
    public static final String CN_PONDERACION3 = "Ponderacion";

    public static final String CREATE_TABLE3 = "create table " +TABLE_NAME3+ " (" +CN_ID3+ "integer primary key autoincrement,"
            +CN_NAME3+ "text not null," +CN_NOTA3+ "integer," +CN_PONDERACION3+ "real);";


    private BDHelper helper;
    private SQLiteDatabase db;

    public ControlBD(Context context) {
        helper = new BDHelper(context);
        db= helper.getWritableDatabase();
    }

    public ContentValues generarCVAsignatura (String nombre, String profesor, String ayudante){
        ContentValues valoresAsignatura = new ContentValues();
        valoresAsignatura.put(CN_NAME,nombre);
        valoresAsignatura.put(CN_PROFESOR,profesor);
        valoresAsignatura.put(CN_AYUDANTE,ayudante);

        return valoresAsignatura;
    }

    public ContentValues generarCVSemestre (String nombre){
        ContentValues valoresSemetre = new ContentValues();
        valoresSemetre.put(CN_NAME2,nombre);
        return valoresSemetre;
    }

    public ContentValues generarCVNotas (String nombre, int nota, float ponderacion){
        ContentValues valoresNotas = new ContentValues();
        valoresNotas.put(CN_NAME3,nombre);
        valoresNotas.put(CN_NOTA3,nota);
        valoresNotas.put(CN_PONDERACION3,ponderacion);
        return valoresNotas;
    }

    //Metodos para agregar
    public void agregarSemestre(String nombre) {
        db.insert(TABLE_NAME2,null,generarCVSemestre(nombre));
    }
    public void agregarAsignatura(String nombre, String profesor, String ayudante) {
        db.insert(TABLE_NAME,null,generarCVAsignatura(nombre, profesor, ayudante));
    }
    public void agregarNotas(String nombre, int nota, float ponderacion) {
        db.insert(TABLE_NAME3,null,generarCVNotas(nombre,nota,ponderacion));
    }
    //Metodos Eliminar
    public void eliminarSemestre(String nombre) {
        db.delete(TABLE_NAME2, CN_NAME2 + "=?", new String[]{nombre});
    }
    public void eliminarAsignatura(String nombre) {
        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{nombre});
    }
    public void eliminarNotas(String nombre) {
        db.delete(TABLE_NAME3, CN_NAME3 + "=?", new String[]{nombre});
    }

    public Cursor cargarCursorAsignatura(){
        String[] columnas = new String[] {CN_ID,CN_NAME,CN_PROFESOR,CN_AYUDANTE};
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }

}
