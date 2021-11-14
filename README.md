# Spring Kafka Demo

This demo brings together a bunch of stuff from
 * [Intro to Apache Kafka with Spring - Baeldung](https://www.baeldung.com/spring-kafka)
 * [Apache Kafka Support - Spring Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.messaging.kafka)
 * [Guide to Setting Up Apache Kafka Using Docker - Baeldung](https://www.baeldung.com/ops/kafka-docker-setup)

to wire up a simple service with a REST endpoint that can be used to publish simple data to a Kafka topic and a Consumer that consumes
the data from the same topic and just logs it.

## Massage the endpoints

### List
```
$ curl -H "Accept:application/json" \
http://localhost:8080/stuff/list/
```

### Post
```
$ curl -H "Accept:application/json" \
-H  "Content-Type:application/json" \
http://localhost:8080/stuff/send/ \
-d @stuff.json
```
