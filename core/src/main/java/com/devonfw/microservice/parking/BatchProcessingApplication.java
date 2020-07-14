package com.devonfw.microservice.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author fnvaraon
 *
 */
@SpringBootApplication
@EnableScheduling
public class BatchProcessingApplication {

  /**
   * @param args
   */

  public static void main(String[] args) throws Exception {

    SpringApplication.run(BatchProcessingApplication.class, args);

  }

}
