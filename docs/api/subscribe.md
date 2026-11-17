# Просмотр списка подписчиков

GET /api/subscribes/followers <br>

### ответ
HTTP/1.1 200 OK
Content-Type: application/json

```json
[
  {
    "id": 2,
    "name": "Алексей"
  },
  {
    "id": 3,
    "name": "Иван"
  }
]
```

# Просмотр списка подписок

GET /api/subscribes <br>

### ответ
HTTP/1.1 200 OK
Content-Type: application/json

```json
[
  {
    "id": 2,
    "name": "Алексей"
  },
  {
    "id": 3,
    "name": "Иван"
  }
]
```