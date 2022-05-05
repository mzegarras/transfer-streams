
# Realtime processing con Kafka Stream

![Kafka Streams](./images/kstreams.png "Architecture")

## Microbatch
![Kafka Streams](./images/microbatch.png "Architecture")

## Real time processing
![Realtime Processing](./images/realtime.png "Realtime Processing")

## Resumen de operaciones
![Realtime Processing](./images/ResumenTX.png "Realtime Processing")

### Paso a paso


https://youtu.be/emutAnQw_vs

## Run

```shell

cd ./scripts

docker-compose up

docker exec -it kafka01 bash

kafka-console-consumer --topic t.transactions --bootstrap-server localhost:9092 \
  --property "print.key=true"\
  --property "key.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --property "value.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --from-beginning

kafka-console-consumer --topic t.transactions.statistics --bootstrap-server localhost:9092 \
  --property "key.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --property "value.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --from-beginning  

kafka-topics --list --bootstrap-server localhost:9092

```

## KSQL
```shell
docker exec -it ksqldb-cli ksql http://ksqldb-server:8088

SET 'auto.offset.reset' = 'earliest';

drop STREAM transactionsST;

CREATE STREAM transactionsST (originId VARCHAR,destinationId VARCHAR, amount DOUBLE, created VARCHAR) 
WITH (
    kafka_topic='t.transactions', 
    value_format='json',
    timestamp='created',
    timestamp_format='yyyy-MM-dd''T''HH:mm:ssX' 
  );
 
select * from transactionsST; 
                
                      
CREATE TABLE transactionsDaily AS
  select originId,
          SUM(amount) AS TOTAL,
          COUNT(1) AS COUNT
  FROM transactionsST
  WINDOW TUMBLING (SIZE 1 DAY) 
  GROUP BY originId
  EMIT CHANGES;
  
SELECT * FROM transactionsDaily;
SELECT * FROM transactionsDaily EMIT CHANGES;

SELECT 
      originId,
       TIMESTAMPTOSTRING(WINDOWSTART, 'yyyy-MM-dd HH:mm:ss.SSS') AS ts_start,
       TIMESTAMPTOSTRING(WINDOWEND, 'yyyy-MM-dd HH:mm:ss.SSS') AS ts_end,
       TOTAL,
       COUNT
FROM transactionsDaily
EMIT CHANGES;



docker exec -it kafka01 bash

kafka-console-consumer --topic TRANSACTIONSDAILY --bootstrap-server localhost:9092 \
  --property "key.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --property "value.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --from-beginning
  
docker exec -it schema-registry bash

kafka-avro-console-consumer --bootstrap-server kafka01:9092,kafka02:9092,kafka03:9092 \
  --topic t.transactions \
  --from-beginning \
  --property schema.registry.url=http://schema-registry:8081

kafka-avro-console-consumer --bootstrap-server kafka01:9092,kafka02:9092,kafka03:9092 \
  --topic t.otp \
  --from-beginning \
  --property schema.registry.url=http://schema-registry:8081
  
```



## SCHEMA REGISTRY
```shell
curl http://localhost:8081/subjects


curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" \
    --data '{"schema":"{\"namespace\":\"cloud.csonic.types.avro\",\"type\":\"record\",\"name\":\"TransactionEvent\",\"fields\":[{\"name\":\"OriginId\",\"type\":[\"null\",\"string\"]},{\"name\":\"DestinationId\",\"type\":[\"null\",\"string\"]},{\"name\":\"Amount\",\"type\":[\"null\",\"double\"]},{\"name\":\"Created\",\"type\":[\"null\",{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}]},{\"name\":\"TransactionId\",\"type\":[\"null\",\"string\"]}]}"}' \
    http://localhost:8081/subjects/t.transactions-value/versions


curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" \
    --data '{"schema":"{\"namespace\":\"cloud.csonic.types.avro\",\"type\":\"record\",\"name\":\"OtpEvent\",\"fields\":[{\"name\":\"Code\",\"type\":[\"null\",\"string\"]},{\"name\":\"TransactionId\",\"type\":[\"null\",\"string\"]}]}"}' \
    http://localhost:8081/subjects/t.otp-value/versions

curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" \
    --data '{"schema":"{\"namespace\":\"cloud.csonic.types.avro\",\"type\":\"record\",\"name\":\"OtpEvent\",\"fields\":[{\"name\":\"Code\",\"type\":[\"null\",\"string\"]},{\"name\":\"TransactionId\",\"type\":[\"null\",\"string\"]}]}"}' \
    http://localhost:8081/subjects/t.opt.user-value/versions



curl http://localhost:8081/subjects/t.transactions.avro-value/versions
curl http://localhost:8081/subjects/t.transactions.avro-value/versions/1
```

