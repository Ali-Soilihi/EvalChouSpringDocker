--ICI LES CHANT VIDES
----Des Collaborater
--INSERT INTO Collaborater(lastName, firstName, function) VALUES
--('', '', '');
----Des liste de taches
--INSERT INTO TaskList(TaskList_Name,taskList) VALUES
--('', 0);
----Des liste de taches
--INSERT INTO TaskList(title,description,priority,status,taskList,collaborater) VALUES
--('','','',true,0, 0);
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
INSERT INTO TaskList(TaskList_Name) VALUES
('Torture');
INSERT INTO TaskList(TaskList_Name) VALUES
('Recolte');
INSERT INTO TaskList(TaskList_Name) VALUES
('VOL');
INSERT INTO TaskList(TaskList_Name) VALUES
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
INSERT INTO Task(title,description,priority,realized) VALUES
('wow','lol,heastone,dbz','LOW',false);
INSERT INTO Task(title,description,priority,realized) VALUES
('roman','lovcraft,aneau du segneur,grrrr','LOW',false);




-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;