--Des Collaborater
INSERT INTO Collaborater(last_name, first_name, function) VALUES
('ALI-SOILIHI', 'Chouaimbou', 'PDG');
INSERT INTO Collaborater(last_name, first_name, function) VALUES
('CHARRIER', 'Jeremy', 'Maitre de donjon');
INSERT INTO Collaborater(last_name, first_name, function) VALUES
('Pellerin', 'EDOUARD', 'Roi démon');
INSERT INTO Collaborater(last_name, first_name, function) VALUES
('JOURDAN', 'Erwan', 'Bourreau');
INSERT INTO Collaborater(last_name, first_name, function) VALUES
('VANGHELUWE', 'Léa', 'Genius');
--*****************************************************************
--Des liste de taches
INSERT INTO task_list(task_list_name) VALUES
('Torture');
INSERT INTO task_list(task_list_name) VALUES
('Recolte');
INSERT INTO task_list(task_list_name) VALUES
('VOL');
INSERT INTO task_list(task_list_name) VALUES
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