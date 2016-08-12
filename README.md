# SummaryTask4

<h2>EPAM final task</h2>

Разработать WEB-приложение, которое поддерживает заданную функциональность.
Требования к реализации следующие.

1.  На основе сущностей предметной области создать классы которые им соответствуют.
2.  Классы и методы должны иметь названия, которые отражают их функциональность, и должны быть грамотно разнесены по пакетам.
3   Оформление кода должно соответствовать Java Code Convention.
4.  Информацию о предметной области хранить в базе данных (в качестве СУБД рекомендуется использовать Apache Derby).
5.  Для доступа к данным использовать API JDBC с использованием пула соединений (не допускается использование ORM фреймверков).
6.  Приложение должно поддерживать работу с кириллицей (быть многоязычным), в том числе при хранении информации в базе данных:
     - должна быть возможность переключения языка интерфейса;
     - должна быть поддержка ввода, вывода и хранения информации (в базе данных), записанной на разных языках (см. ниже);
     - в качестве поддерживаемых языков выбрать минимум два: один на основе кириллицы, другой на основе латиницы.
10. Архитектура приложения должна соответствовать шаблону MVC (не допускается использование MVC фреймверков).
11. При реализации алгоритмов бизнес-логики использовать шаблоны проектирования.
12. Используя сервлеты и JSP, реализовать функциональность, приведенную в постановке задачи.
13. В качестве контейнера сервлетов использовать Apache Tomcat.
14. На страницах JSP применять теги из библиотеки JSTL и разработанные собственные теги (минимум один custom tag library тег и минимум один tag file тег).
15. При разработке использовать сессии, фильтры, слушатели.
16. Использовать журналирование событий с использованием библиотеки Apache Log4j.
17. Код должен содержать комментарии документатора (все классы верхнего уровня, нетривиальные методы и конструкторы).
18. Написать модульные тесты которые по максимуму покрывают функциональность.
19. Самостоятельное расширение постановки задачи по функциональности приветствуется.
20. Дополнительно, к требованиям изложенным выше, более чем желательно обеспечить выполнение следующих требований.
    - Реализовать разграничение прав доступа пользователей системы к компонентам приложения.
    - Реализовать защиту от повторной отправки данных на сервер при обновлении страницы.
    - Все поля ввода должны быть с валидацией данных.
  
  
<h3>Больница</h3> 
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
