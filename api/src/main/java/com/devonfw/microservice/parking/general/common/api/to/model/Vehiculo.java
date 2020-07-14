package com.devonfw.microservice.parking.general.common.api.to.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fnvaraon
 *
 */
public abstract class Vehiculo {
  private static Logger log = LoggerFactory.getLogger(Vehiculo.class);

  private ColorVehiculo colorVehiculo;

  private boolean aceptadoParking;

  /**
   * The constructor.
   */
  public Vehiculo() {

    log.debug("Se crea un veh�culo");
    this.colorVehiculo = ColorVehiculo.pintar();
    this.aceptadoParking = false;
  }

  /**
   * @return
   */
  public ColorVehiculo getColorVehiculo() {

    log.debug("Devuelve el color del veh�culo");
    return this.colorVehiculo;
  }

  /**
   * @param colorVehiculo
   */
  public void setColorVehiculo(ColorVehiculo colorVehiculo) {

    this.colorVehiculo = colorVehiculo;
  }

  /**
   * @param aceptadoParking new value of {@link #getaceptadoParking}.
   */
  public void setAceptadoParking(boolean aceptadoParking) {

    this.aceptadoParking = aceptadoParking;
  }

  /**
   * @return
   */
  public boolean isAceptadoParking() {

    return this.aceptadoParking;
  }

  /**
   *
   */
  protected void salirParking() {

    log.debug("Se pone aceptadoParking a false");
    this.aceptadoParking = false;
  }

  /**
   *
   */
  protected void entrarParking() {

    log.debug("Se pone aceptadoParking a true");
    this.aceptadoParking = true;
  }

  /**
   *
   */
  protected void accesoPermitidoEnParking() {

    log.debug("Acceso al parking concedido");
    entrarParking();
    log.info("Genial, puedo entrar en el parking.");
  }

  /**
   *
   */
  protected void accesoDenegadoEnParking() {

    log.debug("Acceso al parking denegado");
    salirParking();
    log.info("Maldita sea!, no puede entrar en el parking.");
  }

  @Override
  public String toString() {

    return " [colorVehiculo=" + this.colorVehiculo + ", aceptadoParking=" + this.aceptadoParking + "]";
  }

  /**
   * @param parking
   */
  public abstract void entrarAlParking(Parking parking);

  /**
   * @param parking
   */
  public abstract void salirDelParking(Parking parking);

}