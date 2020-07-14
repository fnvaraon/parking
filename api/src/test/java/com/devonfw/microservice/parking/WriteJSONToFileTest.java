package com.devonfw.microservice.parking;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.devonfw.microservice.parking.general.common.api.ParkingRestDao;
import com.devonfw.microservice.parking.general.common.api.to.Inicio;
import com.devonfw.microservice.parking.general.common.api.to.ParkingRestDaoImpl;
import com.devonfw.microservice.parking.general.common.api.to.batch.WriteJSONToFile;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingResult;

/**
 * @author fnvaraon
 *
 */
public class WriteJSONToFileTest {

  private static ParkingResult parkingResult;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    parkingResult = new ParkingResult();

    ParkingRestDao parkingRestDao = new ParkingRestDaoImpl();

    Parking parking = null;

    String[] args = { "novoParking", "4", "5", "AZUL" };
    parking = Inicio.rellenarParking(args);

    parkingResult.setNombre(parking.getNombre());
    parkingResult.setNumeroVehiculosColorElegido(parkingRestDao.numVehiculosColorX(parking, "AZUL"));
    parkingResult.setListCoches(parkingRestDao.coches(parking));
    parkingResult.setListMotos(parkingRestDao.motos(parking));
    parkingResult.setListBicicletas(parkingRestDao.bicicletas(parking));

    WriteJSONToFile.parseToFile(parkingResult);

  }

  @Test
  public void test() {

    assertTrue("Is true", true);
  }

}
