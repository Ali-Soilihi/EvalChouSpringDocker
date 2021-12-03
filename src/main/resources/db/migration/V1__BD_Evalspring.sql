
-- Création de la table Collaborater
CREATE TABLE Collaborater(
    Collaborater_id serial PRIMARY KEY,
    lastName varchar,
    firstName varchar,
    function varchar

);
-- Création de la table Liste de taches
CREATE TABLE TaskList(
TaskList_id serial PRIMARY KEY,
TaskList_Name varchar,
taskList int REFERENCES Task(Task_id)

);

-- Création de la table tache
CREATE TABLE Task(
Task_id serial PRIMARY KEY,
title varchar,
description varchar,
priority varchar,
realized BOOLEAN NOT NULL DEFAULT FALSE,
taskList int REFERENCES TaskList(TaskList_id),
collaborater int REFERENCES Collaborater(Collaborater_id)

);
