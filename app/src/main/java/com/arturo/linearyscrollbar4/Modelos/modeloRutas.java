package com.arturo.linearyscrollbar4.Modelos;

public class modeloRutas {

    private String frasees;
    private String preguntases;
    private String respuestaes;
    private String respuesta2es;
    private String respuesta3es;
    private int ruta;
    private int dia;

    public String getFrasees() {
        return frasees;
    }

    public void setFrasees(String frasees) {
        this.frasees = frasees;
    }

    public String getPreguntases() {
        return preguntases;
    }

    public void setPreguntases(String preguntases) {
        this.preguntases = preguntases;
    }

    public String getRespuestaes() {
        return respuestaes;
    }

    public void setRespuestaes(String respuestaes) {
        this.respuestaes = respuestaes;
    }

    public String getRespuesta2es() {
        return respuesta2es;
    }

    public void setRespuesta2es(String respuesta2es) {
        this.respuesta2es = respuesta2es;
    }

    public String getRespuesta3es() {
        return respuesta3es;
    }

    public void setRespuesta3es(String respuesta3es) {
        this.respuesta3es = respuesta3es;
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


    public modeloRutas(){

    }

    public modeloRutas(String frasees, String preguntases,String respuestaes, String respuesta2es, String respuesta3es, int ruta, int dia){

       this.frasees = frasees;
       this.preguntases = preguntases;
       this.respuestaes = respuestaes;
        this.respuesta2es = respuesta2es;
        this.respuesta3es = respuesta3es;
        this.ruta =ruta;
        this.dia = dia;
    }
}
