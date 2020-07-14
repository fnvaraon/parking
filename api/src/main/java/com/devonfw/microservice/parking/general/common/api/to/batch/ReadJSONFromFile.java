package com.devonfw.microservice.parking.general.common.api.to.batch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devonfw.microservice.parking.general.common.api.to.model.Bicicleta;
import com.devonfw.microservice.parking.general.common.api.to.model.Coche;
import com.devonfw.microservice.parking.general.common.api.to.model.ColorVehiculo;
import com.devonfw.microservice.parking.general.common.api.to.model.Moto;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingResult;
import com.devonfw.microservice.parking.general.common.api.to.model.TipoMoto;

/**
 * @author fnvaraon
 *
 */
public class ReadJSONFromFile {

  private static Logger log = LoggerFactory.getLogger(ReadJSONFromFile.class);

  /**
   * Vamos a convertir un JSON leído de fichero en un objeto ParkingResult
   *
   * @param fichero
   * @return
   */
  @SuppressWarnings("unchecked")
  public static ParkingResult parseFromFile(String fichero) {

    log.debug("Vamos a convertir un JSON leído de fichero en un objeto ParkingResult");
    // System.out.println("Ruta del fichero -->" + fichero);
    ParkingResult parkingResult = new ParkingResult();

    // try (FileReader reader = new FileReader("C:\\Devon-dist_3.1.0\\parkingacademy\\core\\file.json")) {

    try (FileReader reader = new FileReader(fichero)) {
      log.debug("Leído el fichero correctamente");
      // JSON parser object to parse read file
      JSONParser jsonParser = new JSONParser();

      // Read JSON file
      Object obj = jsonParser.parse(reader);

      // Get whole object file
      JSONObject parkingList = (JSONObject) obj;

      // Get ParkingResult object
      log.debug("Parseamos el objeto parkingResult");
      JSONObject parkingObject = (JSONObject) parkingList.get("parking");
      // parkingObject =
      // System.out.println("Parking Object --> " + parkingObject);

      // ParkingResult Details
      log.debug("Parseamos las propiedades de parkingResult");
      String name = (String) parkingObject.get("nombre");
      int number = ((Long) parkingObject.get("numeroVehiculosColorElegido")).intValue();
      // System.out.println("numeroVehiculosColorElegido --> " + number);

      // Coche list
      log.debug("Obtenemos del JSON la lista de coches");
      List<Coche> parkingListCoches = parseCocheObject(parkingObject);

      // Moto list
      log.debug("Obtenemos del JSON la lista de motos");
      List<Moto> parkingListMotos = parseMotoObject(parkingObject);

      // Bicicleta list
      log.debug("Obtenemos del JSON la lista de bicicletas");
      List<Bicicleta> parkingListBicicletas = parseBicicletaObject(parkingObject);

      parkingResult.setNombre(name);
      parkingResult.setNumeroVehiculosColorElegido(number);
      parkingResult.setListCoches(parkingListCoches);
      parkingResult.setListMotos(parkingListMotos);
      parkingResult.setListBicicletas(parkingListBicicletas);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return parkingResult;

  }

  private static List<Coche> parseCocheObject(JSONObject parkingObject) {

    // Coche list
    List<Coche> parkingListCoches = new LinkedList<>();

    JSONArray cocheList = (JSONArray) parkingObject.get("listCoches");

    // JSONObject coche = new JSONObject();

    for (int i = 0; i < cocheList.size(); i++) {
      JSONObject obj = (JSONObject) cocheList.get(i);

      // Coche Details
      Coche coche = new Coche();
      coche.setColorVehiculo(ColorVehiculo.fromStringToColorVehiculo((String) obj.get("colorVehiculo")));
      // System.out
      // .println("colorVehiculo --> " + ColorVehiculo.fromStringToColorVehiculo((String) obj.get("colorVehiculo")));
      coche.setAceptadoParking((boolean) obj.get("aceptadoParking"));
      parkingListCoches.add(coche);
    }
    log.debug("Se obtiene del JSON la lista de coches");
    return parkingListCoches;
  }

  private static List<Moto> parseMotoObject(JSONObject parkingObject) {

    // Coche list
    List<Moto> parkingListMotos = new LinkedList<>();

    JSONArray motoList = (JSONArray) parkingObject.get("listMotos");

    for (int i = 0; i < motoList.size(); i++) {
      JSONObject obj = (JSONObject) motoList.get(i);

      // Coche Details
      Moto moto = new Moto();
      moto.setColorVehiculo(ColorVehiculo.fromStringToColorVehiculo((String) obj.get("colorVehiculo")));
      // System.out
      // .println("colorVehiculo --> " + ColorVehiculo.fromStringToColorVehiculo((String) obj.get("colorVehiculo")));
      moto.setAceptadoParking((boolean) obj.get("aceptadoParking"));
      moto.setTipoMoto(TipoMoto.fromStringToTipoMoto((String) obj.get("tipoMoto")));
      // System.out.println("tipoMoto --> " + TipoMoto.fromStringToTipoMoto((String) obj.get("tipoMoto")));
      parkingListMotos.add(moto);
    }
    log.debug("Se obtiene del JSON la lista de motos");
    return parkingListMotos;
  }

  private static List<Bicicleta> parseBicicletaObject(JSONObject parkingObject) {

    // Coche list
    List<Bicicleta> parkingListBicicletas = new LinkedList<>();

    JSONArray bicicletaList = (JSONArray) parkingObject.get("listBicicletas");

    for (int i = 0; i < bicicletaList.size(); i++) {
      JSONObject obj = (JSONObject) bicicletaList.get(i);

      // Coche Details
      Bicicleta bicicleta = new Bicicleta();
      bicicleta.setColorVehiculo(ColorVehiculo.fromStringToColorVehiculo((String) obj.get("colorVehiculo")));
      // System.out
      // .println("colorVehiculo --> " + ColorVehiculo.fromStringToColorVehiculo((String) obj.get("colorVehiculo")));
      bicicleta.setAceptadoParking((boolean) obj.get("aceptadoParking"));
      parkingListBicicletas.add(bicicleta);
    }
    log.debug("Se obtiene del JSON la lista de bicicletas");
    return parkingListBicicletas;
  }
}
