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
INSERT INTO TaskList(TaskList_Name,taskList) VALUES
('Torture', 1);
INSERT INTO TaskList(TaskList_Name,taskList) VALUES
('Recolte', 2);
INSERT INTO TaskList(TaskList_Name,taskList) VALUES
('VOL', 3);
INSERT INTO TaskList(TaskList_Name,taskList) VALUES
('Sauver', 4);
--*****************************************************************
--Des liste de taches
INSERT INTO TaskList(title,description,priority,realized,taskList,collaborater) VALUES
('Tuer','tuer,piller,demenber,dancer','LOW',true,0, NULL);
INSERT INTO TaskList(title,description,priority,status,taskList,collaborater) VALUES
('taxer','extorquer,mentir,arnaquer','HIGH',true,3, NULL);
INSERT INTO TaskList(title,description,priority,status,taskList,collaborater) VALUES
('Tuer','tuer,piller,demenber,dancer','MEDIUM',true,0, NULL);
INSERT INTO TaskList(title,description,priority,status,taskList,collaborater) VALUES
('Aimer','fleur,papillon,bisou','HIGH',false,4, NULL);