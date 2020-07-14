package com.devonfw.microservice.parking.general.common.api.to.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que define los vehículos de tipo coche
 *
 * @author fnvaraon
 *
 */
public class Coche extends Vehiculo {
  private static Logger log = LoggerFactory.getLogger(Coche.class);

  /**
   * Constructor por defecto The constructor.
   */
  public Coche() {

    super();
    log.debug("Se crea un coche");
  }

  /**
   * Método al que se llama cuando se le concede el acceso al parking a un coche
   */
  @Override
  protected void accesoPermitidoEnParking() {

    log.debug("Acceso al parking concedido para un coche");
    entrarParking();
    log.info("BROOM ! BROOM !, mi color es " + getColorVehiculo() + " y puedo entrar en el parking.");
  }

  /**
   * Método por el que un coche solicita acceso al parking
   *
   * @param parking el parking en el que se quiere entrar
   */
  @Override
  public void entrarAlParking(Parking parking) {

    log.debug("Soy un coche y voy a intentar entrar al parking");
    Respuesta respuesta = parking.solicitarAcceso(this);
    if (respuesta == Respuesta.SI) {
      accesoPermitidoEnParking();
    } else { // respuesta == Respuesta.NO
      accesoDenegadoEnParking();
    }
  }

  /**
   * Método al que se llama cuando se va a salir del parking
   *
   * @param parking el parking del que se va a salir
   */
  @Override
  public void salirDelParking(Parking parking) {

    log.debug("Soy un coche y voy a salir del parking");
    parking.addPlazasLibresCoches();
    salirParking();
  }

  @Override
  public String toString() {

    return "Coche " + super.toString();
  }

}
