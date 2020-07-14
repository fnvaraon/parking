package com.devonfw.microservice.parking;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.devonfw.microservice.parking.general.common.api.to.Inicio;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;

public class InicioTest {

  private static Parking parking;

  private static Inicio inicio;

  private static String[] args1 = { "miNuevoParking" };

  private static String[] args2 = { "miNuevoParking", "4" };

  private static String[] args3 = { "miNuevoParking", "4", "BLANCO" };

  private static String[] args4 = { "miNuevoParking", "4", "3", "AZUL" };

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

  }

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void numeroArgumentosIncorrecto() {

    Inicio.rellenarParking(args4);
    assertFalse("Faltan argumentos de entrada al programa", false);

    Inicio.rellenarParking(args4);
    assertFalse("Faltan argumentos de entrada al programa", false);
  }

}
