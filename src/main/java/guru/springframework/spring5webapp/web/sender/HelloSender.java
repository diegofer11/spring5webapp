package guru.springframework.spring5webapp.web.sender;

import guru.springframework.spring5webapp.web.config.JmsConfig;
import guru.springframework.spring5webapp.web.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {

        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Mensaje para la cola de mensajería")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
    }
}
