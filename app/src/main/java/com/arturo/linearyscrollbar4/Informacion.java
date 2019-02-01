package com.arturo.linearyscrollbar4;

class Informacion {

    private  String NombreUsuario;
    private int ruta;
    private int dia;

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }




    public void setNombreUsuario(String nombreUsuario, int ruta, int dia) {
        NombreUsuario = nombreUsuario;
        this.ruta = ruta;
        this.dia = dia;
    }

}
