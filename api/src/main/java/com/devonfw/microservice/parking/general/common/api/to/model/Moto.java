package com.devonfw.microservice.parking.general.common.api.to.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fnvaraon
 *
 */
public class Moto extends Vehiculo {
  private static Logger log = LoggerFactory.getLogger(Moto.class);

  private TipoMoto tipoMoto;

  /**
   *
   * The constructor.
   */
  public Moto() {

    super();
    this.tipoMoto = TipoMoto.determinarTipo();
    log.debug("Se crea una moto");
  }

  /**
   *
   * @return type of moto
   */
  public TipoMoto getTipoMoto() {

    return this.tipoMoto;
  }

  /**
   *
   * @param tipoMoto type of moto
   */
  public void setTipoMoto(TipoMoto tipoMoto) {

    this.tipoMoto = tipoMoto;
  }

  /**
   *
   */
  @Override
  protected void accesoPermitidoEnParking() {

    log.debug("Acceso al parking concedido para una moto");
    entrarParking();
    log.info("YUPI! Mi color es " + getColorVehiculo() + " y puedo entrar en el parking.");
  }

  /**
   *
   */
  @Override
  protected void accesoDenegadoEnParking() {

    log.debug("Acceso al parking denegado para una moto");
    salirParking();
    log.info("Hey!, soy una " + getTipoMoto() + " y vais a lamentar no haberme dejado pasar.");
  }

  /**
   *
   */
  @Override
  public void entrarAlParking(Parking parking) {

    log.debug("Soy una moto y voy a intentar entrar al parking");
    Respuesta respuesta = parking.solicitarAcceso(this);
    if (respuesta == Respuesta.SI) {
      accesoPermitidoEnParking();
    } else { // respuesta == Respuesta.NO
      accesoDenegadoEnParking();
    }
  }

  /**
   *
   */
  @Override
  public void salirDelParking(Parking parking) {

    log.debug("Soy una moto y voy a salir del parking");
    parking.addPlazasLibresMotos();
    salirParking();
  }

  @Override
  public String toString() {

    return "Moto [" + super.toString() + " [tipoMoto=" + this.tipoMoto + "] ]";
  }

}
