package nl.first8.generativetesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot entry point for execution and configuration.
 */
@SpringBootApplication
public interface Application {

    /**
     * @param args to be ignored
     */
    static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}