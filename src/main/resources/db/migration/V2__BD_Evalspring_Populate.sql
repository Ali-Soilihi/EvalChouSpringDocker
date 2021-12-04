--Des Collaborater
INSERT INTO Collaborater(lastName, firstName, function) VALUES
('ALI-SOILIHI', 'Chouaimbou', 'PDG');
INSERT INTO Collaborater(lastName, firstName, function) VALUES
('CHARRIER', 'Jeremy', 'Maitre de donjon');
INSERT INTO Collaborater(lastName, firstName, function) VALUES
('Pellerin', 'EDOUARD', 'Roi démon');
INSERT INTO Collaborater(lastName, firstName, function) VALUES
('JOURDAN', 'Erwan', 'Bourreau');
INSERT INTO Collaborater(lastName, firstName, function) VALUES
('VANGHELUWE', 'Léa', 'Genius');
--*****************************************************************
--Des liste de taches
INSERT INTO TaskList(taskListName) VALUES
('Torture');
INSERT INTO TaskList(taskListName) VALUES
('Recolte');
INSERT INTO TaskList(taskListName) VALUES
('VOL');
INSERT INTO TaskList(taskListName) VALUES
('Sauver');
--*****************************************************************
--Des liste de taches
INSERT INTO Task(title,description,priority,realized) VALUES
('Tuer','tuer,piller,demenber,dancer','LOW',true);
INSERT INTO Task(title,description,priority,realized) VALUES
('taxer','extorquer,mentir,arnaquer','HIGH',true);
INSERT INTO Task(title,description,priority,realized) VALUES
('Tuer','tuer,piller,demenber,dancer','MEDIUM',true);
INSERT INTO Task(title,description,priority,realized) VALUES
('Aimer','fleur,papillon,bisou','HIGH',false);





-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;