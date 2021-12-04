
-- Création de la table Collaborater
CREATE TABLE Collaborater(
    id serial PRIMARY KEY,
    last_name varchar,
    first_name varchar,
    function varchar

);

-- Création de la table tache
CREATE TABLE Task(
id serial PRIMARY KEY,
title varchar,
description varchar,
priority varchar,
realized BOOLEAN NOT NULL DEFAULT FALSE,
task_list_id int,
collaborater_id int

);

-- Création de la table Liste de taches
CREATE TABLE task_list(
id serial PRIMARY KEY,
task_list_name varchar,
taskListBox int

);

-- CCreate foreign keys for table Task : TaskList_id et Collaborater_id
ALTER TABLE Task ADD CONSTRAINT fk_taskList FOREIGN KEY (task_list_id) REFERENCES task_list(id);
ALTER TABLE Task ADD CONSTRAINT fk_collaborater FOREIGN KEY (collaborater_id) REFERENCES Collaborater(id);

-- CCreate foreign keys for table TaskList : taskList
ALTER TABLE task_list ADD CONSTRAINT fk_taskList FOREIGN KEY (taskListBox) REFERENCES Task(id);
-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;

