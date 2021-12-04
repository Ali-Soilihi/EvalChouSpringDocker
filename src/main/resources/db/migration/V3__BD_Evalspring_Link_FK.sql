--UPDATE les de taches
UPDATE  TaskList
SET
task_list_box=1
WHERE tasklist_id=1;

UPDATE  TaskList
SET
task_list_box=2
WHERE tasklist_id=2;

UPDATE  TaskList
SET
task_list_box=3
WHERE tasklist_id=3;

UPDATE  TaskList
SET
task_list_box=4
WHERE tasklist_id=4;
--*****************************************************************
--UPDATE liste de taches
UPDATE  Task
SET
tasklist_id=1,
collaborater_id=NULL
WHERE task_id=1;

UPDATE  Task
SET
tasklist_id=2,
collaborater_id=NULL
WHERE task_id=2;

UPDATE  Task
SET
tasklist_id=3,
collaborater_id=NULL
WHERE task_id=3;

UPDATE  Task
SET
tasklist_id=4,
collaborater_id=NULL
WHERE task_id=4;



-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;