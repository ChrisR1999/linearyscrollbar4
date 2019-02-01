package com.arturo.linearyscrollbar4.Controladores;

import android.content.Context;
import android.database.Cursor;

import com.arturo.linearyscrollbar4.Bases.VinculoBD;
import com.arturo.linearyscrollbar4.Modelos.ModeloRespuestas;
import com.arturo.linearyscrollbar4.Modelos.ModeloRutas;

public class ControladorRutas extends VinculoBD {

    public ControladorRutas() {
        super();
    }

    public ControladorRutas(Context context) {
        super(context);
    }

    public ModeloRutas obtenerPosiblesRespuestasParaMonita(int dia, int ruta) {
        open();
        final ModeloRutas modelo = new ModeloRutas();
        final Cursor cursor = bdWaifu.rawQuery(
                "SELECT frasees, " +
                        "preguntaes, respuestaes, " +
                        "respuesta2es, respuesta3es " +
                        "FROM juego " +
                        "WHERE dia = ? AND ruta = ?",
                new String[]{
                        String.valueOf(dia),
                        String.valueOf(ruta)
                });
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modelo.setFrasees(cursor.getString(0));
                modelo.setPreguntases(cursor.getString(1));
                modelo.setRespuestaes(cursor.getString(2));
                modelo.setRespuesta2es(cursor.getString(3));
                modelo.setRespuesta3es(cursor.getString(4));
                cursor.moveToNext();
            }
            cursor.close();
            close();
            return modelo;
        } else {
            return null;
        }

    }

    public ModeloRespuestas obtenerPosiblesRespuestasParaUsuario(int dia, int ruta, int respuesta) {
        open();
        final Cursor cursor;
        final String consultaSQL;
        final ModeloRespuestas modelo = new ModeloRespuestas();
        final String[] valoresWhere = {
                String.valueOf(dia),
                String.valueOf(ruta)
        };

        switch (respuesta) {
            case 1:
                consultaSQL =
                        "SELECT resp1, respreges " +
                                "FROM respuestas " +
                                "WHERE dia = ? AND ruta = ?";

                break;
            case 2:
                consultaSQL =
                        "SELECT resp2, respreges2 " +
                                "FROM respuestas " +
                                "WHERE dia = ? AND ruta = ?";
                break;
            case 3:
                consultaSQL =
                        "SELECT resp3, respreges3 " +
                                "FROM respuestas " +
                                "WHERE dia = ? AND ruta = ?";
                break;
            default:
                consultaSQL = "SELECT * " +
                        "FROM respuestas";
                break;


        }

        cursor = bdWaifu.rawQuery(consultaSQL, valoresWhere);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                modelo.setIdRespuesta(cursor.getInt(0));
                modelo.setRespuestaWaifu(cursor.getString(1));
                cursor.moveToNext();
            }
            cursor.close();
            close();
            return modelo;
        } else {
            return null;
        }

    }
}
