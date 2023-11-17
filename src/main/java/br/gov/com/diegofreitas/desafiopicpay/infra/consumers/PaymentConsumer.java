package br.gov.com.diegofreitas.desafiopicpay.infra.consumers;


import br.gov.com.diegofreitas.desafiopicpay.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class PaymentConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PaymentService paymentService;
    // o Kafka pode garantir atraves das da modelage de Partição para garantir que
    // se tivermos varios concumers o kafka pode garantir que um memso id seja enviado para
    // o mesmo consumer
    // É preciso ter as constraints no banco de dados como ultima camada de segurança
    public PaymentConsumer(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "payment")
    public void consume(@Header(value = "transaction", required = false) Long transactionId,
                        @Payload Double value, AcknowledgeMode acknowledgeMode) throws InterruptedException {
        try {
            logger.info("Consuming payment whit transactionid {} and value {}", transactionId, value);
            // proximo passo mudar de banco relacioonal para banco nosql redis
            if(paymentService.checkIfPaymentExist(transactionId)){
                logger.warn("Payment alreaddy processed, will be ignored");
            }else{
                paymentService.process(transactionId, value);
            }
        }catch (Exception e){
            logger.error("Error processing payment, Retrying ...", e);
            acknowledgeMode.wait(100000);
        }
    }
}
