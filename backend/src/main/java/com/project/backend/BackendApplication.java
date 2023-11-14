package com.project.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Backend application.
 */
@SpringBootApplication
@EntityScan("com.project.backend.models.entities")
@EnableJpaRepositories("com.project.backend.models.repositories")
@ComponentScan("com.project.backend")
public class BackendApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(BackendApplication.class, args);
  }

}
