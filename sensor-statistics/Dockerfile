# Используем OpenJDK 17
FROM openjdk:17-jdk-slim

RUN apt update && apt install -y curl
# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar-файл
COPY target/sensor-statistics-0.0.1-SNAPSHOT.jar app.jar

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
