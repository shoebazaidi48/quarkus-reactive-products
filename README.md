# Quarkus Reactive Producer–Consumer (ActiveMQ/AMQP) with `@Incoming` / `@Outgoing`

Minimal Quarkus app using SmallRye Reactive Messaging with ActiveMQ Artemis over AMQP 1.0 and a `Product` DTO.

## Run
1) Start ActiveMQ Artemis:
```bash
docker compose up -d
```

2) Start the app in dev mode:
```bash
mvn quarkus:dev
```

3) Watch logs to see consumed products every second.

4) Publish a product:
```bash
curl -X POST http://localhost:8080/products          -H 'Content-Type: application/json'          -d '{"id":"p-42","name":"Wireless Mouse","category":"Electronics","price":29.99}'
```
