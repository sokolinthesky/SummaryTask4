# SummaryTask4

<h2>EPAM final task</h2>

Разработать WEB-приложение, которое поддерживает заданную функциональность.
Требования к реализации следующие.

-На основе сущностей предметной области создать классы которые им соответствуют.
-Классы и методы должны иметь названия, которые отражают их функциональность, и должны быть грамотно разнесены по пакетам.
-Оформление кода должно соответствовать Java Code Convention.
-Информацию о предметной области хранить в базе данных (в качестве СУБД рекомендуется использовать Apache Derby).
-Для доступа к данным использовать API JDBC с использованием пула соединений (не допускается использование ORM фреймверков).
-Приложение должно поддерживать работу с кириллицей (быть многоязычным), в том числе при хранении информации в базе данных:
-должна быть возможность переключения языка интерфейса;
-должна быть поддержка ввода, вывода и хранения информации (в базе данных), записанной на разных языках (см. ниже);
-в качестве поддерживаемых языков выбрать минимум два: один на основе кириллицы, другой на основе латиницы.
-Архитектура приложения должна соответствовать шаблону MVC (не допускается использование MVC фреймверков).
-При реализации алгоритмов бизнес-логики использовать шаблоны проектирования.
-Используя сервлеты и JSP, реализовать функциональность, приведенную в постановке задачи.
-В качестве контейнера сервлетов использовать Apache Tomcat.
-На страницах JSP применять теги из библиотеки JSTL и разработанные собственные теги (минимум один custom tag library тег и минимум один tag file тег).
-При разработке использовать сессии, фильтры, слушатели.
-Использовать журналирование событий с использованием библиотеки Apache Log4j.
-Код должен содержать комментарии документатора (все классы верхнего уровня, нетривиальные методы и конструкторы).
-Написать модульные тесты которые по максимуму покрывают функциональность.
-Самостоятельное расширение постановки задачи по функциональности приветствуется.
-Дополнительно, к требованиям изложенным выше, более чем желательно обеспечить выполнение следующих требований.
  - Реализовать разграничение прав доступа пользователей системы к компонентам приложения.
  - Реализовать защиту от повторной отправки данных на сервер при обновлении страницы.
  - Все поля ввода должны быть с валидацией данных.
  
  
Больница
Администратору системы доступен список Врачей по категориям (педиатр, травматолог, хирург, ...) и список Пациентов. Реализовать возможность сортировки

пациентов:
по алфавиту;
по дате рождения;

врачей:
по алфавиту;
по категории;
по количеству пациентов.
Администратор регистрирует в системе пациентов и врачей и назначает пациенту врача.

Врач определяет диагноз, делает назначение пациенту (процедуры, лекарства, операции), которые фиксируются в Больничной карте.

Назначение может выполнить Медсестра (процедуры, лекарства) или Врач (любое назначение). Пациент может быть выписан из больницы, при этом фиксируется окончательный диагноз.

(опционально: реализовать возможность сохранения документа с информацией о выписке пациента).
