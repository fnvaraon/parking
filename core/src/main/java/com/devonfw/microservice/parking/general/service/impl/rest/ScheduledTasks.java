package com.devonfw.microservice.parking.general.service.impl.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author fnvaraon
 *
 */
@Component
public class ScheduledTasks {

  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /**
   *
   */
  // @Scheduled(fixedRate = 300000)
  @Scheduled(cron = "0 0/5 * * * *")
  public void runScheduledServices() {

    log.info("Starting the batch process {}", dateFormat.format(new Date()));

    // String[] args = new String[10];
    // try {
    // BatchProcessingApplication.main(args);
    // } catch (Exception e) {
    // e.printStackTrace();
    // e.getMessage();
    // }

    log.info("Finishing the batch process {}", dateFormat.format(new Date()));
  }
}
