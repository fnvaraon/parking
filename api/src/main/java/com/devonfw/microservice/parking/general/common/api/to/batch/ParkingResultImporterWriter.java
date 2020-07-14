package com.devonfw.microservice.parking.general.common.api.to.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;

/**
 * @author fnvaraon Write line by line what we read before in the file
 */
public class ParkingResultImporterWriter implements ItemWriter<ParkingRest> {

  /**
   * The constructor.
   */
  public ParkingResultImporterWriter() {

    super();
  }

  @Override
  public void write(List<? extends ParkingRest> listParkingRest) throws Exception {

    for (ParkingRest parkingRest : listParkingRest) {
      System.out.println(parkingRest.toString());
    }
  }
}
