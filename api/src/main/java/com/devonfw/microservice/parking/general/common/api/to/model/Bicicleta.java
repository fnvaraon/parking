package com.devonfw.microservice.parking.general.common.api.to.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que define los vehículos de tipo bicicleta
 *
 * @author fnvaraon
 *
 */
public class Bicicleta extends Vehiculo {
  private static Logger log = LoggerFactory.getLogger(Bicicleta.class);

  /**
   * Constructor sin argumentos The constructor.
   */
  public Bicicleta() {

    super();
    log.debug("Se crea una bicicleta");
  }

  /**
   * Método por el que una bicicleta solicita acceso al parking
   *
   * @param parking el parking en el que se quiere entrar
   */
  @Override
  public void entrarAlParking(Parking parking) {

    log.debug("Soy una bicicleta y voy a intentar entrar al parking");
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

    log.debug("Soy una bicicleta y voy a salir del parking");
    parking.addPlazasLibresBicicletas();
    salirParking();
  }

  @Override
  public String toString() {

    return "Bicicleta " + super.toString();
  }

}
