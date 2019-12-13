package co.com.giosoft.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase que lanza la aplicación de lectura y escritura en cache como springboot autocontenido
 * @author Giovany Villegas
 */


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}