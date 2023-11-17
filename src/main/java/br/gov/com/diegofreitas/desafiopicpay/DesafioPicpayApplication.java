package br.gov.com.diegofreitas.desafiopicpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DesafioPicpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioPicpayApplication.class, args);
    }

}
