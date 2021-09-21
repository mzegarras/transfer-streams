
# Realtime processing con Kafka Stream

![Kafka Streams](./images/kstreams.png "Architecture")


## Microbatch
![Kafka Streams](./images/microbatch.png "Architecture")

## Real time processing
![Realtime Processing](./images/realtime.png "Realtime Processing")

## Caso práctico

![Realtime Processing](./images/realtime.png "Realtime Processing")

### Paso a paso


https://youtu.be/QMSdKVNpddc

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


```
