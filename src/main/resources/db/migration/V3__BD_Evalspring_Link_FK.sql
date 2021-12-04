--UPDATE liste de taches
UPDATE  task_list
SET
taskListBox=1
WHERE id=1;

UPDATE  task_list
SET
taskListBox=2
WHERE id=2;

UPDATE  task_list
SET
taskListBox=3
WHERE id=3;

UPDATE  task_list
SET
taskListBox=4
WHERE id=4;
--*****************************************************************
--UPDATE les de taches

UPDATE  Task
SET
task_list_id=1,
collaborater_id=NULL
WHERE id=1;

UPDATE  Task
SET
task_list_id=2,
collaborater_id=NULL
WHERE id=2;

UPDATE  Task
SET
task_list_id=3,
collaborater_id=NULL
WHERE id=3;

UPDATE  Task
SET
task_list_id=4,
collaborater_id=NULL
WHERE id=4;



-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;