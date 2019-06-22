SET SQL_SAFE_UPDATES = 0;

DELETE FROM gl52.etre_sujet;
DELETE FROM gl52.etre_allergique;
DELETE FROM gl52.preferer;
DELETE FROM gl52.administrateur;
DELETE FROM gl52.nutritionniste;
DELETE FROM gl52.utilisateur;
DELETE FROM gl52.user_auth;
DELETE FROM gl52.associer;
DELETE FROM gl52.allergenes;
DELETE FROM gl52.carences;
DELETE FROM gl52.posseder;
DELETE FROM gl52.anc;
DELETE FROM gl52.contenir;
DELETE FROM gl52.ingredients;
DELETE FROM gl52.etape;
DELETE FROM gl52.recette;

INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (1, 'user', 'user', 0);
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (2, 'admin', 'admin', 1);
INSERT INTO gl52.user_auth (ID, PSEUDO, MDP, ACCOUNT_TYPE) VALUES (3, 'nutritionist', 'nutritionist', 2);

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

-- Allergènes :
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (1 , 'Arachides');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (2 , 'Céleri');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (3 , 'Gluten');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (4 , 'Fruits à coque');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (5 , 'Lait');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (6 , 'Lupin');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (7 , 'Mollusques');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (8 , 'Moutarde');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (9 , 'Œufs');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (10, 'Poisson');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (11, 'Sésame');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (12, 'Sulfites');
INSERT INTO gl52.allergenes (NUM_ALLERGENE, NOM_ALLERGENE) VALUES (13, 'Soja');

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


-- DEBUT RECETTES

-- Cookies facile :
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

