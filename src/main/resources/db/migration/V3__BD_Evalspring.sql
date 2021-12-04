--UPDATE les de taches
UPDATE  TaskList
SET
tasks=1
WHERE TaskList_id=1;

UPDATE  TaskList
SET
tasks=2
WHERE TaskList_id=2;

UPDATE  TaskList
SET
tasks=3
WHERE TaskList_id=3;

UPDATE  TaskList
SET
tasks=4
WHERE TaskList_id=4;
--*****************************************************************
--UPDATE liste de taches
UPDATE  Task
SET
tasklist_id=1,
collaborater_id=NULL
WHERE Task_id=1;

UPDATE  Task
SET
tasklist_id=2,
collaborater_id=NULL
WHERE Task_id=2;

UPDATE  Task
SET
tasklist_id=3,
collaborater_id=NULL
WHERE Task_id=3;

UPDATE  Task
SET
tasklist_id=4,
collaborater_id=NULL
WHERE Task_id=4;

UPDATE  Task
SET
tasklist_id=4,
collaborater_id=NULL
WHERE Task_id=5;

UPDATE  Task
SET
tasklist_id=3,
collaborater_id=NULL
WHERE Task_id=6;



-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;