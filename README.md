# Проект "CodeGuardian"

## Описание
Проект "CodeGuardian" представляет собой веб-приложение, разработанное с использованием Java и Spring Boot. Основная цель проекта - предоставить функционал ведения
списка задач с учётом времени, выведения информации о выполненых и не выполненых задачах.

## Основные функции на данный момент
1. **Регистрация пользователей**: Возможность зарегистрировать нового пользователя с указанием имени пользователя и пароля.
2. **Аутентификация и авторизация**: Использование Spring Security для защиты конечных точек приложения и разграничения доступа на основе ролей пользователей (USER и ADMIN).
3. **Вход в личный аккаунт**: Разделение данных из бд которые соответствуют определённым пользователям.
4. **Добавление и удаление задач**: Возможность добавить задачи которые пользователь желает выполнить и созданение их в базе данных.

## Технологии
- **Java 17**: Язык программирования.
- **Spring Boot 3.3.1**: Основной фреймворк для создания приложения.
- **Spring Security**: Обеспечение безопасности приложения, включая аутентификацию и авторизацию.
- **MySQL**: Реляционная база данных для хранения информации о пользователях.
- **Thymeleaf**: Шаблонизатор для создания пользовательского интерфейса.

## Структура проекта
- **Controller**: Классы, обрабатывающие HTTP-запросы и взаимодействующие с пользователями.
- **Config**: Конфигурационные классы, настройка Spring Security и других компонентов приложения.
- **Entity**: Классы, представляющие сущности в базе данных (например, класс User).
- **Repository**: Интерфейсы для взаимодействия с базой данных.
- **Service**: Сервисы, реализующие бизнес-логику приложения, например, сервисы регистрации и аутентификации пользователей.

## Использование
Для запуска проекта необходимо выполнить сборку с помощью Maven и запустить полученный JAR-файл.

## Дамп для бд
```sql
-- таблица users
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
-- таблица task
CREATE TABLE `task` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2hsytmxysatfvt0p1992cw449` (`user_id`),
  CONSTRAINT `FK2hsytmxysatfvt0p1992cw449` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

```

- В application.properties изменить пароль и логин

```bash
server.port=8080
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/codeguardian
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=your_name <------------(имя)
spring.datasource.password=password  <------------(пароль)
spring.jpa.hibernate.ddl-auto=update
```

Приложение будет доступно по адресу http://localhost:8080.

**Автор**
Горностаев Владислав Иванович
