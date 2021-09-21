package cloud.csonic.transferstream.serde;

import com.example.types.StatisticsTransaction;
import com.example.types.Transaction;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class AppSerdes extends Serdes {

    public static final class TransactionSerde extends WrapperSerde<Transaction> {
        public TransactionSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>());
        }
    }

    public static final class StatisticsTransactionSerde extends WrapperSerde<StatisticsTransaction> {
        public StatisticsTransactionSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>());
        }
    }

    public static final Serde<Transaction> transactionSerde() {
        TransactionSerde serde = new TransactionSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, Transaction.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static final Serde<StatisticsTransaction> statisticsTransactionSerde() {
        StatisticsTransactionSerde serde = new StatisticsTransactionSerde();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, StatisticsTransaction.class);
        serde.configure(serdeConfigs, false);

        return serde;
    }

}
