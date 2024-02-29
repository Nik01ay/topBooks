# Инструкция по использованию topBooks
 - REST-эндпоинт: /api/top10

 - HTTP-метод: GET

Возможные параметры запроса:


 - year - необязательный параметр, при наличии выдавать книги только указанного года публикации,

 - column - обязательный параметр, наименование поля, по которому требуется отсортировать данные. Возможные значения: book, author, numPages, publicationDate, rating, numberOfVoters,

 - sort - обязательный параметр, сортировка по возрастанию/убыванию. Возможные значения: ASC, DESC.

порт по умолчанию 8080

  - Пример запроса: http://localhost:8080/api/top10?year=2010&column=authors&sort=ASC

## Докер

- Откройте терминал и перейдите в директорию, где находятся файлы Dockerfile и docker-compose.yml
- Соберите Docker-образ, выполнив команду:

`shell`

`docker-compose build`

- После успешного завершения сборки образа запустите контейнер, используя команду:

`shell`

`docker-compose up`

- Приложение Spring Boot будет доступно по адресу http://localhost:8080/.