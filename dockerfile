# Usa uma imagem base com Maven e JDK
FROM maven:3.9.9-eclipse-temurin-22 AS build

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml /app/pom.xml
WORKDIR /app

RUN mvn install

COPY src ./src

# Executa o Maven para construir o projeto
RUN mvn clean package

# Segunda etapa: cria a imagem para rodar o JAR
FROM eclipse-temurin:22-jdk

# Copia o JAR gerado para o contêiner
COPY --from=build /app/target/app.jar app.jar

EXPOSE 8080

# Define o comando de inicialização
ENTRYPOINT ["java", "-jar", "/app.jar"]