## KSQL AVRO
```shell
docker exec -it ksqldb-cli ksql http://ksqldb-server:8088

SET 'auto.offset.reset' = 'earliest';

drop STREAM transactions_st;

CREATE STREAM transactions_st (originId VARCHAR,destinationId VARCHAR, amount DOUBLE, created bigint,transactionId VARCHAR) 
WITH (
    kafka_topic='t.transactions', 
    value_format='avro',
    timestamp = 'created'
  );

select * from transactions_st limit 10 ;  
select * from transactions_st where originId = '19310002' limit 10 ;  
select originId,TIMESTAMPTOSTRING(created, 'yyyy-MM-dd HH:mm:ss.SSS') AS rowtime_formatted from transactions_st EMIT CHANGES;
select originId,TIMESTAMPTOSTRING(created, 'yyyy-MM-dd HH:mm:ss.SSS') AS rowtime_formatted from transactions_st limit 10;       
                      
CREATE TABLE transactionsDaily AS
  select originId,
          SUM(amount) AS TOTAL,
          COUNT(1) AS COUNT
  FROM transactions_st
  WINDOW TUMBLING (SIZE 1 DAY) 
  GROUP BY originId
  EMIT CHANGES;

select originId,amount,TIMESTAMPTOSTRING(created, 'yyyy-MM-dd HH:mm:ss.SSS') from transactions_st where originId='200';
select * FROM transactionsDaily;
SELECT ORIGINID,TIMESTAMPTOSTRING(WINDOWSTART, 'yyyy-MM-dd HH:mm:ss.SSS'),TOTAL,COUNT FROM transactionsDaily EMIT CHANGES;

SELECT 
      originId,
       TIMESTAMPTOSTRING(WINDOWSTART, 'yyyy-MM-dd HH:mm:ss.SSS') AS ts_start,
       TIMESTAMPTOSTRING(WINDOWEND, 'yyyy-MM-dd HH:mm:ss.SSS') AS ts_end,
       TOTAL,
       COUNT
FROM transactionsDaily where originId = '19310001'
EMIT CHANGES;



kafka-console-consumer --topic TRANSACTIONSDAILY --bootstrap-server localhost:9092 \
  --property "key.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --property "value.deserializer=org.apache.kafka.common.serialization.StringDeserializer" \
  --from-beginning  


```


## KSQL AVRO OPT
```shell

CREATE STREAM opt_st (Code VARCHAR,TransactionId VARCHAR) 
WITH (
    kafka_topic='t.otp', 
    value_format='avro');

select * from opt_st;


  
CREATE STREAM opt_user_st (Code VARCHAR,TransactionId VARCHAR) 
WITH (
    kafka_topic='t.opt.user', 
    value_format='avro');
    
select * from opt_user_st;


select *
from opt_st o
inner join opt_user_st ou
WITHIN (0 SECONDS, 1 DAYS)
on o.TransactionId = ou.TransactionId
WHERE o.Code = ou.Code
EMIT CHANGES
LIMIT 3;
  
  #WITHIN (0 SECONDS, 1 DAYS)
select O.Code, O.TransactionId
  from opt_st O
  inner join transactions_st t 
  WITHIN (0 SECONDS, 1 DAYS)
  on o.TransactionId = t.TransactionId
  EMIT CHANGES
  LIMIT 3;
  
  
```
