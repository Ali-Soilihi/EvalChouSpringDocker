# EvalChouSpringDocker
_**Point vocabulaire**_
1.une tache = task
2.une liste de tache = tasklist
3.tasklist_BOX = attribue de tasklist qui comptiens toute les liste de tache
4.tous les body sont en JSON

_ tout les envois sont fait en post je suis bien consciens qu'il faut addapté put (mise a jour) del(supression) etc_

#1-Je veux pouvoir créer une liste de tâches, en lui donnant un nom.
POST:http://localhost:8080/tasklist/register
BODY:
{
"task_list_name": "<mettre du texte ici>"
}

#2-Je veux pouvoir créer une tâche dans la liste avec un intitulé, une description, une priorité (HAUTE, MOYENNE, BASSE) et indiqué si elle est réalisée ou non.
/!\ {task_list_id} doit etre present en base lisé les comentaire du code
POST:http://localhost:8080/tasklist/register/{task_list_id}
BODY:
{
"title": "<mettre du texte ici>",
"description": "<mettre du texte ici> ",
"priority": <metre en string HIGH,MEDIUM ou LOW>,
"realized": <mettre true ou false>
}
#3-Je veux pouvoir indiquer qu'une tâche a été réalisée, ou au contraire, qu'une tâche réalisée ne l'est finalement pas.
-fait
#4-Je veux pouvoir mettre à jour l'intitulé et la description d'une tâche.
-fait
#5-Je veux pouvoir supprimer une tâche.
-fait
#6-Je veux pouvoir récupérer toutes les tâches d'une liste donnée en paramètre, triées dans l'ordre de priorité, avec un paramètre me permettant de dire si je veux également les tâches réalisées
-fait 2 requette
#7-Je veux pouvoir supprimer une liste de tâches. Si la liste n'est pas vide, je vous laisse le choix : supprimer la liste et toutes les tâches associées, ou renvoyer un message avec une erreur 400 "La liste doit être vide avant d'être supprimée".
-fait 2 requette
#8-Je souhaite pouvoir créer ou supprimer un collaborateur (qui a un prénom, un nom, une fonction dans l'entreprise)
-fait 2 requette
#9-Je souhaite pouvoir assigner la tâche à un collaborateur ou à l'inverse indiquer qu'elle n'est assignée à personne
-fait 2 requette