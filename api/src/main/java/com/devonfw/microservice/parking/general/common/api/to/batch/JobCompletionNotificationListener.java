package com.devonfw.microservice.parking.general.common.api.to.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;

/**
 * @author fnvaraon
 *
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final JdbcTemplate jdbcTemplate;

  /**
   *
   * The constructor.
   * 
   * @param jdbcTemplate
   */
  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {

    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   *
   */
  @Override
  public void afterJob(JobExecution jobExecution) {

    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      this.jdbcTemplate
          .query("SELECT nombreParking, plazasCoches,plazasMotos,plazasBicicletas,color FROM parkingRest",
              (rs, row) -> new ParkingRest(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)))
          .forEach(parkingRest -> log.info("Found <" + parkingRest + "> in the database."));
    }
  }
}
