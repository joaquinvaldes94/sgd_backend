# # Usar una imagen oficial de OpenJDK como imagen base
# FROM openjdk:17-jdk-alpine as build

# # Establecer el directorio de trabajo en el contenedor
# WORKDIR /app

# # Instalar Maven directamente
# RUN apk add --no-cache maven

# # Copiar el archivo pom.xml y descargar las dependencias
# COPY pom.xml .
# RUN mvn dependency:go-offline

# # Copiar el código fuente del proyecto al contenedor
# COPY . .

# # Construir la aplicación para producción
# RUN mvn package -DskipTests

# # Verificar el contenido del directorio target
# RUN ls /app/target/

# # Crear una nueva etapa a partir de la imagen de OpenJDK para ejecutar la aplicación
# FROM openjdk:17-jdk-alpine

# # Establecer el directorio de trabajo en el contenedor
# WORKDIR /app

# # Copiar el archivo JAR generado desde la etapa de construcción anterior
# COPY --from=build /app/target/*.jar app.jar

# CMD ["java", "-jar", "app.jar"]

# Etapa de construcción
FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
# Copia el archivo pom.xml y los fuentes
COPY pom.xml .
COPY src ./src
# Construye la aplicación
RUN mvn clean package

# Etapa de ejecución
FROM openjdk:17-jdk-alpine
WORKDIR /app
# Copia el JAR construido desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar
# Expone el puerto en el que tu aplicación se ejecutará
EXPOSE 8080
# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
