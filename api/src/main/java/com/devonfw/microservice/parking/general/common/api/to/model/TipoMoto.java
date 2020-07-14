package com.devonfw.microservice.parking.general.common.api.to.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enumerado que almacena las distintas marcas de Moto
 *
 * @author fnvaraon
 *
 */
public enum TipoMoto {
  HARLEY, DUCATI;

  private static Logger log = LoggerFactory.getLogger(TipoMoto.class);

  private static Random r;

  static {
    try {
      r = SecureRandom.getInstanceStrong();
    } catch (NoSuchAlgorithmException e) {
      log.error("Error creando el valor aleatorio", e);
    }
  }

  /**
   * Devuelve el tipo de Moto a asignar a un vehículo moto
   *
   * @return TipoMoto devuelve un tipo de moto, cogido de forma aleatoria
   */
  public static TipoMoto determinarTipo() {

    log.debug("Se genera de forma aleatoria el tipo de moto");
    int aleatorio = r.nextInt(2);

    if (aleatorio == 0) {
      return TipoMoto.HARLEY;
    } else {
      return TipoMoto.DUCATI;
    }
  }

  public static TipoMoto fromStringToTipoMoto(String arg) {

    log.debug("Se devuelve el tipo de moto correspondiente al string recibido");
    TipoMoto tipo;

    switch (arg) {
      case "HARLEY":
        tipo = TipoMoto.HARLEY;
        return tipo;
      case "DUCATI":
        tipo = TipoMoto.DUCATI;
        return tipo;
      default: // HARLEY
        tipo = TipoMoto.HARLEY;
        return tipo;
    }
  }
}
