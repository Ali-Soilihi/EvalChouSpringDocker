
-- Création de la table Collaborater
CREATE TABLE Collaborater(
    Collaborater_id serial PRIMARY KEY,
    lastName varchar,
    firstName varchar,
    function varchar

);

-- Création de la table tache
CREATE TABLE Task(
Task_id serial PRIMARY KEY,
title varchar,
description varchar,
priority varchar,
realized BOOLEAN NOT NULL DEFAULT FALSE,
taskList int,
collaborater int

);

-- Création de la table Liste de taches
CREATE TABLE TaskList(
TaskList_id serial PRIMARY KEY,
TaskList_Name varchar,
taskList int

);

-- CCreate foreign keys for table Task : TaskList_id et Collaborater_id
ALTER TABLE Task ADD CONSTRAINT fk_taskList FOREIGN KEY (taskList) REFERENCES TaskList(TaskList_id);
ALTER TABLE Task ADD CONSTRAINT fk_collaborater FOREIGN KEY (collaborater) REFERENCES Collaborater(Collaborater_id);

-- CCreate foreign keys for table TaskList : taskList
ALTER TABLE TaskList ADD CONSTRAINT fk_taskList FOREIGN KEY (taskList) REFERENCES Task(Task_id);
-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;

