| Команда          | Исходное состояние | Новое состояние | Изменение подписки                            | Изменение дружбы | Результат повторного вызова           |
|------------------|--------------------|-----------------|-----------------------------------------------|------------------|---------------------------------------|
| offerFriendship  | Заявка отсутствует | PENDING         | Инициатор подписывается на получателя         | без изменений    | 204 No Content, состояние не меняется |
| acceptFriendship | PENDING            | ACCEPTED        | Получатель подписывается на инициатора        | создается дружба | 204 No Content, состояние не меняется |
| rejectFriendship | PENDING            | REJECTED        | Сохраняется подписка инициатора на получателя | без изменений    | 204 No Content, состояние не меняется |
| offerFriendship  | PENDING            | PENDING         | без изменений                                 | без изменений    | 204 No Content, состояние не меняется |
| offerFriendship  | ACCEPTED           | ACCEPTED        | без изменений                                 | без изменений    | 204 No content, состояние не меняется |
| offerFriendship  | REJECTED           | REJECTED        | Без изменений                                 | без изменений    | 409 Conflict, состояние не меняется   |
| acceptFriendship | ACCEPTED           | ACCEPTED        | Без изменений                                 | без изменений    | 204 No Content, состояние не меняется |
| rejectFriendship | ACCEPTED           | ACCEPTED        | Без изменений                                 | без изменений    | 409 Conflict, состояние не меняется   |
| acceptFriendship | REJECTED           | REJECTED        | Без изменений                                 | без изменений    | 409 Conflict, состояние не меняется   |
| rejectFriendship | REJECTED           | REJECTED        | Без изменений                                 | без изменений    | 204 No Content, состояние не меняется |
