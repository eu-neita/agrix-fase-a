# Estágio de construção
FROM maven:3-openjdk-17 as build-image

# Definindo o diretório de trabalho
WORKDIR /to-build-app

# Copiando os arquivos necessários
COPY . .

# Instalando as dependências utilizando Maven
RUN mvn -B dependency:go-offline

# Construindo o pacote JAR utilizando Maven
RUN mvn -B clean package -DskipTests


# Estágio de construção da imagem final
FROM eclipse-temurin:17-jre-alpine

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o pacote JAR construído do estágio anterior
COPY --from=build-image /to-build-app/target/*.jar /app/app.jar

# Expondo a porta 8080
EXPOSE 8080

# Comando de entrada para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]