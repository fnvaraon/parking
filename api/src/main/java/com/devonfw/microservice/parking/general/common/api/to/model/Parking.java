package com.devonfw.microservice.parking.general.common.api.to.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fnvaraon
 *
 */
public class Parking {

  private static final int MAX_PLAZAS_COCHES = 20;

  private static final int MAX_PLAZAS_MOTOS = 15;

  private static final int MAX_PLAZAS_BICICLETAS = 10;

  private static Logger log = LoggerFactory.getLogger(Parking.class);

  private static Random r;

  private String nombre;

  private int plazasLibresCoches;

  private int plazasLibresMotos;

  private int plazasLibresBicicletas;

  private int maxPlazasLibresCoches;

  private int maxPlazasLibresMotos;

  private int maxPlazasLibresBicicletas;

  private int[] coloresVehiculos;

  private List<Vehiculo> vehiculos;

  static {
    try {
      r = SecureRandom.getInstanceStrong();
    } catch (NoSuchAlgorithmException e) {
      log.error("Error creando el valor aleatorio", e);
    }
  }

  /**
   * The constructor.
   *
   * @param nombre name of the parking
   */
  public Parking(String nombre) {

    this.nombre = nombre;
    this.plazasLibresCoches = MAX_PLAZAS_COCHES;
    this.plazasLibresMotos = MAX_PLAZAS_MOTOS;
    this.plazasLibresBicicletas = MAX_PLAZAS_BICICLETAS;
    this.maxPlazasLibresCoches = MAX_PLAZAS_COCHES;
    this.maxPlazasLibresMotos = MAX_PLAZAS_MOTOS;
    this.maxPlazasLibresBicicletas = MAX_PLAZAS_BICICLETAS;
    this.coloresVehiculos = new int[ColorVehiculo.numColores()];
    this.vehiculos = new LinkedList<>();
  }

  /**
   * The constructor.
   *
   * @param nombre name of the parking
   * @param numPlazasCoches number of car's parking lots
   */
  public Parking(String nombre, int numPlazasCoches) {

    this.nombre = nombre;
    this.plazasLibresCoches = numPlazasCoches;
    this.maxPlazasLibresCoches = numPlazasCoches;
    this.plazasLibresMotos = MAX_PLAZAS_MOTOS;
    this.plazasLibresBicicletas = MAX_PLAZAS_BICICLETAS;
    this.maxPlazasLibresMotos = MAX_PLAZAS_MOTOS;
    this.maxPlazasLibresBicicletas = MAX_PLAZAS_BICICLETAS;
    this.coloresVehiculos = new int[ColorVehiculo.numColores()];
    this.vehiculos = new LinkedList<>();
  }

  /**
   * The constructor.
   *
   * @param nombre name of the parking
   * @param numPlazasCoches number of car parking lots
   * @param numPlazasMotos number of motorbike's parking lots
   */
  public Parking(String nombre, int numPlazasCoches, int numPlazasMotos) {

    this.nombre = nombre;
    this.plazasLibresCoches = numPlazasCoches;
    this.plazasLibresMotos = numPlazasMotos;
    this.maxPlazasLibresCoches = numPlazasCoches;
    this.maxPlazasLibresMotos = numPlazasMotos;
    this.plazasLibresBicicletas = MAX_PLAZAS_BICICLETAS;
    this.maxPlazasLibresBicicletas = MAX_PLAZAS_BICICLETAS;
    this.coloresVehiculos = new int[ColorVehiculo.numColores()];
    this.vehiculos = new LinkedList<>();
  }

  /**
   * @return
   */
  public String getNombre() {

    return this.nombre;
  }

  /**
   * @param nombre
   */
  protected void setNombre(String nombre) {

    this.nombre = nombre;
  }

  /**
   * @return
   */
  public int getPlazasLibresCoches() {

    return this.plazasLibresCoches;
  }

  /**
   * @return
   */
  public int getPlazasLibresMotos() {

    return this.plazasLibresMotos;
  }

  /**
   * @return
   */
  public int getPlazasLibresBicicletas() {

    return this.plazasLibresBicicletas;
  }

  /**
   *
   */
  protected void addPlazasLibresCoches() {

    log.debug("Se libera una plaza de coche en el parking");
    if (this.plazasLibresCoches < getMaxPlazasLibresCoches()) {
      this.plazasLibresCoches++;
    }
  }

  /**
   *
   */
  private void restarPlazasLibresCoches() {

    log.debug("Se ocupa una plaza de coche en el parking");
    if (this.plazasLibresCoches > 0) {
      this.plazasLibresCoches--;
    }
  }

