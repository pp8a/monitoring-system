# Указываем базовый образ
FROM openjdk:17-jdk-slim

RUN apt update && apt install -y curl
# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar-файл в контейнер
COPY target/monitor-sensors-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]