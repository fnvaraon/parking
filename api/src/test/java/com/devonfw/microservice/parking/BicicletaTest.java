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

import com.devonfw.microservice.parking.general.common.api.to.model.Bicicleta;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

public class BicicletaTest {

  private static Vehiculo vehiculo;

  private static Bicicleta bicicleta;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    bicicleta = new Bicicleta();
    vehiculo = new Bicicleta();
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
  public void bicicletaEsUnVehiculo() {

    assertThat("Una bicicleta es un veh�culo", bicicleta, instanceOf(Vehiculo.class));
    assertThat("Una bicicleta es un veh�culo", vehiculo, instanceOf(Vehiculo.class));
  }

  @Test
  public void motoPuedeSerDeEstosColores() {

    String[] colorVehiculo = { "AZUL", "BLANCO", "NEGRO", "ROSA" };
    Collection<String> colorVehiculoList = Arrays.asList(colorVehiculo);
    String colores = "AZUL BLANCO NEGRO ROSA";

    assertThat("Una bicicleta puede ser de cualquiera de estos colores", colores,
        anything(String.valueOf(bicicleta.getColorVehiculo())));
    assertThat("Un veh�culo de tipo bicicleta puede crearse en cualquiera de estos colores de forma aleatoria",
        colorVehiculoList, hasItem(String.valueOf(((Bicicleta) vehiculo).getColorVehiculo())));
  }

}