-- Posséder :
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('1', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('2', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('3', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('4', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('5', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('6', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('7', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('8', '1');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('9', '1');

-- Associer :
INSERT INTO gl52.associer (NUM_RECETTE, NUM_ALLERGENE) VALUES (1, 9);

-- Omelette simple :
INSERT INTO gl52.recette (NUM_RECETTE, NOM_RECETTE, TYPE_RECETTE, DIFFICULTE_RECETTE, DESC_RECETTE, TEMPS_PREPARATION_RECETTE, NB_PERSONNES_RECETTE, IMAGE_RECETTE, ENERGIE) VALUES ('2', 'Omelette simple', 'Plat', 'Facile', 'Le dimanche soir, qui dit dîner en solo et oeufs dans la réfrigérateur dit omelette ! Recette simple et culte pour souper en célibataire, elle se cuisine simplement avec des oeufs, des herbes, voire du fromage. Mais elle peut aussi s\'enrichir d\'un tas de restes qui ne demandent qu\'à servir dans le fond du réfrigérateur... Alors, ce soir, vous serez plutôt omelette nature, omelette aux champignons ou omelette au bacon ? ', '10', '1', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\omelette-simple.jpg'), '200');

-- Etapes :
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES ('1', '2', 'Battez les œufs entiers dans un bol. Ajoutez sel et poivre à votre goût puis mélangez bien au fouet ou à la fourchette.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES ('2', '2', 'Faites chauffer l\'huile d\'olive dans une poêle et lorsqu\'elle est bien chaude, versez les oeufs battus dans la poêle et laissez cuire 1 minute tout en remuant constamment, jusqu\'à obtenir une omelette baveuse ou bien ferme selon vos goûts. Quand l’omelette est cuite à votre goût, ajoutez le fromage râpé et roulez-la. Dressez-la dans une assiette de service, et dégustez avec une salade verte assaisonnée et des mouillettes de pain beurrées ou tartinées de fromage.');

-- Ingrédients :
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (8 , 'Sel');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (9 , 'Huile d''olive');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (10, 'Poivre');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (11, 'Gruyère râpé');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (12, 'Branches de ciboulette ciselée');

-- Contenir :
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES ('2', '2', '3', '');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES ('2', '8', '3', 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES ('2', '9', '2', 'c. à soupe');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES ('2', '10', '1', 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES ('2', '11', '30', 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES ('2', '12', '6', '');

-- Posséder :
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('1', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('2', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('3', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('4', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('5', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('6', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('7', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('8', '2');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('9', '2');

-- Associer :
INSERT INTO gl52.associer (NUM_RECETTE, NUM_ALLERGENE) VALUES (2, 9);

-- Tarte aux fraises :
INSERT INTO gl52.recette (NUM_RECETTE, NOM_RECETTE, TYPE_RECETTE, DIFFICULTE_RECETTE, DESC_RECETTE, TEMPS_PREPARATION_RECETTE, NB_PERSONNES_RECETTE, IMAGE_RECETTE, ENERGIE) VALUES ('3', 'Tarte aux fraises', 'Dessert', 'Facile', 'Une bonne tarte aux fraises', '35', '6', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\tarte.jpg'), 1500);

-- Etapes :
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (1, 3,'Blanchir les jaunes et le sucre au fouet et détendre le mélange avec un peu d''eau.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (2, 3, 'Mélanger au doigt la farine et le beurre coupé en petites parcelles pour obtenir une consistance sableuse et que tout le beurre soit absorbé (!!! Il faut faire vite pour que le mélange ne ramollisse pas trop!).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (3, 3, 'Verser au milieu de ce "sable" le mélange liquide. Incorporer au couteau les éléments rapidement sans leur donner de corps.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (4, 3, 'Former une boule avec les paumes et fraiser 1 ou 2 fois pour rendre la boule + homogène');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (5, 3, 'Foncer un moule de 25 cm de diamètre avec la pâte, garnissez la de papier sulfurisé et de haricots secs.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (6, 3, 'Faire cuire à blanc 20 à 25 min, à 180°C (thermostat 6).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (7, 3, 'Verser la crème sur le fond de tarte et disposer joliment les fraises coupées en 2.');

-- Ingrédients :
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (13, 'Jaune d''oeuf');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (14, 'Eau');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (15, 'Fraise');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (16, 'Crème pâtissière');

-- Contenir :
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 2, 250, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 4, 70, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 3, 125, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 13, 2, '');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 14, 5, 'cl');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 15, 500, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 16, 100, 'g');

-- Posséder :
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('1', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('2', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('3', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('4', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('5', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('6', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('7', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('8', '3');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('9', '3');

-- Associer :
INSERT INTO gl52.associer (NUM_RECETTE, NUM_ALLERGENE) VALUES (3, 5);
INSERT INTO gl52.associer (NUM_RECETTE, NUM_ALLERGENE) VALUES (3, 9);

-- Riz au lait cuit au four :
INSERT INTO gl52.recette (NUM_RECETTE, NOM_RECETTE, TYPE_RECETTE, DIFFICULTE_RECETTE, DESC_RECETTE, TEMPS_PREPARATION_RECETTE, NB_PERSONNES_RECETTE, IMAGE_RECETTE, ENERGIE) VALUES ('4', 'Riz au lait cuit au four', 'Dessert', 'Facile', 'Un bon riz au lait comme vous en mangez rarement', '125', '8', LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\riz.jpg'), 500);

-- Etapes :
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (1, 4,'Dans un plat rectangulaire, versez tous les ingrédients. Mélangez puis faites cuire environ 2 heures à 180°C (thermostat 6).');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (2, 4, 'Faites attention en début de cuisson, remuez de nouveau si un peu de riz remonte à la surface, car sinon le riz s''assèche.');
INSERT INTO gl52.etape (NUM_ETAPE, NUM_RECETTE, INSTRUCTION_ETAPE) VALUES (3, 4, 'Le riz est cuit lorsqu''il est onctueux et qu''il reste encore un peu de liquide.');

-- Ingrédients :
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (17, 'Riz rond');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (18, 'Vanille');
INSERT INTO gl52.ingredients (NUM_INGREDIENT, NOM_INGREDIENT) VALUES (19, 'Lait');

-- Contenir :
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (4, 4, 100, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (4, 19, 1, 'l');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 17, 100, 'g');
INSERT INTO gl52.contenir (NUM_RECETTE, NUM_INGREDIENT, QUANTITE, UNITE) VALUES (3, 18, 2, 'g');

-- Posséder :
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('1', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('2', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('3', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('4', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('5', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('6', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('7', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('8', '4');
INSERT INTO gl52.posseder (NUM_ANC, NUM_RECETTE) VALUES ('9', '4');

-- Associer :
INSERT INTO gl52.associer (NUM_RECETTE, NUM_ALLERGENE) VALUES (4, 5);

-- FIN RECETTES

COMMIT;

SET SQL_SAFE_UPDATES = 1;