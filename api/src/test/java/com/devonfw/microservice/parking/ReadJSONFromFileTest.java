package com.devonfw.microservice.parking;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.devonfw.microservice.parking.general.common.api.to.batch.ReadJSONFromFile;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingResult;

/**
 * @author fnvaraon
 *
 */
public class ReadJSONFromFileTest {

  private static ParkingResult parkingResult;

  private static String fichero;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    parkingResult = new ParkingResult();
    fichero = "C:\\Devon-dist_3.1.0\\parkingacademy\\core\\file.json";

    parkingResult = ReadJSONFromFile.parseFromFile(fichero);

    System.out.println(parkingResult.toString());
  }

  @Test
  public void test() {

    assertTrue("Is true", true);
  }

}
