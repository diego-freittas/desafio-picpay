package br.gov.com.diegofreitas.desafiopicpay.infra.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {


    @Bean
    // definir como consomen uma mensagem
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory(){
        var kafkaFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        kafkaFactory.setConsumerFactory(consumer());
        return kafkaFactory;
    }

    private ConsumerFactory<String, String> consumer() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"url e porta do kafka");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"earliest");
        return new DefaultKafkaConsumerFactory<>(props);
    }

    //definir como ele vai produzir as mensagens
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producer());
    }

    private ProducerFactory<String, String> producer() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"url e porta do kafka");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }
}
