

# Техническое задание: Social Media API

Цель проекта: Разработать RESTful API для социальной медиа платформы, позволяющей пользователям регистрироваться, входить в систему, создавать посты, переписываться, подписываться на других пользователей и получать свою ленту активности.

Что появится в проекте
К завершению курса Social Media API будет включать:

- REST API и OpenAPI-контракт;
- PostgreSQL и управляемые миграции;
- Spring Data JPA и транзакции;
- аутентификацию через Keycloak;
- модульные, интеграционные и сценарные тесты;
- структурные логи в Loki;
- метрики для Prometheus и Grafana;
- трассы OpenTelemetry в Jaeger;
- асинхронные уведомления;
- воспроизводимое развертывание через Docker Compose.

Команда для подключения к локальной базе "psql -U postgres" 
### Команды для работы с приложением

Все команды необходимо выполнять из корня проекта.

#### Windows (PowerShell)

Создать `.env` из примера:

```powershell
Copy-Item .env.example .env
```

Запустить PostgreSQL в Docker:

```powershell
docker compose up -d
```

Запустить тесты:

```powershell
.\mvnw.cmd test
```

Запустить приложение:

```powershell
.\mvnw.cmd spring-boot:run
```

#### Linux и macOS

Создать `.env` из примера:

```bash
cp .env.example .env
```

Если у Maven Wrapper нет права на выполнение, выдать его:

```bash
chmod +x mvnw
```

Запустить PostgreSQL в Docker:

```bash
docker compose up -d
```

Запустить тесты:

```bash
./mvnw test
```

Запустить приложение:

```bash
./mvnw spring-boot:run
```

Для остановки приложения нажмите `Ctrl+C` в терминале.

Остановить контейнеры можно командой (одинаковой для всех операционных систем):

```bash
docker compose down
```

## Ссылка на контракт API [API-контракт](docs/api/openapi.yaml)


