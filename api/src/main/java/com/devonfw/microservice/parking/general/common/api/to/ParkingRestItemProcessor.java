package com.devonfw.microservice.parking.general.common.api.to;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;

/**
 * @author fnvaraon
 *
 */
public class ParkingRestItemProcessor implements ItemProcessor<ParkingRest, ParkingRest> {

  private static final Logger log = LoggerFactory.getLogger(ParkingRestItemProcessor.class);

  /**
   *
   */
  @Override
  public ParkingRest process(final ParkingRest parkingRest) throws Exception {

    final String nombreParking = parkingRest.getNombreParking();
    final int plazasCoches = parkingRest.getPlazasCoches();
    final int plazasMotos = parkingRest.getPlazasMotos();
    final int plazasBicicletas = parkingRest.getPlazasBicicletas();
    final String color = parkingRest.getColor();

    final ParkingRest trasformedParkingRest = new ParkingRest(nombreParking, plazasCoches, plazasMotos,
        plazasBicicletas, color);

    log.info("----- CONVERTING PARKING OBJECT -----");

    return parkingRest;
  }
}
