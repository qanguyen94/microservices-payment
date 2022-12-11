FROM eclipse-temurin:11

WORKDIR /my-app

COPY ./target/payment-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java", "-jar", "payment-0.0.1-SNAPSHOT.jar"]
