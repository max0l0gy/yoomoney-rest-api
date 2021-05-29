# yoomoney-rest-api project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Testing with WireMock
Building a Rest API Microservice with Quarkus and Wiremock

Setting up a mock HTTP server, against which tests are run, is a common testing pattern.

Mappings of Stubs with Json is great and useful feature.

>You can also use the JSON API via files. When the WireMock server starts it search two directories under the current one: mappings and __files
> For test scope WireMock server by default searching in src/test/resources/mappings

[Testing Quarkus Microservice using HTTP Server for tests](https://quarkus.io/guides/rest-client#using-a-mock-http-server-for-tests)

[WireMock](http://wiremock.org/docs/getting-started/)

[Stubbing with Json Mappings](http://wiremock.org/docs/stubbing/)

## YooMoney short API review

https://yookassa.ru/en/developers/payment-forms/widget#payment-process

````
curl https://api.yookassa.ru/v3/payments \
  -X POST \
  -u <shopId>:<secret_key> \
  -H 'Idempotence-Key: 06' \
  -H 'Content-Type: application/json' \
  -d '{
        "amount": {
          "value": "2.00",
          "currency": "RUB"
        },
        "confirmation": {
          "type": "embedded"
        },
        "description": "Order No. 72"
      }'
````

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `paypal-rest-api-1.0.0-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/paypal-rest-api-1.0.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/paypal-rest-api-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

