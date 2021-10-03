#Seleciona a imagem para o build
FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /app

#Copia o fonte projeto para o workdir
COPY ./ ./

RUN mvn clean package

#Criar a imagem docker do .jar

FROM openjdk:11-jre-slim

COPY --from=build /app/target/*.jar /app.jar

CMD ["java",  "-jar", "/app.jar"]