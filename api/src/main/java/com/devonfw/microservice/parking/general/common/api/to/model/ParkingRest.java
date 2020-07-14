package com.devonfw.microservice.parking.general.common.api.to.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fnvaraon POJO class for receive Parking's objets
 *
 */
public class ParkingRest {

  private static final Logger log = LoggerFactory.getLogger(ParkingRest.class);

  private static final int MAX_PLAZAS_COCHES = 20;

  private static final int MAX_PLAZAS_MOTOS = 15;

  private static final int MAX_PLAZAS_BICICLETAS = 10;

  private static final String COLOR_POR_DEFECTO = "AZUL";

  private String nombreParking;

  private int plazasCoches;

  private int plazasMotos;

  private int plazasBicicletas;

  private String color;

  /**
   * The constructor.
   */
  public ParkingRest() {

    log.debug("Creando nueva instancia de ParkingRest sin argumentos");
    this.nombreParking = "nuevoParking";
    this.plazasCoches = MAX_PLAZAS_COCHES;
    this.plazasMotos = MAX_PLAZAS_MOTOS;
    this.plazasBicicletas = MAX_PLAZAS_BICICLETAS;
    this.color = COLOR_POR_DEFECTO;

  }

  /**
   * The constructor.
   *
   * @param nombreParking
   * @param plazasCoches
   * @param plazasMotos
   * @param plazasBicicletas
   * @param color
   */
  public ParkingRest(String nombreParking, int plazasCoches, int plazasMotos, int plazasBicicletas, String color) {

    super();
    this.nombreParking = nombreParking;
    this.plazasCoches = plazasCoches;
    this.plazasMotos = plazasMotos;
    this.plazasBicicletas = plazasBicicletas;
    this.color = color;
    log.debug("Creando nueva instancia de ParkingRest con todos los argumentos");
  }

  /**
   * @return nombreParking
   */
  public String getNombreParking() {

    log.debug("Obteniendo el nombre");
    return this.nombreParking;
  }

  /**
   * @param nombreParking new value of {@link #getnombreParking}.
   */
  public void setNombreParking(String nombreParking) {

    log.debug("Estableciendo el nombre");
    this.nombreParking = nombreParking;
  }

  /**
   * @return color
   */
  public String getColor() {

    log.debug("Obteniendo el color");
    return this.color;
  }

  /**
   * @param color new value of {@link #getcolor}.
   */
  public void setColor(String color) {

    log.debug("Estableciendo el color");
    this.color = color;
  }

  /**
   * @return plazasCoches
   */
  public int getPlazasCoches() {

    log.debug("Obteniendo el número de plazasCoches");
    return this.plazasCoches;
  }

  /**
   * @param plazasCoches new value of {@link #getplazasCoches}.
   */
  public void setPlazasCoches(int plazasCoches) {

    log.debug("Estableciendo el número de plazasCoches");
    this.plazasCoches = plazasCoches;
  }

  /**
   * @return plazasMotos
   */
  public int getPlazasMotos() {

    log.debug("Obteniendo el número de plazasMotos");
    return this.plazasMotos;
  }

  /**
   * @param plazasMotos new value of {@link #getplazasMotos}.
   */
  public void setPlazasMotos(int plazasMotos) {

    log.debug("Estableciendo el número de plazasMotos");
    this.plazasMotos = plazasMotos;
  }

  /**
   * @return plazasBicicletas
   */
  public int getPlazasBicicletas() {

    log.debug("Obteniendo el número de plazasBicicletas");
    return this.plazasBicicletas;
  }

  /**
   * @param plazasBicicletas new value of {@link #getplazasBicicletas}.
   */
  public void setPlazasBicicletas(int plazasBicicletas) {

    log.debug("Estableciendo el número de plazasBicicletas");
    this.plazasBicicletas = plazasBicicletas;
  }

  /**
   *
   */
  @Override
  public String toString() {

    log.debug("Imprimiendo el objeto ParkingRest");
    return "ParkingRest [nombreParking=" + this.nombreParking + ", plazasCoches=" + this.plazasCoches + ", plazasMotos="
        + this.plazasMotos + ", plazasBicicletas=" + this.plazasBicicletas + ", color=" + this.color + "]";
  }

  /**
   *
   */
  @Override
  public boolean equals(Object obj) {

    log.debug("comparando la igualdad de objetos ParkingRest");
    ParkingRest parkingRest = (ParkingRest) obj;

    return (getNombreParking().equals(parkingRest.getNombreParking()) && getColor().equals(parkingRest.getColor())
        && getPlazasCoches() == parkingRest.getPlazasCoches() && getPlazasMotos() == parkingRest.getPlazasMotos()
        && getPlazasBicicletas() == parkingRest.getPlazasBicicletas());

  }
}
