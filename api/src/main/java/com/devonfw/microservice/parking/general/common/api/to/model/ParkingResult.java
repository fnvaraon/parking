package com.devonfw.microservice.parking.general.common.api.to.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fnvaraon POJO class for send Parking's objets as result of the service
 */
public class ParkingResult {
  private static final Logger log = LoggerFactory.getLogger(ParkingResult.class);

  private String nombre;

  private List<Coche> listCoches;

  private List<Moto> listMotos;

  private List<Bicicleta> listBicicletas;

  private int numeroVehiculosColorElegido;

  /**
   * The constructor.
   */
  public ParkingResult() {

    log.debug("Instanciando un objeto parkingResult");
    this.nombre = null;
    this.numeroVehiculosColorElegido = 0;
    this.listCoches = null;
    this.listMotos = null;
    this.listBicicletas = null;
  }

  /**
   * @return nombre
   */
  public String getNombre() {

    log.debug("Obteniendo el nombre");
    return this.nombre;
  }

  /**
   * @param nombre new value of {@link #getnombre}.
   */
  public void setNombre(String nombre) {

    log.debug("Estableciendo el nombre del parkingResult");
    this.nombre = nombre;
  }

  /**
   * @return listCoches
   */
  public List<Coche> getListCoches() {

    log.debug("Obteniendo la lista de coches");
    return this.listCoches;
  }

  /**
   * @param listCoches new value of {@link #getlistCoches}.
   */
  public void setListCoches(List<Coche> listCoches) {

    log.debug("Estableciendo el listado de coches");
    this.listCoches = listCoches;
  }

  /**
   * @return listMotos
   */
  public List<Moto> getListMotos() {

    log.debug("Obteniendo la lista de motos");
    return this.listMotos;
  }

  /**
   * @param listMotos new value of {@link #getlistMotos}.
   */
  public void setListMotos(List<Moto> listMotos) {

    log.debug("Estableciendo el listado de motos");
    this.listMotos = listMotos;
  }

  /**
   * @return listBicicletas
   */
  public List<Bicicleta> getListBicicletas() {

    log.debug("Obteniendo la lista de bicicletas");
    return this.listBicicletas;
  }

  /**
   * @param listBicicletas new value of {@link #getlistBicicletas}.
   */
  public void setListBicicletas(List<Bicicleta> listBicicletas) {

    log.debug("Estableciendo el listado de bicicletas");
    this.listBicicletas = listBicicletas;
  }

  /**
   * @return numeroVehiculosColorElegido
   */
  public int getNumeroVehiculosColorElegido() {

    log.debug("Obteniendo el número de vehículos del color elegido");
    return this.numeroVehiculosColorElegido;
  }

  /**
   * @param numeroVehiculosColorElegido new value of {@link #getnumeroVehiculosColorElegido}.
   */
  public void setNumeroVehiculosColorElegido(int numeroVehiculosColorElegido) {

    log.debug("Estableciendo el número de vehículos del color elegido");
    this.numeroVehiculosColorElegido = numeroVehiculosColorElegido;
  }

  @Override
  public String toString() {

    log.debug("Imprimiendo un objeto parkingResult");
    return "ParkingResult [nombre=" + this.nombre + ", listCoches=" + this.listCoches + ", listMotos=" + this.listMotos
        + ", listBicicletas=" + this.listBicicletas + ", numeroVehiculosColorElegido="
        + this.numeroVehiculosColorElegido + "]";
  }

  @Override
  public boolean equals(Object obj) {

    log.debug("Comparando la igualdad entre objetos parkingResult");
    ParkingResult parkingResult = (ParkingResult) obj;
    if (getListCoches() == null && getListMotos() == null && getListBicicletas() == null) {
      return (getNombre().equals(parkingResult.getNombre())
          && getNumeroVehiculosColorElegido() == parkingResult.getNumeroVehiculosColorElegido());
    }
    return (getNombre().equals(parkingResult.getNombre())
        && getNumeroVehiculosColorElegido() == parkingResult.getNumeroVehiculosColorElegido()
        && getListCoches() == parkingResult.getListCoches() && getListMotos() == parkingResult.getListMotos()
        && getListBicicletas() == parkingResult.getListBicicletas());

    // return super.equals(obj);
  }

}
