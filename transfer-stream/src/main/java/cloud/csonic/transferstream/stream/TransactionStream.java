package cloud.csonic.transferstream.stream;

import cloud.csonic.transferstream.serde.AppSerdes;
import com.example.types.StatisticsTransaction;
import com.example.types.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

import java.time.*;

import static java.util.stream.Collectors.toList;

@Configuration
@Slf4j
public class TransactionStream {



    KeyValueMapper<Windowed<String>,StatisticsTransaction,KeyValue<String,StatisticsTransaction>> transformAddDates = (kwind,input)->KeyValue.pair(kwind.key(), new StatisticsTransaction()
            .withAcountId(kwind.key())
            .withStarTime(Instant.ofEpochMilli(kwind.window().start()).atZone(ZoneOffset.of("-05:00")))
            .withEndTime(Instant.ofEpochMilli(kwind.window().end()).atZone(ZoneOffset.of("-05:00")))
            .withTotalAmount(input.getTotalAmount())
            .withNumberOfTransactions(input.getNumberOfTransactions()));


    @Bean
    public KStream<String, Transaction> ksTransactions(StreamsBuilder streamsBuilder) {

        KStream<String, Transaction> ksSource = streamsBuilder.stream("t.transactions",
                        Consumed.with(Serdes.String(), AppSerdes.transactionSerde())
                                .withTimestampExtractor(new AppTimestampExtractor()));

        ksSource.groupBy((key,transaction)->transaction.getOriginId(),Grouped.with(Serdes.String(),AppSerdes.transactionSerde()))
                .windowedBy(TimeWindows.of(Duration.ofMinutes(5)))
                        .aggregate(()->new StatisticsTransaction()
                                        .withTotalAmount(0d)
                                        .withNumberOfTransactions(0L)
                                        .withAcountId(""),
                                (key,value,aggValue)-> {
                                    StatisticsTransaction statistics = new StatisticsTransaction()
                                            .withAcountId(key)
                                            .withTotalAmount(aggValue.getTotalAmount() + value.getAmount())
                                            .withNumberOfTransactions(aggValue.getNumberOfTransactions() + 1);
                                    return statistics;
                                },
                                Materialized.with(Serdes.String(), AppSerdes.statisticsTransactionSerde()))
                .toStream()
                .map(transformAddDates)
                .to("t.transactions.statistics",Produced.with(Serdes.String(),AppSerdes.statisticsTransactionSerde()));


        return ksSource;
    }
}


/*

StreamsBuilder streamsBuilder = new StreamsBuilder();


                streamsBuilder.stream(
                                AppConfigs.topicName,
                                Consumed.with(Serdes.ByteArray(), AppSerdes.Transaction()).withTimestampExtractor(new AppTimestampExtractor())
                        )
                        .groupBy((k,v)->v.getAccountId(),Grouped.with(AppSerdes.String(),AppSerdes.Transaction()))
                        .windowedBy(TimeWindows.of(Duration.ofMinutes(5)))
                        .aggregate(()->new StatisticsTransaction()
                                .withTotalAmount(0d)
                                .withLastTime("1900-01-01T00:00:00.00Z")
                                .withNumberOfTransactions(0L)
                                .withName("nuevo"),
                                (k, inValue, aggValue) -> {
                                    aggValue.setName(inValue.getAccountId());
                                    aggValue.setTotalAmount(aggValue.getTotalAmount() + inValue.getAmount());

                                    Long txDate = Instant.parse(inValue.getTime()).toEpochMilli();
                                    Long txBalance =  Instant.parse(aggValue.getLastTime()).toEpochMilli();

                                    if(txDate>txBalance){
                                        aggValue.setLastTime(inValue.getTime());
                                    }else{
                                        aggValue.setLastTime(aggValue.getLastTime());
                                    }

                                    aggValue.setNumberOfTransactions(aggValue.getNumberOfTransactions()+1L);
                                    return aggValue;


                        }, Materialized.with(Serdes.String(), AppSerdes.StatisticsTransaction()))
                        .toStream().foreach((kwind,value)->logger.info("AppID:{},Range:{},{}-count:{}",
                                    kwind.window().hashCode(),
                                    Instant.ofEpochMilli(kwind.window().start()).atOffset(ZoneOffset.UTC),
                                    Instant.ofEpochMilli(kwind.window().end()).atOffset(ZoneOffset.UTC),
                                    value));


* */