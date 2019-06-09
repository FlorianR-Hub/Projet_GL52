DELETE FROM gl52.user_auth;
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (1, 'user', 'user', 0);
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (2, 'admin', 'admin', 1);
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (3, 'nutritionist', 'nutritionist', 2);

DELETE FROM gl52.contenir;
DELETE FROM gl52.ingredients;
DELETE FROM gl52.etape;
DELETE FROM gl52.recette;

INSERT INTO gl52.recette (NUM_RECETTE, NOM_RECETTE, TYPE_RECETTE, DIFFICULTE_RECETTE, DESC_RECETTE, TEMPS_PREPARATION_RECETTE, NB_PERSONNES_RECETTE, IMAGE_RECETTE) VALUES ('1', 'Cookies facile', 'Dessert', 'Facile', 'Trouvaille parfaite pour le dimanche après-midi, cette recette de cookies au chocolat est aussi vite prête que vite dévorée. À la fois croustillants et moelleux, ces cookies maison permettront de croquer à pleines dents dans une soirée télé en famille ou une après-midi farniente avec des amis. Alors on dévalise son placard, on retrousse ses manches, et on s\'y met !', '10', '4', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\cookies.jpg'));
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (1, 1, 'Pendant que votre four préchauffe à 180°C (th.6), faites ramollir le beurre (à peines quelques secondes au micro-ondes ou alors en le pressant dans vos mains), puis mettez-le en petits morceaux dans un saladier. Ajoutez le sucre en poudre (que vous pouvez remplacer par de la cassonade) puis l’œuf, et mélangez à la cuillère.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (2, 1, 'Mélangez ensuite le sucre vahiné et la levure chimique puis versez la farine petit à petit, tout en remuant au fur et à mesure, afin que la pâte soit bien lisse et homogène. Pour finir, incorporez les pépites de chocolat noir (ou de chocolat au lait).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (3, 1, 'Recouvrez une plaque allant au four avec une feuille de papier cuisson, puis disposez par dessus des petits tas de pâte bombés formés à l''aide de deux petites cuillères (laissez de la place entre les cookies, ils vont gonfler et s''étaler en cuisant).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (4, 1, 'Vous n''avez plus qu''à enfourner vos cookies pendant plus ou moins 10 min, et dès que leurs bords brunissent, à les retirer du four, car ils vont encore durcir en refroidissant. Laissez refroidir, décollez de la plaque, et dévorez tiède ou froid.');


INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (1, 'Pépites de chocolat');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (2, 'Œuf');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (3, 'Farine');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (4, 'Sucre en poudre');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (5, 'Beurre');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (6, 'Sachet de levure chimique');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (7, 'Sachet de sucre vahiné');


INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 1, 150, 'g'); 
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 2, 1, '');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 3, 150, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 4, 85, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 5, 85, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 6, 1, '');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 7, 1, '');

COMMIT;