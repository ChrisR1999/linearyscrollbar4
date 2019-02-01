package com.arturo.linearyscrollbar4;

class Informacion {

    private  String NombreUsuario;
    private int ruta;
    private int dia;
    private String fechaanterior;
    private String fechahoy;

    public String getFechaanterior() {
        return fechaanterior;
    }

    public void setFechaanterior(String fechaanterior) {
        this.fechaanterior = fechaanterior;
    }

    public String getFechahoy() {
        return fechahoy;
    }

    public void setFechahoy(String fechahoy) {
        this.fechahoy = fechahoy;
    }



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




    public void setNombreUsuario(String nombreUsuario, int ruta, int dia, String fechaanterior, String fechahoy) {
        NombreUsuario = nombreUsuario;
        this.ruta = ruta;
        this.dia = dia;
        this.fechaanterior = fechaanterior;
        this.fechahoy = fechahoy;
    }

}
