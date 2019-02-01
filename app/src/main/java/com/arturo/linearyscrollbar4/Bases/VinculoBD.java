package com.arturo.linearyscrollbar4.Bases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class VinculoBD {

    private ObtenerBD bd;
    protected SQLiteDatabase bdWaifu;

    public VinculoBD() {
    }

    public VinculoBD(Context context) {
        this.bd = ObtenerBD.getInstance(context);
    }

    protected void open() {
        bd.open();
        this.bdWaifu = bd.obtenermiBD();
    }

    protected void close() {
        bd.close();
    }


}
