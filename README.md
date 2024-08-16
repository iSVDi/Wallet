#Docker
For run project via docker run this commands in project's directory
```
./mvnw clean package -DskipTests
docker build . -t wallet:v1
docker-compose up
```
