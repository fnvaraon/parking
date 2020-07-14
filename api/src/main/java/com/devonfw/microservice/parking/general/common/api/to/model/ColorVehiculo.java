package com.devonfw.microservice.parking.general.common.api.to.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fnvaraon
 *
 */
public enum ColorVehiculo {
  AZUL, BLANCO, NEGRO, ROSA;

  private static final int NUMERO_COLORES = 4;

  private static Logger log = LoggerFactory.getLogger(ColorVehiculo.class);

  private static Random r;

  static {
    try {
      r = SecureRandom.getInstanceStrong();
    } catch (NoSuchAlgorithmException e) {
      log.error("Error creando el valor aleatorio", e);
    }
  }

  /**
   *
   * @return a random color
   */
  public static ColorVehiculo pintar() {

    log.debug("Se pinta el vehículo, seleccionando un color de forma aleatoria");

    int aleatorio = r.nextInt(4);

    switch (aleatorio) {
      case 0:
        return ColorVehiculo.AZUL;
      case 1:
        return ColorVehiculo.BLANCO;
      case 2:
        return ColorVehiculo.NEGRO;
      default: // ROSA
        return ColorVehiculo.ROSA;
    }
  }

  /**
   * @param arg
   * @return
   */
  public static ColorVehiculo fromStringToColorVehiculo(String arg) {

    log.debug("Se devuelve el color vehículo correspondiente al string recibido");

    ColorVehiculo color;

    switch (arg) {
      case "AZUL":
        color = ColorVehiculo.AZUL;
        return color;
      case "BLANCO":
        color = ColorVehiculo.BLANCO;
        return color;
      case "NEGRO":
        color = ColorVehiculo.NEGRO;
        return color;
      default: // ROSA
        color = ColorVehiculo.ROSA;
        return color;
    }
  }

  /**
   *
   * @return number of the different types of existing colors
   */
  public static int numColores() {

    return NUMERO_COLORES;
  }
}
