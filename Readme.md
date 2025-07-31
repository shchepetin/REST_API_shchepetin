# Проект по автоматизации тестирования API сервиса Reqres

<img src="media/logo/reqresin.jpg">

## Введение
Данный проект представляет собой набор автоматизированных тестов для API сервиса Reqres. Он предназначен для проверки корректности работы основных функций API, таких как регистрация, авторизация, управление пользователями и получение данных.

---

## Содержание:

- [Используемые технологии и инструменты](#используемые-технологии-и-инструменты)
- [Реализованные тестовые сценарии](#реализованные-тестовые-сценарии)
- [Запуск тестов из командной строки](#запуск-тестов-из-командной-строки)
- [Настройка и запуск сборки в Jenkins](#настройка-и-запуск-сборки-в-jenkins)
- [Отчет Allure](#отчет-allure)
- [Уведомления в Telegram через бота](#уведомления-в-telegram-через-бота)
- [Контакты](#контакты)

---

## Используемые технологии и инструменты:

| [Java](https://www.java.com/) | [IDEA](https://www.jetbrains.com/idea/) | [GitHub](https://github.com/) | [JUnit 5](https://junit.org/junit5/) | [Gradle](https://gradle.org/) | [Rest-Assured](https://rest-assured.io/) | [Allure](https://github.com/allure-framework) | [Jenkins](https://www.jenkins.io/) | [Telegram](https://web.telegram.org/) |
|---|---|---|---|---|---|---|---|---|
| <img src="media/logo/Java.svg" width="50" height="50" alt="Java"/> | <img src="media/logo/Idea.svg" width="50" height="50" alt="IDEA"/> | <img src="media/logo/GitHub.svg" width="50" height="50" alt="Github"/> | <img src="media/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5"/> | <img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle"/> | <img src="media/logo/rest-assured.jpg" width="50" height="50" alt="Rest-Assured"/> | <img src="media/logo/Allure.svg" width="50" height="50" alt="Allure"/> | <img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins"/> | <img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram"/> |

Проект автоматизации тестирования реализован на языке **Java** с применением фреймворков **JUnit 5**, **Selenide** (хотя иконка для Rest-Assured, в тексте указан Selenide - проверьте, что используется) и **Rest-Assured**. Управление проектом осуществляется с помощью сборочного инструмента **Gradle**. Для автоматизированного запуска тестов настроена задача в **Jenkins**, которая генерирует подробный **Allure-отчет** и отправляет результаты выполнения в **Telegram-канал** посредством специализированного бота.

---

## Реализованные тестовые сценарии

- ✓ Тестирование получения информации о пользователях
- ✓ Тестирование регистрации новых пользователей
- ✓ Тестирование авторизации пользователей
- ✓ Тестирование частичного обновления данных пользователя (PATCH-запрос)
- ✓ Тестирование удаления пользователя
- ✓ Тестирование полного обновления данных пользователя (PUT-запрос)

---

### Запуск тестов из командной строки
Для выполнения тестов локально используйте команду:

`gradle clean test`

---

## Настройка и запуск сборки в Jenkins

<img src="media/logo/Jenkins.svg" width="25" height="25" alt="Jenkins"/> Настройка и запуск сборки в [Jenkins]([ВАША_ССЫЛКА_НА_JENKINS])

Для запуска автоматизированной сборки перейдите в раздел `Собрать с параметрами`, выберите необходимые конфигурации и активируйте процесс нажатием кнопки `Собрать`.

<p align="center">
<a href="[ВАША_ССЫЛКА_НА_JENKINS]"><img src="media/screens/jenkins_main.png" alt="Jenkins1"/></a>
</p>

По завершении сборки в блоке `История сборок` рядом с номером сборки появится иконка Allure Report. При нажатии на неё откроется сформированный HTML-отчет, содержащий всю тестовую документацию.

---

## Отчет Allure

<img src="media/logo/Allure.svg" width="25" height="25" alt="Allure"/> [Allure]([ВАША_ССЫЛКА_НА_ALLURE]) отчет

### Обзорная страница отчета

<p align="center">
<img src="media/screens/allure_auto_main.png" alt="Allure report" width="1000" height="400">
</p>

### Детализация тест-кейсов

<p align="center">
<img src="media/screens/allure_auto_2.png" alt="Test Case" width="1000" height="400">
</p>

---

## Уведомления в Telegram через бота

<img src="media/logo/Telegram.svg" width="25" height="25" alt="Telegram"/> Уведомления в Telegram-чат с ботом

После успешного выполнения сборки специально настроенный бот в **Telegram** автоматически формирует и отправляет сообщение с кратким отчетом о результатах прохождения тестов.

### Пример уведомления из чат-бота

<p align="center">
<img src="media/screens/telegram_main.png" alt="TestOps launch" width="500" height="400">
</p>

#### Содержание уведомления в Telegram

- :heavy_check_mark: Используемое окружение
- :heavy_check_mark: Дополнительный комментарий к сборке
- :heavy_check_mark: Общая длительность выполнения тестов
- :heavy_check_mark: Суммарное количество тестовых сценариев
- :heavy_check_mark: Процент успешно пройденных тестов
- :heavy_check_mark: Прямая ссылка на полный Allure-отчет

---

## Контакты
* **GitHub:** [shchepetin](https://github.com/shchepetin)
* **Email:** shchepetin.i@dornet.ru
* **Место работы:** dornet
* **Город:** Москва, Россия

---