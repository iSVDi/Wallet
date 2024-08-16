FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/wallet-0.0.1-SNAPSHOT.jar wallet.jar
ENTRYPOINT ["java","-jar","/wallet.jar"]
