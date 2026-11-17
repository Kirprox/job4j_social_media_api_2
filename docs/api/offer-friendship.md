# Предложение дружбы

POST /api/offer-friendships/create <br>
Content-Type: application/json

```json
{
  "fromUserId": 1,
  "toUserId": 2
}
```
### ответ
HTTP/1.1 201 Created
Content-Type: application/json

```json
{
  "id": 10,
  "fromUserId": 1,
  "toUserId": 2,
  "status": "PENDING",
  "createdAt": "2026-09-22Т10:15:00Z"
}
```
## Ошибки
### Предложение дружбы самому себе
Возникает, если fromUserId и toUserId совпадают
#### ответ
HTTP/1.1 400 Bad Request <br>
Content-Type: application/json
```json
{
  "code": "Self_Friendship",
  "message": "Нельзя предложить дружбу самому себе"
}
```

### Пользователь не найден
Возникает, если id пользователя, к которому отправлен запрос на дружбу, не найден в бд
#### ответ
HTTP/1.1 404 Not Found <br>
Content-Type: application/json
```json
{
  "code": "User-Not-Found",
  "message": "Пользователь не найден"
}
```

### Активное предложение уже существует
Возникает, если повторно отправить заявку в друзья
#### ответ
HTTP/1.1 204 No Content
Content-Type: application/json
```json
{
  "code": "request-already-send",
  "message": "предложение о дружбе уже было отправлено"
}
```


# Принятие дружбы

POST /api/offer-friendships/accept <br>
Content-Type: application/json

```json
{
  "fromUserId": 1,
  "toUserId": 2
}
```
### ответ
HTTP/1.1 200 OK
Content-Type: application/json

```json
{
  "id": 10,
  "fromUserId": 1,
  "toUserId": 2,
  "status": "ACCEPTED",
  "createdAt": "2026-09-22Т10:15:00Z"
}
```

# Отклонение заявки

POST /api/offer-friendships/reject <br>
Content-Type: application/json

```json
{
  "fromUserId": 1,
  "toUserId": 2
}
```
### ответ
HTTP/1.1 200 OK
Content-Type: application/json

```json
{
  "id": 10,
  "fromUserId": 1,
  "toUserId": 2,
  "status": "REJECTED",
  "createdAt": "2026-09-22Т10:15:00Z"
}
```

# Просмотр списка входящих заявок в друзья

GET /api/offer-friendships/incoming <br>

### ответ
HTTP/1.1 200 OK
Content-Type: application/json

```json
[
  {
    "id": 10,
    "fromUserId": 2,
    "toUserId": 1,
    "status": "PENDING",
    "createAt": "2026-09-22Т10:15:00Z"
  },
  {
    "id": 111,
    "fromUserId": 3,
    "toUserId": 1,
    "status": "PENDING",
    "createdAt": "2026-09-22Т10:15:00Z"
  }
]
```

# Просмотр списка исходящих заявок в друзья

GET /api/offer-friendships/outgoing <br>

### ответ
HTTP/1.1 200 OK
Content-Type: application/json

```json
[
  {
    "id": 10,
    "fromUserId": 1,
    "toUserId": 2,
    "status": "PENDING",
    "createdAt": "2026-09-22Т10:15:00Z"
  },
  {
    "id": 111,
    "fromUserId": 1,
    "toUserId": 22,
    "status": "PENDING",
    "createdAt": "2026-09-22Т10:15:00Z"
  }
]
```
