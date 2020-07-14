package com.devonfw.microservice.parking.general.common.api;

import java.util.List;

import com.devonfw.microservice.parking.general.common.api.to.model.Bicicleta;
import com.devonfw.microservice.parking.general.common.api.to.model.Coche;
import com.devonfw.microservice.parking.general.common.api.to.model.Moto;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

/**
 * @author fnvaraon
 *
 */
public interface ParkingRestDao {

  /**
   * @param parking Object parking to extract the list
   * @return List of Vehiculo
   */
  public List<Vehiculo> vehiculos(Parking parking);

  /**
   * @param parking Object parking to extract the list
   * @return List of Coche
   */
  public List<Coche> coches(Parking parking);

  /**
   * @param parking Object parking to extract the list
   * @return List of Moto
   */
  public List<Moto> motos(Parking parking);

  /**
   * @param parking Object parking to extract the list
   * @return List of Bicicleta
   */
  public List<Bicicleta> bicicletas(Parking parking);

  /**
   * @param parking Object parking to count number of vehicles with the chosen color
   * @param color color of the number of vehicle to count
   * @return number of vehicles with the chosen color
   */
  public int numVehiculosColorX(Parking parking, String color);

}
