package com.devonfw.microservice.parking.general.service.impl.rest;

import javax.annotation.security.PermitAll;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.devonfw.microservice.parking.general.common.api.ParkingRestDao;
import com.devonfw.microservice.parking.general.common.api.to.Inicio;
import com.devonfw.microservice.parking.general.common.api.to.ParkingRestDaoImpl;
import com.devonfw.microservice.parking.general.common.api.to.batch.ReadJSONFromFile;
import com.devonfw.microservice.parking.general.common.api.to.batch.WriteJSONToFile;
import com.devonfw.microservice.parking.general.common.api.to.model.Fichero;
import com.devonfw.microservice.parking.general.common.api.to.model.Moto;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingResult;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;
import com.devonfw.microservice.parking.general.service.api.rest.ParkingRestService;

/**
 * @author fnvaraon
 *
 */
@Named
@Transactional
public class ParkingRestServiceImpl implements ParkingRestService {

  private static Logger log = LoggerFactory.getLogger(ParkingRestServiceImpl.class);

  /**
   * Vamos a transformar un ParkingRest recibido, y vamos a devolver un ParkingResult
   *
   * @param nombreParking
   * @param plazasCoches
   * @param plazasMotos
   * @param color
   * @return
   */
  public static ParkingResult convertParkingRestToParkingResult(String nombreParking, int plazasCoches, int plazasMotos,
      String color) {

    log.debug("Vamos a transformar un ParkingRest recibido, y vamos a devolver un ParkingResult");
    ParkingRestDao parkingRestDao = new ParkingRestDaoImpl();

    Parking parking = null;
    ParkingResult parkingResult = new ParkingResult();

    String[] args = { nombreParking, String.valueOf(plazasCoches), String.valueOf(plazasMotos), color };
    parking = Inicio.rellenarParking(args);

    parkingResult.setNombre(parking.getNombre());
    parkingResult.setNumeroVehiculosColorElegido(parkingRestDao.numVehiculosColorX(parking, color));
    parkingResult.setListCoches(parkingRestDao.coches(parking));
    parkingResult.setListMotos(parkingRestDao.motos(parking));
    parkingResult.setListBicicletas(parkingRestDao.bicicletas(parking));

    return parkingResult;

  }

  /**
   * Servicio POST 'parking', que devuelve un ParkingResult
   */
  @Override
  @PermitAll
  public ResponseEntity<?> getParkingAcademy(ParkingRest parkingRest) {

    log.debug("Servicio POST 'parking', que devuelve un ParkingResult");
    // System.out.println(parkingRest.getNombreParking());
    // System.out.println(parkingRest.getPlazasCoches());
    // System.out.println(parkingRest.getPlazasMotos());
    // System.out.println(parkingRest.getColor());

    // Parking parking = null;
    ParkingResult parkingResult = new ParkingResult();
    // this.parkingRestDao = new ParkingRestDaoImpl();

    parkingResult = convertParkingRestToParkingResult(parkingRest.getNombreParking(), parkingRest.getPlazasCoches(),
        parkingRest.getPlazasMotos(), parkingRest.getColor());

    HttpStatus status = HttpStatus.OK;
    return ResponseEntity.status(status).body(parkingResult);
  }

  /**
   * Servicio GET 'moto', que devuelve un vehículo moto
   */
  @Override
  @PermitAll
  public ResponseEntity<?> getMoto() {

    log.debug("Servicio GET 'moto', que devuelve un vehículo moto");

    HttpStatus status = null;

    Moto moto = new Moto();

    status = HttpStatus.OK;

    return ResponseEntity.status(status).body(moto);

  }

  /**
   * Servicio POST 'vehiculo', que devuelve un vehículo metido de forma aleatorio en un parking
   */
  @Override
  @PermitAll
  public ResponseEntity<?> getVehiculo(String nombreParking) {

    log.debug("Servicio POST 'vehiculo', que devuelve un vehículo metido de forma aleatorio en un parking");
    HttpStatus status = null;

    Parking miParking = new Parking(nombreParking);
    Vehiculo vehiculo = miParking.crearVehiculoAleatorio();

    status = HttpStatus.OK;

    return ResponseEntity.status(status).body(vehiculo);

  }

  /**
   * Servicio POST 'readParking', que devuelve un parkingResult leído de un fichero en formato JSON
   */
  @Override
  @PermitAll
  public ResponseEntity<?> readParkingFromFile(Fichero fichero) {

    log.debug("Servicio POST 'readParking', que devuelve un parkingResult leído de un fichero en formato JSON");
    String ruta = fichero.getFichero();
    // System.out.println("Ruta del fichero -->" + ruta);
    HttpStatus status = HttpStatus.OK;

    ParkingResult parkingResult = ReadJSONFromFile.parseFromFile(ruta);
    // System.out.println("Parking Result --> " + parkingResult.toString());
    return ResponseEntity.status(status).body(parkingResult);

  }

  /**
   * Servicio POST 'writeParking', al que se le envía un parkingRest, lo convierte en parkingResult y lo escribe en un
   * fichero en formato JSON
   */
  @Override
  @PermitAll
  public ResponseEntity<?> writeParkingIntoFile(ParkingRest parkingRest) {

    log.debug(
        "Servicio POST 'writeParking', al que se le envía un parkingRest, lo convierte en parkingResult y lo escribe en un fichero en formato JSON");
    HttpStatus status = HttpStatus.OK;

    WriteJSONToFile.parseToFile(convertParkingRestToParkingResult(parkingRest.getNombreParking(),
        parkingRest.getPlazasCoches(), parkingRest.getPlazasMotos(), parkingRest.getColor()));

    return ResponseEntity.status(status).build();

  }

}
