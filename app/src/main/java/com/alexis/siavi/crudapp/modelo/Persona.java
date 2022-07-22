package com.alexis.siavi.crudapp.modelo;

import android.content.Context;
import android.database.Cursor;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private String correo;

    public void guardarPersona(Context mc){
        TiendaSQLHelper tiendaSQLHelper = new TiendaSQLHelper(mc);
        String sql;
        sql="INSERT INTO persona(id,nombres,apellidos,correo)";
        sql+="VALUES('"+getId()+"','"+getNombre()+"','"+getApellido()+"','"+getCorreo()+"')";
        tiendaSQLHelper.getWritableDatabase().execSQL(sql);
    }

    public static Cursor listarPersona(Context mc){

        TiendaSQLHelper tiendaSQLHelper =new TiendaSQLHelper(mc);
        String sql= "select _rowid_ as _id, id,nombres,apellidos,correo from persona";
        return tiendaSQLHelper.getReadableDatabase().rawQuery(sql,null);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
