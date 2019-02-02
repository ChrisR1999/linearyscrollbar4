package com.arturo.linearyscrollbar4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arturo.linearyscrollbar4.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Menu extends AppCompatActivity {

    Context context = this;
    Button boton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        boton =(Button) findViewById(R.id.btnjugar);
      log();
    }


    public void visitar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void visitar2(View view) {
        Intent intent = new Intent(this, ActivityJuego.class);
        startActivity(intent);
    }


    public void log (){

        SharedPreferences shard = getSharedPreferences("Preferencias",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shard.edit();
        Date d = new Date();
        String fechaanterior = shard.getString("fechaanterior","Master");
        String fechahoy =  DateFormat.format("dd/MM/yyyy ", d.getTime()).toString();
        Informacion.ruta = Integer.parseInt(shard.getString("MiRuta","Master"));
        Informacion.dia = Integer.parseInt(shard.getString("MiDia","Master"));

        Date fechaant = Calendar.getInstance().getTime();
        Date Fecha = Calendar.getInstance().getTime();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // here set the pattern as you date in string was containing like date/month/year
            fechaant = sdf.parse(fechaanterior);
            Fecha = sdf.parse(fechahoy);
        } catch (ParseException ex) {
            // handle parsing exception if date string was different from the pattern applying into the SimpleDateFormat contructor
        }
        long diff = fechaant.getTime() - Fecha.getTime();
        long days = (diff / (1000 * 60 * 60 * 24)) % 365;

        if(days == 0){

            boton.setBackgroundColor(getResources().getColor(R.color.amarillo));

        }
        else{
            if(days == -1){

                boton.setBackgroundColor(getResources().getColor(R.color.verde));
                int z=Integer.parseInt(shard.getString("MiDia","Master"));
                z++;
                editor.putString("MiDia", z+"");
            }
            else if(days < -1){
                boton.setBackgroundColor(getResources().getColor(R.color.rojo));
                editor.putString("MiRuta", "2");
                editor.putString("MiDia", "1");

            }
        }
    }

    public void DiaExtra(View view){
        SharedPreferences shard = getSharedPreferences("Preferencias",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shard.edit();
        int z=Integer.parseInt(shard.getString("MiDia","Master"));
        z=z+2;
        String zs = String.valueOf(z);
        editor.remove("MiDia");
        editor.putString("MiDia",zs);
        SharedPreferences shard2 = getSharedPreferences("Preferencias",context.MODE_PRIVATE);
        Informacion.dia = Integer.parseInt(shard2.getString("MiDia","Master"));
        boton.setBackgroundColor(getResources().getColor(R.color.verde));
    }
}
