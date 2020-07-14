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

import com.devonfw.microservice.parking.general.common.api.to.model.Moto;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

public class MotoTest {

  private static Vehiculo vehiculo;

  private static Moto moto;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    moto = new Moto();
    vehiculo = new Moto();
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
  public void motoEsUnVehiculo() {

    assertThat("Una moto es un veh�culo", moto, instanceOf(Vehiculo.class));
    assertThat("Una moto es un veh�culo", vehiculo, instanceOf(Vehiculo.class));
  }

  @Test
  public void motoPuedeSerHarleyODucati() {

    String[] tipoMoto = { "HARLEY", "DUCATI" };
    Collection<String> tipoMotoList = Arrays.asList(tipoMoto);
    String tipos = "HARLEY DUCATI";

    assertThat("Una Moto puede ser una Harley o una Ducati", tipos, anything(String.valueOf(moto.getTipoMoto())));
    assertThat("Un veh�culo de tipo moto puede ser de una de estas marcas: Harley o Ducati", tipoMotoList,
        hasItem(String.valueOf(((Moto) vehiculo).getTipoMoto())));

  }

  @Test
  public void motoPuedeSerDeEstosColores() {

    String[] colorVehiculo = { "AZUL", "BLANCO", "NEGRO", "ROSA" };
    Collection<String> colorVehiculoList = Arrays.asList(colorVehiculo);
    String colores = "AZUL BLANCO NEGRO ROSA";

    assertThat("Una moto puede ser de cualquiera de estos colores", colores,
        anything(String.valueOf(moto.getColorVehiculo())));
    assertThat("Un veh�culo de tipo moto puede crearse en cualquiera de estos colores de forma aleatoria",
        colorVehiculoList, hasItem(String.valueOf(((Moto) vehiculo).getColorVehiculo())));
  }

}
