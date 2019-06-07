DROP TABLE IF EXISTS USER_AUTH;

DROP TABLE IF EXISTS RECETTE;

DROP TABLE IF EXISTS FOURNISSEUR;

DROP TABLE IF EXISTS ADMINISTRATEUR;

DROP TABLE IF EXISTS UTILISATEUR;

DROP TABLE IF EXISTS INGREDIENTS;

DROP TABLE IF EXISTS NUTRITIONNISTE;

DROP TABLE IF EXISTS ETAPE;

DROP TABLE IF EXISTS QUESTIONNAIRE;

DROP TABLE IF EXISTS PREFERER;

DROP TABLE IF EXISTS GERER;

DROP TABLE IF EXISTS CONTENIR;

DROP TABLE IF EXISTS FOURNIR;

# -----------------------------------------------------------------------------
#       TABLE : USER_AUTH
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS USER_AUTH (
  USERNAME varchar(50) NOT NULL  ,
  PASSWORD varchar(50) NOT NULL  ,
  ACCOUNT_TYPE int(2) NOT NULL
  , PRIMARY KEY (USERNAME)
)
comment = "";

# -----------------------------------------------------------------------------
#       TABLE : RECETTE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RECETTE
 (
   NUM_RECETTE BIGINT(5) NOT NULL  ,
   NOM_RECETTE VARCHAR(50) NOT NULL  ,
   TYPE_RECETTE VARCHAR(30) NOT NULL  ,
   DIFFICULTE_RECETTE VARCHAR(10) NOT NULL  ,
   DESC_RECETTE VARCHAR(1000) NOT NULL  ,
   TEMPS_PREPARATION_RECETTE INTEGER(3) NOT NULL  ,
   NB_PERSONNES_RECETTE INTEGER(2) NOT NULL  ,
   IMAGE_RECETTE LONGBLOB NOT NULL  
   , PRIMARY KEY (NUM_RECETTE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : FOURNISSEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FOURNISSEUR
 (
   NUM_FOURNISSEUR BIGINT(4) NOT NULL  ,
   NOM_FOURNISSEUR VARCHAR(40) NOT NULL  ,
   ADRESSE_FOURNISSEUR VARCHAR(128) NOT NULL  
   , PRIMARY KEY (NUM_FOURNISSEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ADMINISTRATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ADMINISTRATEUR
 (
   NUM_ADMIN INTEGER(2) NOT NULL  ,
   PRENOM_ADMIN VARCHAR(40) NOT NULL  ,
   NOM_ADMIN VARCHAR(50) NOT NULL  ,
   COURRIEL_ADMIN VARCHAR(50) NOT NULL  ,
   MDP_ADMIN VARCHAR(50) NOT NULL  
   , PRIMARY KEY (NUM_ADMIN) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : UTILISATEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS UTILISATEUR
 (
   NUM_UTILISATEUR BIGINT(5) NOT NULL  ,
   NUM_NUTRITIONNISTE BIGINT(6) NULL  ,
   PRENOM_UTILISATEUR VARCHAR(40) NOT NULL  ,
   NOM_UTILISATEUR VARCHAR(50) NOT NULL  ,
   COURRIEL_UTILISATEUR VARCHAR(50) NOT NULL  ,
   MDP_UTILISATEUR VARCHAR(50) NOT NULL  ,
   ADRESSE_UTILISATEUR VARCHAR(150) NOT NULL  ,
   AGE INTEGER(3) NOT NULL  ,
   POIDS INTEGER(3) NOT NULL  ,
   TAILLE INTEGER(3) NOT NULL  ,
   IMC INTEGER(2) NOT NULL  ,
   ALLERGIES VARCHAR(60) NULL  ,
   CARENCES VARCHAR(60) NULL  
   , PRIMARY KEY (NUM_UTILISATEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE UTILISATEUR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_UTILISATEUR_NUTRITIONNISTE
     ON UTILISATEUR (NUM_NUTRITIONNISTE ASC);

# -----------------------------------------------------------------------------
#       TABLE : INGREDIENTS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS INGREDIENTS
 (
   NUM_INGREDIENT BIGINT(4) NOT NULL  ,
   NOM_INGREDIENT VARCHAR(40) NOT NULL  
   , PRIMARY KEY (NUM_INGREDIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : NUTRITIONNISTE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS NUTRITIONNISTE
 (
   NUM_NUTRITIONNISTE BIGINT(6) NOT NULL  ,
   PRENOM_NUTRITIONNISTE VARCHAR(40) NOT NULL  ,
   NOM_NUTRITIONNISTE VARCHAR(50) NOT NULL  ,
   COURRIEL_NUTRITIONNISTE VARCHAR(50) NOT NULL  ,
   MDP_NUTRITIONNISTE VARCHAR(50) NOT NULL  ,
   DESCRIPTION_NUTRITIONNISTE VARCHAR(300) NOT NULL  
   , PRIMARY KEY (NUM_NUTRITIONNISTE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ETAPE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETAPE
 (
   NUM_ETAPE INTEGER(2) NOT NULL  ,
   NUM_RECETTE BIGINT(5) NOT NULL  ,
   INSTRUCTION_ETAPE VARCHAR(1000) NOT NULL  
   , PRIMARY KEY (NUM_ETAPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ETAPE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ETAPE_RECETTE
     ON ETAPE (NUM_RECETTE ASC);

# -----------------------------------------------------------------------------
#       TABLE : QUESTIONNAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS QUESTIONNAIRE
 (
   NUM_QUESTION INTEGER(2) NOT NULL  ,
   ENONCE_QUESTION VARCHAR(150) NOT NULL  
   , PRIMARY KEY (NUM_QUESTION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PREFERER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PREFERER
 (
   NUM_UTILISATEUR BIGINT(5) NOT NULL  ,
   NUM_RECETTE BIGINT(5) NOT NULL  
   , PRIMARY KEY (NUM_UTILISATEUR,NUM_RECETTE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PREFERER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PREFERER_UTILISATEUR
     ON PREFERER (NUM_UTILISATEUR ASC);

CREATE  INDEX I_FK_PREFERER_RECETTE
     ON PREFERER (NUM_RECETTE ASC);

# -----------------------------------------------------------------------------
#       TABLE : GERER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS GERER
 (
   NUM_ADMIN INTEGER(2) NOT NULL  ,
   NUM_RECETTE BIGINT(5) NOT NULL  ,
   NUM_NUTRITIONNISTE BIGINT(6) NOT NULL  
   , PRIMARY KEY (NUM_ADMIN,NUM_RECETTE,NUM_NUTRITIONNISTE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE GERER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_GERER_ADMINISTRATEUR
     ON GERER (NUM_ADMIN ASC);

CREATE  INDEX I_FK_GERER_RECETTE
     ON GERER (NUM_RECETTE ASC);

CREATE  INDEX I_FK_GERER_NUTRITIONNISTE
     ON GERER (NUM_NUTRITIONNISTE ASC);

# -----------------------------------------------------------------------------
#       TABLE : CONTENIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTENIR
 (
   NUM_RECETTE BIGINT(5) NOT NULL  ,
   NUM_INGREDIENT BIGINT(4) NOT NULL  ,
   QUANTITE INTEGER(5) NOT NULL  ,
   UNITE VARCHAR(5) NULL  
   , PRIMARY KEY (NUM_RECETTE,NUM_INGREDIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTENIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTENIR_RECETTE
     ON CONTENIR (NUM_RECETTE ASC);

CREATE  INDEX I_FK_CONTENIR_INGREDIENTS
     ON CONTENIR (NUM_INGREDIENT ASC);

# -----------------------------------------------------------------------------
#       TABLE : FOURNIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FOURNIR
 (
   NUM_INGREDIENT BIGINT(4) NOT NULL  ,
   NUM_FOURNISSEUR BIGINT(4) NOT NULL  
   , PRIMARY KEY (NUM_INGREDIENT,NUM_FOURNISSEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE FOURNIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_FOURNIR_INGREDIENTS
     ON FOURNIR (NUM_INGREDIENT ASC);

CREATE  INDEX I_FK_FOURNIR_FOURNISSEUR
     ON FOURNIR (NUM_FOURNISSEUR ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE UTILISATEUR 
  ADD FOREIGN KEY FK_UTILISATEUR_NUTRITIONNISTE (NUM_NUTRITIONNISTE)
      REFERENCES NUTRITIONNISTE (NUM_NUTRITIONNISTE) ;


ALTER TABLE ETAPE 
  ADD FOREIGN KEY FK_ETAPE_RECETTE (NUM_RECETTE)
      REFERENCES RECETTE (NUM_RECETTE) ;


ALTER TABLE PREFERER 
  ADD FOREIGN KEY FK_PREFERER_UTILISATEUR (NUM_UTILISATEUR)
      REFERENCES UTILISATEUR (NUM_UTILISATEUR) ;


ALTER TABLE PREFERER 
  ADD FOREIGN KEY FK_PREFERER_RECETTE (NUM_RECETTE)
      REFERENCES RECETTE (NUM_RECETTE) ;


ALTER TABLE GERER 
  ADD FOREIGN KEY FK_GERER_ADMINISTRATEUR (NUM_ADMIN)
      REFERENCES ADMINISTRATEUR (NUM_ADMIN) ;


ALTER TABLE GERER 
  ADD FOREIGN KEY FK_GERER_RECETTE (NUM_RECETTE)
      REFERENCES RECETTE (NUM_RECETTE) ;


ALTER TABLE GERER 
  ADD FOREIGN KEY FK_GERER_NUTRITIONNISTE (NUM_NUTRITIONNISTE)
      REFERENCES NUTRITIONNISTE (NUM_NUTRITIONNISTE) ;


ALTER TABLE CONTENIR 
  ADD FOREIGN KEY FK_CONTENIR_RECETTE (NUM_RECETTE)
      REFERENCES RECETTE (NUM_RECETTE) ;


ALTER TABLE CONTENIR 
  ADD FOREIGN KEY FK_CONTENIR_INGREDIENTS (NUM_INGREDIENT)
      REFERENCES INGREDIENTS (NUM_INGREDIENT) ;


ALTER TABLE FOURNIR 
  ADD FOREIGN KEY FK_FOURNIR_INGREDIENTS (NUM_INGREDIENT)
      REFERENCES INGREDIENTS (NUM_INGREDIENT) ;


ALTER TABLE FOURNIR 
  ADD FOREIGN KEY FK_FOURNIR_FOURNISSEUR (NUM_FOURNISSEUR)
      REFERENCES FOURNISSEUR (NUM_FOURNISSEUR) ;

