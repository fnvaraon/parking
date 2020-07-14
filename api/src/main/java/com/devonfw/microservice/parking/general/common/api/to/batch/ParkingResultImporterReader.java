package com.devonfw.microservice.parking.general.common.api.to.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author fnvaraon Read the file line by line
 */
public class ParkingResultImporterReader implements ItemReader {

  /**
   * The constructor.
   */
  public ParkingResultImporterReader() {

    super();
  }

  @Override
  public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

    File file = new File("C:\\Devon-dist_3.1.0\\parkingacademy\\core\\file.csv");
    // File file = new File("file.csv");
    InputStream is = new FileInputStream(file);
    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
    String[] lines = new String[100];
    String line = buf.readLine();
    StringBuilder sb = new StringBuilder();

    int j = 0;
    while (line != null) {
      lines[j] = line;
      sb.append(line).append("\n");
      line = buf.readLine();
      j++;
    }

    String realLines[] = new String[j - 1];
    for (int i = 1; i < j; i++) {
      realLines[i - 1] = lines[i];
      System.out.println(lines[i]);
    }
    buf.close();
    // String fileAsString = sb.toString();
    // System.out.println("Contents (before Java 7) : " + fileAsString);

    // Files.lines(Paths.get("file.csv"), StandardCharsets.UTF_8).forEach(System.out::println);

    return realLines;
  }

}