  /**
   *
   */
  protected void addPlazasLibresMotos() {

    log.debug("Se libera una plaza de moto en el parking");
    if (this.plazasLibresMotos < getMaxPlazasLibresMotos()) {
      this.plazasLibresMotos++;
    }
  }

  /**
   *
   */
  private void restarPlazasLibresMotos() {

    log.debug("Se ocupa una plaza de moto en el parking");
    if (this.plazasLibresMotos > 0) {
      this.plazasLibresMotos--;
    }
  }

  /**
   *
   */
  protected void addPlazasLibresBicicletas() {

    log.debug("Se libera una plaza de bicicleta en el parking");
    if (this.plazasLibresBicicletas < getMaxPlazasLibresBicicletas()) {
      this.plazasLibresBicicletas++;
    }
  }

  /**
   *
   */
  private void restarPlazasLibresBicicletas() {

    log.debug("Se ocupa una plaza de bicicleta en el parking");
    if (this.plazasLibresBicicletas > 0) {
      this.plazasLibresBicicletas--;
    }
  }

  /**
   * @return
   */
  public List<Vehiculo> getVehiculos() {

    return this.vehiculos;
  }

  /**
   * @param vehiculos
   */
  public void setVehiculos(List<Vehiculo> vehiculos) {

    this.vehiculos = vehiculos;
  }

  /**
   * @param vehiculo
   */
  public void addVehiculos(Vehiculo vehiculo) {

    log.debug("Se mete " + vehiculo.getClass().getSimpleName() + " en la lista de vehiculos.");
    this.vehiculos.add(vehiculo);
    addColoresVehiculos(vehiculo.getColorVehiculo());
  }

  /**
   * @param vehiculo
   */
  public void quitarVehiculos(Vehiculo vehiculo) {

    log.debug("Se quita " + vehiculo.getClass().getSimpleName() + " de la lista de vehiculos.");
    this.vehiculos.remove(vehiculo);
    restarColoresVehiculos(vehiculo.getColorVehiculo());
  }

  /**
   * @return
   */
  public int getMaxPlazasLibresCoches() {

    return this.maxPlazasLibresCoches;
  }

  /**
   * @return
   */
  public int getMaxPlazasLibresMotos() {

    return this.maxPlazasLibresMotos;
  }

  /**
   * @return
   */
  public int getMaxPlazasLibresBicicletas() {

    return this.maxPlazasLibresBicicletas;
  }

  /**
   * @return
   */
  public int getNumeroVehiculos() {

    return getVehiculos().size();
  }

  /**
   * @return
   */
  public Vehiculo crearVehiculoAleatorio() {

    log.debug("Se va a crear un vehiculo de forma aleatoria");

    int aleatorio = r.nextInt(3);

    switch (aleatorio) {
      case 0:
        return new Coche();
      case 1:
        return new Moto();
      case 2:
        return new Bicicleta();
      default:
        return new Coche();
    }
  }

  /**
   *
   * @param colorVehiculo
   */
  private void addColoresVehiculos(ColorVehiculo colorVehiculo) {

    log.debug("Se añade un vehiculo más en el array para controlar el número de vehículos de cada color");
    switch (colorVehiculo) {
      case AZUL:
        this.coloresVehiculos[0]++;
        break;
      case BLANCO:
        this.coloresVehiculos[1]++;
        break;
      case NEGRO:
        this.coloresVehiculos[2]++;
        break;
      default: // ROSA
        this.coloresVehiculos[3]++;
        break;
    }
  }

  /**
   *
   * @param colorVehiculo
   */
  private void restarColoresVehiculos(ColorVehiculo colorVehiculo) {

    log.debug("Se quita un vehículo del array para controlar el número de vehículos de cada color");
    switch (colorVehiculo) {
      case AZUL:
        this.coloresVehiculos[0]--;
        break;
      case BLANCO:
        this.coloresVehiculos[1]--;
        break;
      case NEGRO:
        this.coloresVehiculos[2]--;
        break;
      default: // ROSA
        this.coloresVehiculos[3]--;
        break;
    }
  }

  /**
   *
   * @param colorVehiculo
   * @return
   */
  public int numeroVehiculosColorX(ColorVehiculo colorVehiculo) {

    log.debug("Devuelve el número de vehículos de color " + colorVehiculo);
    switch (colorVehiculo) {
      case AZUL:
        return this.coloresVehiculos[0];
      case BLANCO:
        return this.coloresVehiculos[1];
      case NEGRO:
        return this.coloresVehiculos[2];
      default: // ROSA
        return this.coloresVehiculos[3];
    }
  }

