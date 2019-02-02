package com.arturo.linearyscrollbar4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.arturo.linearyscrollbar4.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Menu extends AppCompatActivity {

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }


    public void visitar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void visitar2(View view) {
        log();

    }


    public void log (){

        SharedPreferences shard = getSharedPreferences("Preferencias",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shard.edit();
        Date d = new Date();
        String fechaanterior = "01/01/2019";//shard.getString("fechaanterior","Master");
        String fechahoy =  "02/01/2019";//""+ DateFormat.format("dd/MM/yyyy ", d.getTime());

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





        //SharedPreferences.Editor editor = shard.edit(); este crea los shred no se si para editarlo sea asi
        if(days == 0){


        }
        else{
            if(days == -1){

               // int z=Integer.parseInt(shard.getString("MiDia","Master"));
               // editor.putInt("MiDia", 1 );
                Intent intent = new Intent(this, ActivityJuego.class);
                startActivity(intent);

                editor.putInt("MiDia", 5);
               // String si = shard.getString("MiDia","Master");
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "",Toast.LENGTH_SHORT);
                //toast1.show();

            }
            else if(days < -1){
                editor.putInt("MiRuta", 2);
                editor.putInt("MiDia", 1);
                Intent intent = new Intent(this, ActivityJuego.class);
                startActivity(intent);
            }
        }
    }
}
