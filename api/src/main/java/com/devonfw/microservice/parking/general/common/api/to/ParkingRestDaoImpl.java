package com.devonfw.microservice.parking.general.common.api.to;

import java.util.LinkedList;
import java.util.List;

import com.devonfw.microservice.parking.general.common.api.ParkingRestDao;
import com.devonfw.microservice.parking.general.common.api.to.model.Bicicleta;
import com.devonfw.microservice.parking.general.common.api.to.model.Coche;
import com.devonfw.microservice.parking.general.common.api.to.model.ColorVehiculo;
import com.devonfw.microservice.parking.general.common.api.to.model.Moto;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

/**
 * @author fnvaraon
 *
 */
public class ParkingRestDaoImpl implements ParkingRestDao {

  /**
   * The constructor.
   */
  public ParkingRestDaoImpl() {

  }

  /**
   *
   */
  @Override
  public List<Vehiculo> vehiculos(Parking parking) {

    if (parking == null) {
      return null;
    }
    return parking.getVehiculos();
  }

  /**
   *
   */
  @Override
  public List<Coche> coches(Parking parking) {

    List<Coche> coches = new LinkedList<>();
    if (parking == null) {
      return null;
    }
    for (Vehiculo vehiculo : parking.getVehiculos()) {
      if (vehiculo instanceof Coche) {
        coches.add((Coche) vehiculo);
      }
    }
    return coches;
  }

  /**
   *
   */
  @Override
  public List<Moto> motos(Parking parking) {

    List<Moto> motos = new LinkedList<>();
    if (parking == null) {
      return null;
    }
    for (Vehiculo vehiculo : parking.getVehiculos()) {
      if (vehiculo instanceof Moto) {
        motos.add((Moto) vehiculo);
      }
    }
    return motos;
  }

  /**
   *
   */
  @Override
  public List<Bicicleta> bicicletas(Parking parking) {

    List<Bicicleta> bicicletas = new LinkedList<>();
    if (parking == null) {
      return null;
    }
    for (Vehiculo vehiculo : parking.getVehiculos()) {
      if (vehiculo instanceof Bicicleta) {
        bicicletas.add((Bicicleta) vehiculo);
      }
    }
    return bicicletas;
  }

  /**
   *
   */
  @Override
  public int numVehiculosColorX(Parking parking, String color) {

    if (parking == null) {
      return 0;
    }

    ColorVehiculo colorVehiculo;

    switch (color) {
      case "AZUL":
        colorVehiculo = ColorVehiculo.AZUL;
        break;
      case "BLANCO":
        colorVehiculo = ColorVehiculo.BLANCO;
        break;
      case "NEGRO":
        colorVehiculo = ColorVehiculo.NEGRO;
        break;
      default: // ROSA
        colorVehiculo = ColorVehiculo.ROSA;
        break;
    }

    return parking.numeroVehiculosColorX(colorVehiculo);
  }

}
