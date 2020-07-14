package com.devonfw.microservice.parking.general.common.api.to.batch;

import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devonfw.microservice.parking.general.common.api.to.model.ParkingResult;

/**
 * @author fnvaraon
 *
 */
public class WriteJSONToFile {

  private static Logger log = LoggerFactory.getLogger(WriteJSONToFile.class);

  private static Random r;

  static {
    try {
      r = SecureRandom.getInstanceStrong();
    } catch (NoSuchAlgorithmException e) {
      // log.error("Error creando el valor aleatorio", e);
    }
  }

  /**
   * Vamos a parsear un objeto parkingResult a JSON y a escribirlo en un fichero
   * 
   * @param parkingResult
   */
  @SuppressWarnings("unchecked")
  public static void parseToFile(ParkingResult parkingResult) {

    log.debug("Vamos a parsear un objeto parkingResult a JSON y a escribirlo en un fichero");
    // public static void parseToFile(ParkingResult parkingResult, FileWriter file) {

    log.debug("Se extraen las propiedades de parkingResult");
    // ParkingResult properties
    JSONObject parkingDetails = new JSONObject();
    parkingDetails.put("nombre", parkingResult.getNombre());
    parkingDetails.put("numeroVehiculosColorElegido", parkingResult.getNumeroVehiculosColorElegido());

    // List of Coche //////////////////////////////////////////////////////////
    log.debug("Se extrae la lista de coches");
    JSONArray parkingListCoches = new JSONArray();
    // parkingListCoches.addAll(parkingResult.getListCoches());

    // For each Coche

    for (int i = 0; i < parkingResult.getListCoches().size(); i++) {
      JSONObject coche = new JSONObject();
      coche.put("colorVehiculo", parkingResult.getListCoches().get(i).getColorVehiculo().toString());
      coche.put("aceptadoParking", parkingResult.getListCoches().get(i).isAceptadoParking());
      parkingListCoches.add(i, coche);
    }
    // ParkingResult lists
    parkingDetails.put("listCoches", parkingListCoches);

    // List of Moto ////////////////////////////////////////////////////////////////
    log.debug("Se extrae la lista de motos");
    JSONArray parkingListMotos = new JSONArray();
    // parkingListMotos.addAll(parkingResult.getListMotos());

    // For each Moto
    for (int i = 0; i < parkingResult.getListMotos().size(); i++) {
      JSONObject moto = new JSONObject();
      moto.put("colorVehiculo", parkingResult.getListMotos().get(i).getColorVehiculo().toString());
      moto.put("aceptadoParking", parkingResult.getListMotos().get(i).isAceptadoParking());
      moto.put("tipoMoto", parkingResult.getListMotos().get(i).getTipoMoto().toString());
      parkingListMotos.add(i, moto);
    }
    // ParkingResult lists
    parkingDetails.put("listMotos", parkingListMotos);

    // List of Bicicleta ///////////////////////////////////////////////////////////////////
    log.debug("Se extrae la lista de bicicletas");
    JSONArray parkingListBicicletas = new JSONArray();
    // parkingListBicicletas.addAll(parkingResult.getListBicicletas());

    // For each Bicicleta
    for (int i = 0; i < parkingResult.getListBicicletas().size(); i++) {
      JSONObject bicicleta = new JSONObject();
      bicicleta.put("colorVehiculo", parkingResult.getListBicicletas().get(i).getColorVehiculo().toString());
      bicicleta.put("aceptadoParking", parkingResult.getListBicicletas().get(i).isAceptadoParking());
      parkingListBicicletas.add(i, bicicleta);
    }
    // ParkingResult lists
    parkingDetails.put("listBicicletas", parkingListBicicletas);

    // ParkingResult Object
    JSONObject parkingObject = new JSONObject();
    parkingObject.put("parking", parkingDetails);

    int aleatorio = r.nextInt(100);

    // Write JSON file
    log.debug("Escribimos el JSON en un fichero con nombre aleatorio");
    try (FileWriter file = new FileWriter("C:\\Devon-dist_3.1.0\\parkingacademy\\core\\file" + aleatorio + ".json")) {
      // try (FileWriter file = new FileWriter("C:\\Devon-dist_3.1.0\\parkingacademy\\core\\file1.json")) {

      file.write(parkingObject.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
