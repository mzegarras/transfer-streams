package cloud.csonic.transferstream.stream;

import com.example.types.Transaction;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

public class AppTimestampExtractor implements TimestampExtractor {

    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long prevTime) {
        Transaction record = (Transaction) consumerRecord.value();

        long eventTime = record.getCreated().toInstant().toEpochMilli();
        return ((eventTime > 0) ? eventTime : prevTime);

    }



}