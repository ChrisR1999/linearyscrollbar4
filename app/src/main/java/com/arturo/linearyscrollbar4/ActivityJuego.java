package com.arturo.linearyscrollbar4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arturo.linearyscrollbar4.Controladores.ControladorRutas;
import com.arturo.linearyscrollbar4.Modelos.ModeloRespuestas;
import com.arturo.linearyscrollbar4.Modelos.ModeloRutas;

public class ActivityJuego extends AppCompatActivity {
    private TextView txtDia;
    private TextView txtRuta;
    private TextView txtFrase;
    private TextView txtPregunta;
    private LinearLayout linearBotones;
    private ControladorRutas controlador;
    private ModeloRutas modelo;
    private ModeloRespuestas modeloRespuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        initComponents();
        colocarTexto(0);
        generarBotonesRespuesta();
    }

    private void initComponents() {
        txtDia = (TextView) findViewById(R.id.txtDia);
        txtRuta = (TextView) findViewById(R.id.txtRuta);
        txtFrase = (TextView) findViewById(R.id.txtFrase);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        linearBotones = (LinearLayout) findViewById(R.id.linearBotones);
        controlador = new ControladorRutas(this);
        modelo = controlador
                .obtenerPosiblesRespuestasParaMonita(
                        Informacion.dia,
                        Informacion.ruta
                );
        txtDia.setText("Dia: " + String.valueOf(Informacion.dia));
        txtRuta.setText("Ruta: " + String.valueOf(Informacion.ruta));
    }

    private void colocarTexto(int opc) {
        switch (opc) {
            case 0:
                if (modelo != null) {
                    txtFrase.setText(modelo.getFrasees());
                    txtPregunta.setText(modelo.getPreguntases());
                }
                break;
            case 1:
                if (modeloRespuestas != null) {
                    txtPregunta.setText("");
                    txtFrase.setText(modeloRespuestas.getRespuestaWaifu());
                }
                break;
        }
    }

    private void generarBotonesRespuesta() {

        if (modelo.getRespuestaes() != null) {
            final Button respuestaUno = new Button(this);
            respuestaUno.setText(modelo.getRespuestaes());
            respuestaUno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int ID_RESPUESTA = 1;
                    //Enviar el ID
                    modeloRespuestas = controlador.
                            obtenerPosiblesRespuestasParaUsuario(
                                    Informacion.dia,
                                    Informacion.ruta,
                                    ID_RESPUESTA
                            );
                    colocarTexto(1);
                }
            });
            linearBotones.addView(respuestaUno);
        }
        if (modelo.getRespuesta2es() != null) {
            final Button respuestaDos = new Button(this);
            respuestaDos.setText(modelo.getRespuesta2es());
            respuestaDos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int ID_RESPUESTA = 2;
                    //Enviar el ID
                    modeloRespuestas = controlador.
                            obtenerPosiblesRespuestasParaUsuario(
                                    Informacion.dia,
                                    Informacion.ruta,
                                    ID_RESPUESTA
                            );
                    colocarTexto(1);
                }
            });
            linearBotones.addView(respuestaDos);
        }
        if (modelo.getRespuesta3es() != null) {
            final Button respuestaTres = new Button(this);
            respuestaTres.setText(modelo.getRespuesta3es());
            respuestaTres.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int ID_RESPUESTA = 3;
                    //Enviar el ID
                    modeloRespuestas = controlador.
                            obtenerPosiblesRespuestasParaUsuario(
                                    Informacion.dia,
                                    Informacion.ruta,
                                    ID_RESPUESTA
                            );
                    colocarTexto(1);
                }
            });
            linearBotones.addView(respuestaTres);
        }
    }
}
