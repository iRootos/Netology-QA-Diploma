# Дипломный проект по профессии «Тестировщик»

### Документация:
- [ ] [План автоматизации](https://github.com/iRootos/Netology-QA-Diploma/blob/master/docs/Plan.md)
- [X] [Отчёт автоматизированного тестирования](https://github.com/iRootos/Netology-QA-Diploma/blob/master/docs/Report.md)
- [X] [Итоговый отчёт](https://github.com/iRootos/Netology-QA-Diploma/blob/master/docs/Summary.md)

### Процедура развёртывания проекта и запуска авто-тестов:
> Перед началом развёртывания и запуска авто-тестов на компьютере должно быть установлено следующее ПО:
> * Git
> * Java
> * Docker
> * Node.js
### Порядок запуска и развёртывания проекта:
1. Клонировать проект из репозитория, выполнив команду в консоли или терминале:
- `git clone https://github.com/iRootos/Netology-QA-Diploma.git`
2. Запустить контейнер Docker с MySQL через Docker-Compose введя команду:
- `docker-compose up`
3. Запустить SUT командой:
- `java -jar artifacts\aqa-shop.jar`
4. Запустить симулятор банковского сервиса командой:
- `cd gate-simulator; npm start`
5. Запустить выполнение авто-тестов командой:
- `.\gradlew test clean"`
6. Для генерации отчёта Allure выполнить команду:
- `.\gradlew allureServe`
7. После выполнения авто-тестов и генерации отчётов остановить работу SUT и симулятора комбинацией клавиш:
- `CTRL + C`
8. Остановить работу контейнера Docker командой:
- `docker-compose down`
