package com.devonfw.microservice.parking.general.common.api.to.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.devonfw.microservice.parking.general.common.api.to.ParkingRestItemProcessor;
import com.devonfw.microservice.parking.general.common.api.to.model.ParkingRest;

/**
 * @author fnvaraon
 *
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

  /**
   *
   */
  @Autowired
  public JobBuilderFactory jobBuilderFactory;

  /**
   *
   */
  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  /**
   * @return
   */
  @Bean
  public FlatFileItemReader<ParkingRest> reader() {

    return new FlatFileItemReaderBuilder<ParkingRest>().name("parkingRestItemReader")
        .resource(new ClassPathResource("sample-data.csv")).delimited()
        .names(new String[] { "nombreParking", "plazasCoches", "plazasMotos", "plazasBicicletas", "color" })
        .fieldSetMapper(new BeanWrapperFieldSetMapper<ParkingRest>() {
          {
            setTargetType(ParkingRest.class);
          }
        }).build();
  }

  /**
   * @return
   */
  @Bean
  public ParkingRestItemProcessor processor() {

    return new ParkingRestItemProcessor();
  }

  /**
   * @param dataSource
   * @return
   */
  @Bean
  public JdbcBatchItemWriter<ParkingRest> writer(DataSource dataSource) {

    return new JdbcBatchItemWriterBuilder<ParkingRest>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql(
            "INSERT INTO parkingRest (nombreParking, plazasCoches,plazasMotos,plazasBicicletas,color) VALUES (:nombreParking, :plazasCoches, :plazasMotos, :plazasBicicletas, :color)")
        .dataSource(dataSource).build();
  }

  /**
   * @param listener
   * @param step1
   * @return
   */
  @Bean
  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {

    return this.jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
        .flow(step1).end().build();
  }

  /**
   * @param writer
   * @return
   */
  @Bean
  public Step step1(JdbcBatchItemWriter<ParkingRest> writer) {

    return this.stepBuilderFactory.get("step1").<ParkingRest, ParkingRest> chunk(10).reader(reader())
        .processor(processor()).writer(writer).build();
  }
}
