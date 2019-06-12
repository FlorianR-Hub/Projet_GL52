DELETE FROM gl52.user_auth;
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (1, 'user', 'user', 0);
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (2, 'admin', 'admin', 1);
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (3, 'nutritionist', 'nutritionist', 2);

DELETE FROM gl52.allergenes;
DELETE FROM gl52.carences;
DELETE FROM gl52.anc;
DELETE FROM gl52.contenir;
DELETE FROM gl52.ingredients;
DELETE FROM gl52.etape;
DELETE FROM gl52.recette;

-- Recettes :
INSERT INTO gl52.recette (NUM_RECETTE, NOM_RECETTE, TYPE_RECETTE, DIFFICULTE_RECETTE, DESC_RECETTE, TEMPS_PREPARATION_RECETTE, NB_PERSONNES_RECETTE, IMAGE_RECETTE, ENERGIE) VALUES ('1', 'Cookies facile', 'Dessert', 'Facile', 'Trouvaille parfaite pour le dimanche après-midi, cette recette de cookies au chocolat est aussi vite prête que vite dévorée. À la fois croustillants et moelleux, ces cookies maison permettront de croquer à pleines dents dans une soirée télé en famille ou une après-midi farniente avec des amis. Alors on dévalise son placard, on retrousse ses manches, et on s\'y met !', '10', '4', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\cookies.jpg'), 1500);

-- Etapes :
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (1, 1, 'Pendant que votre four préchauffe à 180°C (th.6), faites ramollir le beurre (à peines quelques secondes au micro-ondes ou alors en le pressant dans vos mains), puis mettez-le en petits morceaux dans un saladier. Ajoutez le sucre en poudre (que vous pouvez remplacer par de la cassonade) puis l’œuf, et mélangez à la cuillère.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (2, 1, 'Mélangez ensuite le sucre vahiné et la levure chimique puis versez la farine petit à petit, tout en remuant au fur et à mesure, afin que la pâte soit bien lisse et homogène. Pour finir, incorporez les pépites de chocolat noir (ou de chocolat au lait).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (3, 1, 'Recouvrez une plaque allant au four avec une feuille de papier cuisson, puis disposez par dessus des petits tas de pâte bombés formés à l''aide de deux petites cuillères (laissez de la place entre les cookies, ils vont gonfler et s''étaler en cuisant).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (4, 1, 'Vous n''avez plus qu''à enfourner vos cookies pendant plus ou moins 10 min, et dès que leurs bords brunissent, à les retirer du four, car ils vont encore durcir en refroidissant. Laissez refroidir, décollez de la plaque, et dévorez tiède ou froid.');

-- Ingrédients :
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (1, 'Pépites de chocolat');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (2, 'Œuf');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (3, 'Farine');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (4, 'Sucre en poudre');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (5, 'Beurre');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (6, 'Sachet de levure chimique');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (7, 'Sachet de sucre vahiné');

-- Contenir :
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 1, 150, 'g'); 
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 2, 1, '');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 3, 150, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 4, 85, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 5, 85, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 6, 1, '');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (1, 7, 1, '');

-- Allergènes :
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (1 , 'Arachides');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (2 , 'Céleri');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (3 , 'Gluten');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (4 , 'Fruits à coque');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (5 , 'Lait');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (6 , 'Lupin');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (7 , 'Mollusques');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (8 , 'Moutarde');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (9 , 'Oeufs');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (10, 'Poisson');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (11, 'Sésame');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (12, 'Sulfites');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (13, 'Soja');

-- Carences :
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (1, 'Calcium');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (2, 'Fer');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (3, 'Magnésium');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (4, 'Protéines');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (5, 'Vitamine A');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (6, 'Vitamine B1');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (7, 'Vitamine B3');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (8, 'Vitamine B9');
INSERT INTO gl52.carences (NUM_CARENCE, NOM_CARENCE) VALUES (9, 'Vitamine D');

-- ANC :
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(1, 'Vitamine A', 'Vitamines');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(2, 'Vitamine B1', 'Vitamines');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(3, 'Vitamine B9', 'Vitamines');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(4, 'Vitamine D', 'Vitamines');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(5, 'Protéines', 'Nutriments');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(6, 'Lipides', 'Nutriments');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(7, 'Glucides', 'Nutriments');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(8, 'Fer', 'Minéraux');
INSERT INTO gl52.anc (NUM_ANC, NOM_ANC, TYPE_ANC) VALUES(9, 'Calcium', 'Nutriments');


COMMIT;