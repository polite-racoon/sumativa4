package model;

public class Cliente {
  private String cedula;
  private String nombre;
  private boolean vigente;

  public Cliente(String cedula, String nombre, boolean vigente) {
    this.cedula = cedula;
    this.nombre = nombre;
    this.vigente = vigente;
  }

  // getters
  public String getCedula() {
    return cedula;
  }
  
  public String getNombre() {
    return nombre;
  }

  public boolean isVigente() {
    return vigente;
  }

  // setters
  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setVigente(boolean vigente) {
    this.vigente = vigente;
  }

}
