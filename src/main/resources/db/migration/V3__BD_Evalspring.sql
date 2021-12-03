--UPDATE les de taches
UPDATE  TaskList
SET
taskList=1
WHERE TaskList_id=1;

UPDATE  TaskList
SET
taskList=2
WHERE TaskList_id=2;

UPDATE  TaskList
SET
taskList=3
WHERE TaskList_id=3;

UPDATE  TaskList
SET
taskList=4
WHERE TaskList_id=4;
--*****************************************************************
--UPDATE liste de taches
UPDATE  Task
SET
taskList=1,
collaborater=NULL
WHERE Task_id=1;

UPDATE  Task
SET
taskList=2,
collaborater=NULL
WHERE Task_id=2;

UPDATE  Task
SET
taskList=3,
collaborater=NULL
WHERE Task_id=3;

UPDATE  Task
SET
taskList=4,
collaborater=NULL
WHERE Task_id=4;

UPDATE  Task
SET
taskList=4,
collaborater=NULL
WHERE Task_id=5;

UPDATE  Task
SET
taskList=3,
collaborater=NULL
WHERE Task_id=6;



-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;