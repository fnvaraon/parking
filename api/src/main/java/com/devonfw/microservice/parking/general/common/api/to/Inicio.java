package com.devonfw.microservice.parking.general.common.api.to;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devonfw.microservice.parking.general.common.api.to.model.ColorVehiculo;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

/**
 * @author fnvaraon
 *
 */
public class Inicio {

  private static Logger log;

  static {
    log = LoggerFactory.getLogger(Inicio.class);
  }

  // /**
  // * @param arg the color in String
  // * @return the color in type ColorVehiculo
  // */
  // public static ColorVehiculo colorVehiculosAContar(String arg) {
  //
  // ColorVehiculo color;
  //
  // switch (arg) {
  // case "AZUL":
  // color = ColorVehiculo.AZUL;
  // return color;
  // case "BLANCO":
  // color = ColorVehiculo.BLANCO;
  // return color;
  // case "NEGRO":
  // color = ColorVehiculo.NEGRO;
  // return color;
  // default: // ROSA
  // color = ColorVehiculo.ROSA;
  // return color;
  // }
  // }

  /**
   * @param args array of String: parking name, number of car's parking lots, number of motorbike's parking lots, number
   *        of bycicle's parking lots, the color to count
   * @return a parking full of vehicles
   */
  public static Parking rellenarParking(String[] args) {

    log.debug("Se inicia el programa Parking");
    log.debug("Se ha iniciado el programa con " + args.length + " argumentos:");

    Parking miParking = null;
    ColorVehiculo color = null;

    if (args.length <= 2) {
      log.error("Faltan argumentos de entrada al programa");
      System.exit(1);
    } else if (args.length == 3) {
      log.debug("Se ha llamado al programa con el nombre del parking " + args[0]
          + "y el valor de X \"número plazas coches\" " + args[1]);
      log.debug("El color de los vehículos a contar es: " + args[2]);
      try {
        miParking = new Parking(args[0], Integer.parseInt(args[1]));
      } catch (NumberFormatException e) {
        log.error("El argumento 2 " + args[1] + " debe ser un número entero.");
        System.exit(1);
      }
      color = ColorVehiculo.fromStringToColorVehiculo(args[2]);
    } else {
      log.debug(
          "Se ha llamado al programa con el nombre del parking " + args[0] + ", el valor de X \"número plazas coches\" "
              + args[1] + " y el valor de Y \"número de plazas motos\" " + args[2]);
      log.debug("El color de los vehículos a contar es: " + args[3]);

      try {
        miParking = new Parking(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      } catch (NumberFormatException e) {
        log.error("Los argumentos 2 y 3, " + args[1] + " y " + args[2] + " deben ser números enteros.");
        System.exit(1);
      }
      color = ColorVehiculo.fromStringToColorVehiculo(args[3]);
    }

    log.debug("Se van a crear los vehiculos que se meterán en el parking");
    int j = 0;
    while (miParking.getPlazasLibresBicicletas() > 0) {
      j++;
      Vehiculo vehiculo = null;
      vehiculo = miParking.crearVehiculoAleatorio();
      log.debug("Vehículo creado: " + j + " --> " + vehiculo.getClass().getSimpleName());
      log.debug("Vehículo solicita acceso al parking");
      miParking.solicitarAcceso(vehiculo);
    }
    log.debug("Se han creado " + j + " vehiculos.");

    log.info("Tengo " + miParking.numeroVehiculosColorX(color) + " vehículos de color " + color + ".");
    log.debug("Fin del programa Parking.");
    return miParking;
  }

}
