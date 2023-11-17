package br.gov.com.diegofreitas.desafiopicpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/procucer/{message}")
    public void producer (@PathVariable("message") String message){
        this.kafkaTemplate.send("teste.teste-menssage",message);
    }
}
