package com.devonfw.microservice.parking.general.service.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.http.ResponseEntity;

import com.devonfw.microservice.parking.general.common.api.to.model.Fichero;
import com.devonfw.microservice.parking.general.common.api.to.model.Moto;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingResult;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;
import com.devonfw.module.rest.common.api.RestService;

/**
 * @author fnvaraon
 *
 */
@Path("/security/v1")
public interface ParkingRestService extends RestService {

  /**
   *
   * @param parkingRest
   * @return the {@link ParkingResult}
   */
  @POST
  @Path("/parking")
  ResponseEntity<?> getParkingAcademy(ParkingRest parkingRest);

  /**
   *
   * @return the {@link Moto}
   */
  @GET
  @Path("/moto")
  ResponseEntity<?> getMoto();

  /**
   * @param nombreParking recibe como parámetro el nombre del parking
   * @return the {@link Vehiculo}
   */
  @POST
  @Path("/vehiculo")
  ResponseEntity<?> getVehiculo(String nombreParking);

  // Read a parking from a file and print in web
  /**
   * @param fichero
   * @return
   */
  @POST
  @Path("/readParking")
  ResponseEntity<?> readParkingFromFile(Fichero fichero);

  // With post method call, generate parking and write in file
  /**
   * @param parkingRest
   * @return
   */
  @POST
  @Path("/writeParking")
  ResponseEntity<?> writeParkingIntoFile(ParkingRest parkingRest);

}
