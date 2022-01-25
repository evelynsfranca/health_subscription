package br.com.pipo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(
    basePackages = { "br.com.pipo.repository" },
    considerNestedRepositories = true
)
public class PipoApplication {


    public static void main(String[] args) {
        SpringApplication.run(PipoApplication.class, args);
    }

}