  /**
   * @param vehiculo
   * @return
   */
  public Respuesta solicitarAcceso(Vehiculo vehiculo) {

    if (vehiculo instanceof Coche) {
      log.debug("Coche solicita acceso al parking");
      if (getPlazasLibresCoches() > 0) {
        addVehiculos(vehiculo);
        accesoPermitido(vehiculo);
        return Respuesta.SI;
      } else {
        accesoDenegado(vehiculo);
        return Respuesta.NO;
      }
    } else if (vehiculo instanceof Moto) {
      log.debug("Moto solicita acceso al parking");
      if (getPlazasLibresMotos() > 0) {
        addVehiculos(vehiculo);
        accesoPermitido(vehiculo);
        return Respuesta.SI;
      } else {
        accesoDenegado(vehiculo);
        return Respuesta.NO;
      }
    } else { // vehiculo instanceof Bicicleta
      log.debug("Bicicleta solicita acceso al parking");
      if (getPlazasLibresBicicletas() > 0) {
        addVehiculos(vehiculo);
        accesoPermitido(vehiculo);
        return Respuesta.SI;
      } else {
        accesoDenegado(vehiculo);
        return Respuesta.NO;
      }
    }
  }

  /**
   * Método al que se llama cuando se concede acceso al parking al vehículo que se pasa como parámetro
   *
   * @param vehiculo vehículo al que se le concede acceso al parking
   */
  public void accesoPermitido(Vehiculo vehiculo) {

    log.info("Soy el parking, " + getNombre() + " y acabo de aceptar una " + vehiculo.getClass().getSimpleName() + ".");
    if (vehiculo instanceof Coche) {
      vehiculo.entrarParking();
      restarPlazasLibresCoches();
      log.info("Me quedan " + getPlazasLibresCoches() + " plazas disponibles para "
          + vehiculo.getClass().getSimpleName() + ".");
    } else if (vehiculo instanceof Moto) {
      vehiculo.entrarParking();
      restarPlazasLibresMotos();
      log.info("Me quedan " + getPlazasLibresMotos() + " plazas disponibles para " + vehiculo.getClass().getSimpleName()
          + ".");
    } else { // vehiculo instanceof Bicicleta
      vehiculo.entrarParking();
      restarPlazasLibresBicicletas();
      log.info("Me quedan " + getPlazasLibresBicicletas() + " plazas disponibles para "
          + vehiculo.getClass().getSimpleName() + ".");
    }
  }

  /**
   * Método que se llama al denegar acceso al parking para un determinado vehículo
   *
   * @param vehiculo Vehículo al que se le deniega el acceso al parking
   */
  public void accesoDenegado(Vehiculo vehiculo) {

    vehiculo.salirParking();
    log.info(
        "Soy el parking, " + getNombre() + " y acabo de rechazar una " + vehiculo.getClass().getSimpleName() + ".");
  }

  /**
   * @param vehiculo
   */
  public void salirDelParking(Vehiculo vehiculo) {

    log.debug("Va a salir del parking el vehiculo " + vehiculo.getClass().getSimpleName());
    vehiculo.salirParking();
    quitarVehiculos(vehiculo);
    restarColoresVehiculos(vehiculo.getColorVehiculo());
    log.debug("El vehículo " + vehiculo.getClass().getSimpleName() + " ha salido del parking.");

    if (vehiculo instanceof Coche) {
      addPlazasLibresCoches();
      log.debug("Se libera en el parking una plaza de Coche.");
    } else if (vehiculo instanceof Moto) {
      addPlazasLibresMotos();
      log.debug("Se libera en el parking una plaza de Moto.");
    } else { // vehiculo instanceof Bicicleta
      addPlazasLibresBicicletas();
      log.debug("Se libera en el parking una plaza de Bicicleta.");
    }
  }

  /**
   *
   */
  public void vaciarParking() {

    log.debug("Vamos a vaciar el parking sacando todos los vehiculos.");
    if (getNumeroVehiculos() == 0) {
      log.info("El Parking " + getNombre() + " ya se encuentra vacio.");
    } else {
      while (getNumeroVehiculos() > 0) {
        log.debug("Vehículo saliendo del parking.");
        salirDelParking(this.vehiculos.get(getNumeroVehiculos() - 1));
      }
    }
    log.info("El Parking " + getNombre() + " ya se encuentra vacio.");
  }
}
