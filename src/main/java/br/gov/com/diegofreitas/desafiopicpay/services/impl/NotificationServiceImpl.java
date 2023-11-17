package br.gov.com.diegofreitas.desafiopicpay.services.impl;

import br.gov.com.diegofreitas.desafiopicpay.domain.user.User;
import br.gov.com.diegofreitas.desafiopicpay.dtos.NotificationDTO;
import br.gov.com.diegofreitas.desafiopicpay.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.sendMenssage}")
    private String authApiUrl;

    @Override
    public void sendNotification(User userModel, String message) throws Exception{
        String email = userModel.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity(authApiUrl, notificationRequest, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            System.out.println("erro ao enviar notificacao");
        throw new Exception("Serviço de notificação está fora do ar");
        }

        System.out.println("Notificacao enviada para o o usuario");
    }
}
