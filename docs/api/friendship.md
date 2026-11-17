# Просмотр списка друзей

GET /api/friendships <br>

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