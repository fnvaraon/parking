package com.devonfw.microservice.parking;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.devonfw.microservice.parking.general.common.api.to.model.Bicicleta;
import com.devonfw.microservice.parking.general.common.api.to.model.Coche;
import com.devonfw.microservice.parking.general.common.api.to.model.ColorVehiculo;
import com.devonfw.microservice.parking.general.common.api.to.model.Parking;
import com.devonfw.microservice.parking.general.common.api.to.model.Respuesta;
import com.devonfw.microservice.parking.general.common.api.to.model.Vehiculo;

public class ParkingTest {

  private static Logger log = Logger.getLogger(Parking.class);

  private static Parking parking;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    parking = new Parking("parkingMolon", 5, 6);

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {

    parking.vaciarParking();
  }

  @Before
  public void setUp() throws Exception {

    int j = 0;
    while (parking.getPlazasLibresBicicletas() > 0) {
      j++;
      Vehiculo vehiculo = null;
      vehiculo = parking.crearVehiculoAleatorio();
      parking.solicitarAcceso(vehiculo);
    }
  }

  /*
   * @After public void tearDown() throws Exception {
   * 
   * int j = 0; while(parking.getPlazasLibresBicicletas() > 0) { j++; Vehiculo vehiculo = null; vehiculo =
   * parking.crearVehiculoAleatorio(); miParking.solicitarAcceso(vehiculo); } }
   */

  @Test
  public void parkingTieneNombre() {

    assertTrue("El parking tiene un nombre1", parking.getNombre() != null);
    assertNotNull("El parking tiene un nombre2", parking.getNombre());
    assertFalse("El parking tiene un nombre3", parking.getNombre().equals(""));
    assertSame("El parking tiene un nombre4", parking.getNombre(), "parkingMolon");
  }

  @Test
  public void tienePlazasCoches() {

    int plazasCoches = 5;
    assertEquals("El parking dispone de un n�mero de plazas para coches entre 1 y X", plazasCoches,
        parking.getMaxPlazasLibresCoches());
  }

  @Test
  public void tienePlazasMotos() {

    int plazasMotos = 6;
    assertEquals("El parking dispone de un n�mero de plazas para motos entre 1 e Y.", plazasMotos,
        parking.getMaxPlazasLibresMotos());

    Parking miParking = new Parking("parkingMolon", 5);

    int j = 0;
    while (miParking.getPlazasLibresBicicletas() > 0) {
      j++;
      Vehiculo vehiculo = null;
      vehiculo = miParking.crearVehiculoAleatorio();
      miParking.solicitarAcceso(vehiculo);
    }

    int plazasMotosDefecto = 15;
    assertEquals("El n�mero de plazas de Moto por defecto es 15", plazasMotosDefecto,
        miParking.getMaxPlazasLibresMotos());

  }

  @Test
  public void tienePlazasBicicletas() {

    int plazasBicicletas = 10;
    assertEquals("El parking dispone de un n�mero de plazas para bicicletas entre 1 y 10", plazasBicicletas,
        parking.getMaxPlazasLibresBicicletas());
  }

  @Test
  public void verificaPlazasLibres() {

    String[] respuesta = { "SI", "NO" };
    Collection<String> respuestaList = Arrays.asList(respuesta);
    String respuestas = "SI NO";
    Vehiculo vehiculo = new Coche();
    Respuesta acceso = parking.solicitarAcceso(vehiculo);
    log.debug(acceso);
    log.debug(respuesta[1]);
    assertEquals("No hay plazas libres", String.valueOf(acceso), respuesta[1]);
    assertThat("Sin plazas libres", respuesta[1], equalTo(String.valueOf(acceso)));
    assertThat("Sin plazas libres", respuesta[1], endsWith(String.valueOf(acceso)));
    assertThat("Responde con SI o NO si hay o no plazas libres", respuestas, anything(String.valueOf(acceso)));
    assertThat("Responde con SI o NO si hay o no plazas libres", respuestaList, hasItem(String.valueOf(acceso)));

    parking.vaciarParking();
    log.debug("Plazas libres de bicicletas: " + parking.getPlazasLibresBicicletas());
    assertEquals("El parking est� vac�o", 10, parking.getPlazasLibresBicicletas());

    Respuesta acceso2 = parking.solicitarAcceso(vehiculo);
    log.debug(acceso2);
    log.debug(respuesta[0]);
    assertEquals("Hay plazas libres", String.valueOf(acceso2), respuesta[0]);
    assertThat("Sin plazas libres", respuesta[0], is(String.valueOf(acceso2)));
    assertThat("Sin plazas libres", respuesta[0], startsWith(String.valueOf(acceso2)));
    assertThat("Responde con SI o NO si hay o no plazas libres", respuestas, anything(String.valueOf(acceso2)));
    assertThat("Responde con SI o NO si hay o no plazas libres", respuestaList, hasItem(String.valueOf(acceso2)));
  }

  @Test
  public void aceptaEntradaAlParking() {

    parking.vaciarParking();

    Vehiculo vehiculo = new Bicicleta();
    // String soy ="Soy el parking, "+parking.getNombre()+" y acabo de aceptar un
    // "+vehiculo.getClass().getSimpleName()+".";
    Respuesta concedido = parking.solicitarAcceso(vehiculo);

    assertEquals("Hay plazas libres", String.valueOf(concedido), "SI");
    parking.accesoPermitido(vehiculo);
    // assertEquals("Aceptar acceso al parking", );
  }

  @Test
  public void deniegaEntradaAlParking() {

    Vehiculo vehiculo = new Bicicleta();
    // String soy ="Soy el parking, "+parking.getNombre()+" y acabo de rechazar un
    // "+vehiculo.getClass().getSimpleName()+".";
    Respuesta denegado = parking.solicitarAcceso(vehiculo);

    assertEquals("No hay plazas libres", String.valueOf(denegado), "NO");
    parking.accesoDenegado(vehiculo);
    // assertEquals("Denegar acceso al parking", );

  }

  @Test
  public void meQuedanXPlazasDisponibles() {

    int plazasBicicletasDisponibles = parking.getPlazasLibresBicicletas();
    assertEquals("Me quedan X plazas disponibles", 0, plazasBicicletasDisponibles);
  }

  @Test
  public void tengoXVehiculosDeColorY() {

    ColorVehiculo colorVehiculo = ColorVehiculo.BLANCO;

    assertNotEquals("No todos los veh�culos son del color Y", 21, parking.numeroVehiculosColorX(colorVehiculo));
  }
}
