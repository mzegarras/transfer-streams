package cloud.csonic.transferapi.service;


import cloud.csonic.types.avro.TransactionEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionService {


    private final KafkaTemplate<String, TransactionEvent> kafkaTemplateAvro;


    public void publishAvro(TransactionEvent event){



        kafkaTemplateAvro.send("t.transactions",event.getOriginId(),event)
                .addCallback(stringTicketSendResult -> {
                            log.info("Ok:{}",event);
                        },
                        throwable -> {
                            log.error("error",throwable);
                        });
    }

}
