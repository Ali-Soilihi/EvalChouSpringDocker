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
--4 autre a surprimé plus tard

UPDATE  Task
SET
task_list_id=1,
collaborater_id=NULL
WHERE id=5;

UPDATE  Task
SET
task_list_id=1,
collaborater_id=NULL
WHERE id=6;

UPDATE  Task
SET
task_list_id=1,
collaborater_id=NULL
WHERE id=7;

UPDATE  Task
SET
task_list_id=1,
collaborater_id=NULL
WHERE id=8;



-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;