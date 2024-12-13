package model;

public class Automovil {
    private String patente;
    private char condicion;

    public Automovil(String patente, char condicion) {
        this.patente = patente;
        this.condicion = condicion;
    }

    // getters
    public String getPatente() {
        return patente;
    }

    public char getCondicion() {
        return condicion;
    }

    // setters
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setCondicion(char condicion) {
        this.condicion = condicion;
    }

}
