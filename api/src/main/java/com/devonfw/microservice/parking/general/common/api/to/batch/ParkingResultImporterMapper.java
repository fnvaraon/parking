package com.devonfw.microservice.parking.general.common.api.to.batch;

import java.util.LinkedList;
import java.util.List;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;

/**
 * @author fnvaraon Each line mapper
 */
public class ParkingResultImporterMapper {

  // private ParkingResultImporterReader prir;

  /**
   * The constructor.
   */
  public ParkingResultImporterMapper() {

    super();
  }

  public List<ParkingRest> read(String[] lines)
      throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {

    // String[] lines = (String[]) prir.read();
    String[] line = new String[5];
    List<ParkingRest> listParkingRest = new LinkedList<>();
    ParkingRest parkingRest;

    for (int j = 0; j < lines.length; j++) {
      if (lines[j] == null) {
        break;
      } else {
        line = lines[j].split(",");
        parkingRest = new ParkingRest();
        parkingRest.setNombreParking(line[0]);
        parkingRest.setPlazasCoches(Integer.parseInt(line[1]));
        parkingRest.setPlazasMotos(Integer.parseInt(line[2]));
        parkingRest.setPlazasBicicletas(Integer.parseInt(line[3]));
        parkingRest.setColor(line[4]);
        listParkingRest.add(parkingRest);
      }
    }

    return listParkingRest;
  }

}
