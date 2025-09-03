# Tarot Reading Service

Web-сервис для гадания на картах Таро с REST API.

## Описание

Сервис предоставляет возможности гадания на картах Таро по одной и трем картам, а также справочник по картам Таро. Использует Spring Boot для backend-разработки с MongoDB для хранения данных о картах и PostgreSQL для учетных данных.

## Технологии

- **Spring Boot** 3.5.5
- **MongoDB** - хранение данных о картах Таро
- **PostgreSQL** - хранение учетных данных
- **Liquibase** - миграции базы данных
- **Maven** - система сборки

## Структура проекта

```
src/
├── main/
│   ├── java/ru/hbm/krovotarot/
│   │   ├── controller/                 # REST контроллеры
│   │   ├── service/                    # Бизнес логика
│   │   ├── model/                      # Модели данных
│   │   ├── repository/                 # Репозитории
│   │   └── KrovoTarotApplication.java  # Главный класс приложения
│   └── resources/
│       ├── application.yml             # Конфигурация
│       └── db/changelog/               # Liquibase миграции
```

## API Endpoints

### Справочник карт Таро

- `GET /api/tarot/cards` - Получить список всех карт
- `GET /api/tarot/cards/{id}` - Получить конкретную карту по ID

### Гадания

- `GET /api/tarot/reading/single` - Гадание на одну карту
- `GET /api/tarot/reading/three` - Гадание на три карты

## Конфигурация

### application.yml

```yaml
server:
  port: 8080

spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/tarot_db
    jpa:
      hibernate:
        ddl-auto: none
      show-sql: false
      properties:
        hibernate:
          dialect: org.hibernate.dialect.PostgreSQLDialect
  
  datasource:
    url: jdbc:postgresql://localhost:5432/tarot_auth
    username: username
    password: password
    driver-class-name: org.postgresql.Driver

  liquibase:
    enabled: true
    change-log: classpath:db/changelog/db.changelog-master.yaml
```

## Запуск приложения

1. Убедитесь, что запущены MongoDB и PostgreSQL
2. Выполните команду:
   ```bash
   mvn spring-boot:run
   ```

## Лицензия

Этот проект распространяется под лицензией Apache License 2.0. Подробности в файле [LICENSE](LICENSE).