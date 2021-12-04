--UPDATE liste de taches
UPDATE  TaskList
SET
taskListBox=1
WHERE taskListId=1;

UPDATE  TaskList
SET
taskListBox=2
WHERE taskListId=2;

UPDATE  TaskList
SET
taskListBox=3
WHERE taskListId=3;

UPDATE  TaskList
SET
taskListBox=4
WHERE taskListId=4;
--*****************************************************************
--UPDATE les de taches

UPDATE  Task
SET
taskListId=1,
collaboraterId=NULL
WHERE taskId=1;

UPDATE  Task
SET
taskListId=2,
collaboraterId=NULL
WHERE taskId=2;

UPDATE  Task
SET
taskListId=3,
collaboraterId=NULL
WHERE taskId=3;

UPDATE  Task
SET
taskListId=4,
collaboraterId=NULL
WHERE taskId=4;



-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;