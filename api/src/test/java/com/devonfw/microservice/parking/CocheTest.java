package com.devonfw.microservice.parking;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.devonfw.microservice.parking.general.common.api.to.model.Coche;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

public class CocheTest {

  private static Vehiculo vehiculo;

  private static Coche coche;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    coche = new Coche();
    vehiculo = new Coche();
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
  public void cocheEsUnVehiculo() {

    assertThat("Un coche es un veh�culo", coche, instanceOf(Vehiculo.class));
    assertThat("Un coche es un veh�culo", vehiculo, instanceOf(Vehiculo.class));
  }

  @Test
  public void cochePuedeSerDeEstosColores() {

    String[] colorVehiculo = { "AZUL", "BLANCO", "NEGRO", "ROSA" };
    Collection<String> colorVehiculoList = Arrays.asList(colorVehiculo);
    String colores = "AZUL BLANCO NEGRO ROSA";

    assertThat("Una moto puede ser de cualquiera de estos colores", colores,
        anything(String.valueOf(coche.getColorVehiculo())));
    assertThat("Un veh�culo de tipo moto puede crearse en cualquiera de estos colores de forma aleatoria",
        colorVehiculoList, hasItem(String.valueOf(((Coche) vehiculo).getColorVehiculo())));
  }

}
