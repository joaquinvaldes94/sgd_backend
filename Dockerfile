#  Usar una imagen base que incluya tanto Maven como el JDK de Java 17
FROM maven:3.8.4-openjdk-17 as build

WORKDIR /usr/src/app

COPY . .

# Opcional: Puedes incluir una etapa de dependencia para mejorar los tiempos de construcción
# al cachear las dependencias de Maven
RUN mvn dependency:go-offline

EXPOSE 807

ENTRYPOINT ["mvn", "spring-boot:run"]