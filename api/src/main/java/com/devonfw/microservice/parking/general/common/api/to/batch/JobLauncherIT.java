package com.devonfw.microservice.parking.general.common.api.to.batch;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fnvaraon
 *
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = { "classpath:spring-batch-context.xml", "classpath:job.xml" })
public class JobLauncherIT {

  @Autowired
  // JobLauncherTestUtils jobLauncherTestUtils;

  /**
   * @throws Exception
   */
  @Test
  public void shouldRunJob() throws Exception {

    // JobExecution jobExecution = this.jobLauncherTestUtils.launchJob();

    // Assert.assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
  }
}