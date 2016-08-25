SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

drop database if exists hospitaldb;
create database hospitaldb;
use hospitaldb;

CREATE TABLE IF NOT EXISTS hospital_card (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    diagnosis varchar(150)
) DEFAULT CHARSET=utf8;

insert into hospital_card (id, diagnosis) values
(1, 'Желтуха'),
(2, 'Аллергия'),
(3, 'Гайморит'),
(4, 'Отравление'),
(5, 'Перелом носа'),
(6, 'Рана от гвоздя на руке'),
(7, 'Вывих кисти'),
(8, 'Варикоз'),
(9, 'Скалеоз');

CREATE TABLE roles (
  id int(11) NOT NULL PRIMARY KEY,
  name varchar(10) NOT NULL UNIQUE
);

INSERT INTO roles (id, name) VALUES
(0, 'admin'),
(1, 'doctor'),
(2, 'nurse');


CREATE TABLE IF NOT EXISTS specializations (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title varchar(30) NOT NULL
);

INSERT INTO specializations (id, title) VALUES
(1, 'Pediatrician'),
(2, 'Traumatologist'),
(3, 'Surgeon');



CREATE TABLE IF NOT EXISTS type_of_treatment (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(30) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO type_of_treatment (id, title) VALUES
(1, 'Procedure'),
(2, 'Medicine'),
(3, 'Operation');

CREATE TABLE treatment (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hospital_card_id INT(11) NOT NULL,
    type_of_treatment_id INT(11) NOT NULL,
    name_of_medication VARCHAR(40) NOT NULL,
    done TINYINT(1) DEFAULT NULL,
	foreign key (hospital_card_id) references hospital_card(id),
    foreign key (type_of_treatment_id) references type_of_treatment(id)
);

INSERT INTO treatment (id, hospital_card_id, type_of_treatment_id, name_of_medication, done) VALUES
(1, 1, 2, 'Назол', 1),
(2, 2, 2, 'Назол', 0),
(3, 3, 2, 'Метионин', 0),
(4, 4, 3, 'прокол', 0),
(5, 5, 2, 'Диазалин', 0),
(6, 5, 2, 'Рибоксин', 0),
(7, 5, 2, 'Сирепар', 0),
(8, 6, 2, 'Тыквеол', 0),
(9, 6, 2, 'уголь активированный', 0),
(10, 6, 2, 'Линекс', 0),
(11, 7, 2, 'Регидрон', 0),
(12, 7, 1, 'Рентген', 0),
(13, 7, 2, 'Анальгин', 0),
(14, 8, 2, 'Йод', 0),
(15, 8, 1, 'Перевязка', 0),
(16, 8, 1, 'Вправление кисти', 0),
(17, 9, 2, 'Венитан', 0),
(18, 9, 2, 'Аэсцин Гель', 0),
(19, 9, 1, 'Занятие в тренажерном зале', 0);

CREATE TABLE IF NOT EXISTS users (
  id int(11) NOT NULL AUTO_INCREMENT,
  login varchar(10) DEFAULT NULL UNIQUE,
  password varchar(10) DEFAULT NULL,
  first_name varchar(20) DEFAULT NULL,
  last_name varchar(20) DEFAULT NULL,
  role_id int(11) DEFAULT NULL,
  specialization_id int(11) DEFAULT NULL,
  count_of_patients int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  foreign key (role_id) references roles(id),
  foreign key (specialization_id) references specializations(id)
);

INSERT INTO `users` (id, login, password, first_name, last_name, role_id, specialization_id, count_of_patients) VALUES
(1, 'admin', 'admin', 'Ivan', 'Ivanov',  0, NULL, 0),
(2, 'doctor', 'doctor', 'Petr', 'Petrov',  1, 1, 4),
(3, 'doctor1', 'doctor1', 'Bruce', 'Wayn',  1, 3, 2),
(6, 'nurse', 'nurse', 'Светлана', 'Казакова',  2, NULL, NULL),
(7, 'nurse1', 'nurse2', 'Светлана2', 'Казакова2',  2, NULL, NULL),
(8, 'karl123', 'karl123', 'Карл', 'Шафранек', 1, 2, 3);

CREATE TABLE patients (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    birthday DATE DEFAULT NULL,
    doctor_id INT(11) DEFAULT NULL,
    card_id INT(11) DEFAULT NULL,
    foreign key (doctor_id) references users(id),
    foreign key (card_id) references hospital_card(id)
);

INSERT INTO patients (id, first_name, last_name, birthday, doctor_id, card_id) VALUES
(1, 'Олексій', 'Майор', '2015-07-08', 2, 1),
(2, 'Марья', 'Шахматова', '2015-08-13', 2, 2),
(3, 'Дмитро', 'Матвейчук', '2015-07-30', 2, 3),
(4, 'Василий', 'Фидлер', '2015-08-04', 2, 4),
(5, 'Александр', 'Петров', '2000-08-17', 8, 5),
(6, 'Владимир', 'Фесенко', '2001-08-24', 8, 6),
(7, 'Исаак', 'Варшавчик', '2000-08-04', 8, 7),
(8, 'Иван', 'Василенко', '1999-08-05', 3, 8),
(9, 'Мария', 'Абаза', '1998-08-20', 3, 9);


CREATE TABLE IF NOT EXISTS discharged_patients (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) DEFAULT NULL,
    last_name VARCHAR(30) DEFAULT NULL,
    birthday DATE DEFAULT NULL,
    doctor_id INT(11) DEFAULT NULL,
    foreign key (doctor_id) references users(id)
);

INSERT INTO discharged_patients (id, first_name, last_name, birthday, doctor_id) VALUES
(33, 'Дмитро', 'Матвейчук', '2015-07-30', 2);
