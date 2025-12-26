# ------------------------------------------------------------------------
# FASE 1: BUILDER - Compila la aplicación y genera el JAR ejecutable
# ------------------------------------------------------------------------
FROM maven:3.9.5-amazoncorretto-21 AS builder

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# 1. Copia el POM y descarga las dependencias (optimiza el cache)
# Si cambias el código, pero no el POM, esta capa no se reconstruye.
COPY pom.xml .
RUN mvn dependency:go-offline

# 2. Copia todo el código fuente
COPY src/ ./src

# 3. Compila el proyecto y genera el JAR final
# Usa -DskipTests para omitir las pruebas y acelerar la compilación
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# ------------------------------------------------------------------------
# FASE 2: RUNNER - Crea la imagen ligera de ejecución
# ------------------------------------------------------------------------
# Usamos una imagen base JRE (Java Runtime Environment) de código abierto para ser ligera.
# ¡Importante! Usar la versión 21 compatible con tu proyecto.
FROM eclipse-temurin:21-jre-alpine

# Define un argumento para el nombre del JAR (lo obtendremos del pom.xml)
ARG JAR_FILE=target/cursosbkd-0.0.1-SNAPSHOT.jar

# Copia el JAR generado en la FASE 1 al directorio de la imagen final
# El nombre del JAR se genera a partir de <artifactId>-<version> en tu pom.xml
COPY --from=builder /app/${JAR_FILE} app.jar

# Define el puerto en el que la aplicación escuchará
# Render inyectará su propia variable PORT, pero esto sirve como fallback
ENV PORT 8080

# El comando de inicio que se ejecutará al iniciar el contenedor
# Usa java -jar para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]