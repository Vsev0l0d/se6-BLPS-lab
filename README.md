# Задание лабораторной работы №1
Описать бизнес-процесс в соответствии с нотацией BPMN 2.0, после чего реализовать его в виде приложения на базе Spring Boot.

### Порядок выполнения работы:
- Выбрать один из бизнес-процессов, реализуемых сайтом из варианта задания.
- Утвердить выбранный бизнес-процесс у преподавателя.
- Специфицировать модель реализуемого бизнес-процесса в соответствии с требованиями BPMN 2.0.
- Разработать приложение на базе Spring Boot, реализующее описанный на предыдущем шаге бизнес-процесс. Приложение должно использовать СУБД PostgreSQL для хранения данных, для всех публичных интерфейсов должны быть разработаны REST API.
- Разработать набор curl-скриптов, либо набор запросов для REST клиента Insomnia для тестирования публичных интерфейсов разработанного программного модуля. Запросы Insomnia оформить в виде файла экспорта.
- Развернуть разработанное приложение на сервере helios.


# Задание лабораторной работы №2
Доработать приложение из лабораторной работы #1, реализовав в нем управление транзакциями и разграничение доступа к операциям бизнес-логики в соответствии с заданной политикой доступа.
### Управление транзакциями необходимо реализовать следующим образом
- Переработать согласованные с преподавателем прецеденты (или по согласованию с ним разработать новые), объединив взаимозависимые операции в рамках транзакций.
- Управление транзакциями необходимо реализовать с помощью Spring JTA.
- В реализованных (или модифицированных) прецедентах необходимо использовать декларативное управление транзакциями.
- В качестве менеджера транзакций необходимо использовать Bitronix.

### Разграничение доступа к операциям необходимо реализовать следующим образом
- Разработать, специфицировать и согласовать с преподавателем набор привилегий, в соответствии с которыми будет разграничиваться доступ к операциям.
- Специфицировать и согласовать с преподавателем набор ролей, осуществляющих доступ к операциям бизнес-логики приложения.
- Реализовать разработанную модель разграничений доступа к операциям бизнес-логики на базе Spring Security. Информацию об учетных записях пользователей необходимо сохранять в файле XML, для аутентификации использовать HTTP basic.

### Правила выполнения работы:
- Все изменения, внесенные в реализуемый бизнес-процесс, должны быть учтены в описывающей его модели, REST API и наборе скриптов для тестирования публичных интерфейсов модуля.
- Доработанное приложение необходимо развернуть на сервере helios.


# Задание лабораторной работы №3
Доработать приложение из лабораторной работы #2, реализовав в нем асинхронное выполнение задач с распределением бизнес-логики между несколькими вычислительными узлами и выполнением периодических операций с использованием планировщика задач.

### Требования к реализации асинхронной обработки
- Перед выполнением работы необходимо согласовать с преподавателем набор прецедентов, в реализации которых целесообразно использование асинхронного распределенного выполнения задач. Если таких прецедентов использования в имеющейся бизнес-процесса нет, нужно согласовать реализацию новых прецедентов, доработав таким образом модель бизнес-процесса из лабораторной работы #1.
- Асинхронное выполнение задач должно использовать модель доставки "очередь сообщений".
- В качестве провайдера сервиса асинхронного обмена сообщениями необходимо использовать очередь сообщений на базе RabbitMQ.
- Для отправки сообщений необходимо использовать протокол AMQP 1.0- . - Библиотеку для реализации отправки сообщений можно взять любую на выбор студента.
- Для получения сообщений необходимо использовать слушателя сообщений JMS на базе Spring Boot (@JmsListener).

### Требования к реализации распределенной обработки
- Обработка сообщений должна осуществляться на двух независимых друг от друга узлах сервера приложений.
- Если логика сценария распределенной обработки предполагает транзакционность выполняемых операций, они должны быть включены в состав распределенной транзакции.

### Требования к реализации запуска периодических задач по расписанию
- Согласовать с преподавателем прецедент или прецеденты, в рамках которых выглядит целесообразным использовать планировщик задач. - Если такие прецеденты отсутствуют -- согласовать с преподавателем новые и добавить их в модель автоматизируемого бизнес-процесса.
- Реализовать утвержденные прецеденты с использованием планировщика задач Quartz.

### Правила выполнения работы
- Все изменения, внесенные в реализуемый бизнес-процесс, должны быть учтены в описывающей его модели, REST API и наборе скриптов для тестирования публичных интерфейсов модуля.
- Доработанное приложение необходимо либо развернуть на сервере helios, либо продемонстрировать его работоспособность на собственной инфраструктуре обучающегося.


# Задание лабораторной работы №4
Переработать программу, созданную в результате выполнения лабораторной работы #3, следующим образом:

- Для управления бизнес-процессом использовать BPM-движок Camunda.
- Заменить всю "статическую" бизнес-логику на "динамическую" на базе BPMS. Весь бизнес-процесс, реализованный в ходе выполнения предыдущих лабораторных работ (включая разграничение доступа по ролям, управление транзакциями, асинхронную обработку и периодические задачи), должен быть сохранён!.
- BPM-движок должен быть встроен в веб-приложение (embedded mode).
- Для описания бизнес-процесса необходимо использовать приложение Camunda Modeler.
- Пользовательский интерфейс приложения должен быть сгенерирован с помощью генератора форм Camunda.
- Итоговая сборка должно быть развернута на сервере helios под управление сервера приложений Apache Tomcat.

### Правила выполнения работы:
- Описание бизнес-процесса необходимо реализовать на языке BPMN 2.0.
- Необходимо интегрировать в состав процесса, управляемого BPMS, всё, что в принципе возможно в него интегрировать. Если какой-то из компонентов архитектуры приложения (например, асинхронный обмен сообщениями с помощью JMS) не поддерживается, необходимо использовать для интеграции с этой подсистемой соответствующие API и адаптеры.
- Распределенную обработку задач и распределенные транзакции на BPM-движок переносить не требуется.
