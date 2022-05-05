package cloud.csonic.transferapi.service;



import cloud.csonic.types.avro.OtpEvent;
import cloud.csonic.types.avro.TransactionEvent;
import com.bcp.types.OtpConfirm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
@Slf4j
public class OtpService {

    private final KafkaTemplate<String, OtpEvent> kafkaTemplateAvro;

    @KafkaListener(topics = "t.transactions")
    public void listen(ConsumerRecord<String, TransactionEvent> record) {
        log.info("Consumed: {} from partition: {}", record.key(),record.value());

        var otp = String.valueOf(RandomUtils.nextInt(1000,9999));
        var txEvent = record.value();

        var event = OtpEvent.newBuilder()
                .setTransactionId(txEvent.getTransactionId())
                .setCreated( Instant.now())
                .setCode(otp)
                        .build();

        kafkaTemplateAvro.send("t.otp",event.getTransactionId(),event)
                .addCallback(stringTicketSendResult -> {
                            log.info("Publish:{}",event);
                        },
                        throwable -> {
                            log.error("error",throwable);
                        });

    }

    public void confirmOtp(OtpConfirm otpConfirm){

        var event = OtpEvent.newBuilder()
                .setTransactionId(otpConfirm.getTransactionId())
                .setCode(otpConfirm.getOtp())
                .setCreated(Instant.now())
                .build();

        kafkaTemplateAvro.send("t.opt.user",otpConfirm.getTransactionId(),event)
                .addCallback(stringTicketSendResult -> {
                            log.info("Publish:{}",event.toString());
                        },
                        throwable -> {
                            log.error("error",throwable);
                        });
    }

}
