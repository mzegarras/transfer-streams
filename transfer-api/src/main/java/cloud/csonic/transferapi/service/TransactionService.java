package cloud.csonic.transferapi.service;



import com.example.types.Transaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionService {

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public void publish(Transaction transaction){

        kafkaTemplate.send("t.transactions",transaction.getOriginId(),transaction)
                .addCallback(stringTicketSendResult -> {
                            log.info("Ok:{}",transaction.toString());
                        },
                        throwable -> {
                            log.error("error",throwable);
                        });
    }

}
