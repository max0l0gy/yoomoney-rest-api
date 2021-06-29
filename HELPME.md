## Build
````
./mvnw package
````
## Docker
Install

https://docs.docker.com/engine/install/centos/

Build
````
docker build -t maxmorev/yoomoney-rest-api .
````
Run
````
docker run -i --rm -p 8080:8080 \
-e YOOMONEY_SHOP_ID=YOOMONEY_SHOP_ID \
-e YOOMONEY_SECRET_KEY=YOOMONEY_SECRET_KEY \
--name yoomoney-rest-api \
maxmorev/yoomoney-rest-api
````

### Prepare secrets 
You can, of course, provide the clear text content using the stringData for Secret creation
https://kubernetes.io/docs/concepts/configuration/secret/#basic-authentication-secret
```
echo $YOOMONEY_SHOP_ID
echo $YOOMONEY_SECRET_KEY
```
