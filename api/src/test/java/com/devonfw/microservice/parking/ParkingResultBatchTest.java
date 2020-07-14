package com.devonfw.microservice.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.devonfw.microservice.parking.general.common.api.to.batch.ParkingResultImporterMapper;
import com.devonfw.microservice.parking.general.common.api.to.batch.ParkingResultImporterReader;
import com.devonfw.microservice.parking.general.common.api.to.batch.ParkingResultImporterWriter;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;

/**
 * @author fnvaraon
 *
 */
public class ParkingResultBatchTest {

  private static ParkingResultImporterReader prir;

  private static ParkingResultImporterMapper prim;

  private static ParkingResultImporterWriter priw;

  private static List<ParkingRest> listParkingRest;

  private static String[] lines;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    prir = new ParkingResultImporterReader();
    prim = new ParkingResultImporterMapper();
    priw = new ParkingResultImporterWriter();

    listParkingRest = new LinkedList<>();
    lines = (String[]) prir.read();
    listParkingRest = prim.read(lines);
    priw.write(listParkingRest);
  }

  @Test
  public void numberOfLinesInFile()
      throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {

    assertEquals("The number of lines in file file.csv", 6, lines.length);
  }

  @Test
  public void numberOfObjectsMapped()
      throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {

    // System.out.println(listParkingResult.get(0));
    // System.out.println(listParkingResult.get(1));
    assertEquals("the number of ParkingResult in the list", 6, listParkingRest.size());

  }

  @Test
  public void objectsInMappedListHaveSameProperties()
      throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {

    // System.out.println(listParkingResult.get(0));
    // System.out.println(listParkingResult.get(1));

    ParkingRest pr1 = new ParkingRest();
    pr1.setNombreParking("miParking");
    pr1.setPlazasCoches(3);
    pr1.setPlazasMotos(5);
    pr1.setPlazasBicicletas(7);
    pr1.setColor("AZUL");

    ParkingRest pr2 = new ParkingRest();
    pr2.setNombreParking("nuevoParking");
    pr2.setPlazasCoches(4);
    pr2.setPlazasMotos(9);
    pr2.setPlazasBicicletas(2);
    pr2.setColor("BLANCO");

    assertTrue("The same name of ParkingResult objects in the list",
        pr1.getNombreParking().equals(listParkingRest.get(0).getNombreParking()));
    assertEquals("The same color of ParkingResult objects in the list", pr1.getColor(),
        listParkingRest.get(0).getColor());
    assertEquals("The same number of car's lots", pr1.getPlazasCoches(), listParkingRest.get(0).getPlazasCoches());
    assertEquals("The same number of motorbike's lots", pr1.getPlazasMotos(), listParkingRest.get(0).getPlazasMotos());
    assertEquals("The same number of bicicle's lots", pr1.getPlazasBicicletas(),
        listParkingRest.get(0).getPlazasBicicletas());

    assertTrue("The same name of ParkingResult objects in the list",
        pr2.getNombreParking().equals(listParkingRest.get(1).getNombreParking()));
    assertEquals("The same color of ParkingResult objects in the list", pr2.getColor(),
        listParkingRest.get(1).getColor());
    assertEquals("The same number of car's lots", pr2.getPlazasCoches(), listParkingRest.get(1).getPlazasCoches());
    assertEquals("The same number of motorbike's lots", pr2.getPlazasMotos(), listParkingRest.get(1).getPlazasMotos());
    assertEquals("The same number of bicicle's lots", pr2.getPlazasBicicletas(),
        listParkingRest.get(1).getPlazasBicicletas());
  }

  @Test
  public void objectsInMappedListAreEquals()
      throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {

    // System.out.println(listParkingResult.get(0));
    // System.out.println(listParkingResult.get(1));

    ParkingRest pr1 = new ParkingRest();
    pr1.setNombreParking("parking El Carmen");
    pr1.setPlazasCoches(5);
    pr1.setPlazasMotos(6);
    pr1.setPlazasBicicletas(8);
    pr1.setColor("ROSA");

    ParkingRest pr2 = new ParkingRest();
    pr2.setNombreParking("Novo Parking");
    pr2.setPlazasCoches(9);
    pr2.setPlazasMotos(6);
    pr2.setPlazasBicicletas(2);
    pr2.setColor("NEGRO");

    assertTrue("ParkingResult objects in the list", pr1.equals(listParkingRest.get(2)));
    assertTrue("ParkingResult objects in the list", pr2.equals(listParkingRest.get(3)));

  }

  @Test
  public void writeListOfMappedObjects() {

    ParkingRest pr1 = new ParkingRest();
    pr1.setNombreParking("parqueando");
    pr1.setPlazasCoches(2);
    pr1.setPlazasMotos(4);
    pr1.setPlazasBicicletas(3);
    pr1.setColor("BLANCO");

    ParkingRest pr2 = new ParkingRest();
    pr2.setNombreParking("parkings S.A.");
    pr2.setPlazasCoches(6);
    pr2.setPlazasMotos(2);
    pr2.setPlazasBicicletas(1);
    pr2.setColor("AZUL");

    assertTrue("The same of ParkingResult objects in the list",
        pr1.toString().equals(listParkingRest.get(4).toString()));
    assertTrue("The same of ParkingResult objects in the list",
        pr2.toString().equals(listParkingRest.get(5).toString()));
  }

}
