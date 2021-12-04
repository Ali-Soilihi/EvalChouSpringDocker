
-- Création de la table Collaborater
CREATE TABLE Collaborater(
    collaboraterId serial PRIMARY KEY,
    lastName varchar,
    firstName varchar,
    function varchar

);

-- Création de la table tache
CREATE TABLE Task(
taskId serial PRIMARY KEY,
title varchar,
description varchar,
priority varchar,
realized BOOLEAN NOT NULL DEFAULT FALSE,
taskListId int,
collaboraterId int

);

-- Création de la table Liste de taches
CREATE TABLE TaskList(
taskListId serial PRIMARY KEY,
taskListName varchar,
taskListBox int

);

-- CCreate foreign keys for table Task : TaskList_id et Collaborater_id
ALTER TABLE Task ADD CONSTRAINT fk_taskList FOREIGN KEY (taskListId) REFERENCES TaskList(taskListId);
ALTER TABLE Task ADD CONSTRAINT fk_collaborater FOREIGN KEY (collaboraterId) REFERENCES Collaborater(collaboraterId);

-- CCreate foreign keys for table TaskList : taskList
ALTER TABLE TaskList ADD CONSTRAINT fk_taskList FOREIGN KEY (taskListBox) REFERENCES Task(taskId);
-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;

