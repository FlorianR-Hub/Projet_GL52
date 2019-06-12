/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.controller;

import com.utbm.projet.dao.data.Contenir;
import com.utbm.projet.dao.data.ContenirPK;
import com.utbm.projet.dao.data.Etape;
import com.utbm.projet.dao.data.EtapePK;
import com.utbm.projet.dao.data.Ingredients;
import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.interf.IngredientDao;
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.ihm.model.RecipeCreationModel;
import com.utbm.projet.util.Measures;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Controller class of the RecipeCreation page.
 */
@ManagedBean
@Scope("session")
public class RecipeCreationController extends GenericController {

    @Autowired
    private RecipeCreationModel recipeCreationModel;

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private IngredientDao ingredientDao;

    @Override
    public void initModel() {
        recipeCreationModel.setRecipe(new Recette());
        recipeCreationModel.setNewStep(new Etape());
        recipeCreationModel.setSteps(new ArrayList<>());
        recipeCreationModel.setNewIngredient(new Ingredients());
        recipeCreationModel.setNewIngredientInfos(new Contenir());
        recipeCreationModel.setIngredientsInfos(new ArrayList<>());

        List<String> ingredientNames = new ArrayList<>();
        for (Ingredients ingredient : ingredientDao.getAll()) {
            ingredientNames.add(ingredient.getNomIngredient());
        }
        recipeCreationModel.setIngredients(ingredientNames);

        recipeCreationModel.setMeasures(Measures.getLabels());
    }

    public void saveRecipe() {
        FacesMessage message = null;

        try {
            Recette recipe = recipeDao.insert(recipeCreationModel.getRecipe());
            List<Etape> steps = recipeCreationModel.getSteps();
            List<Contenir> ingredientsInfos = recipeCreationModel.getIngredientsInfos();

            for (Etape step : steps) {
                step.getEtapePK().setNumRecette(recipe.getNumRecette());
            }

            for (Contenir ingredientInfos : ingredientsInfos) {
                ingredientInfos.getContenirPK().setNumRecette(recipe.getNumRecette());
            }

            recipe.setEtapeList(steps);
            recipe.setContenirList(ingredientsInfos);;
            recipeDao.insert(recipe);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", "La recette a bien été ajoutée");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "La recette n'a pas pu être ajoutée");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void addStep() {
        List<Etape> steps = recipeCreationModel.getSteps();
        Etape newStep = recipeCreationModel.getNewStep();

        EtapePK stepPk = new EtapePK();
        stepPk.setNumEtape(steps.isEmpty() ? 1 : steps.size() + 1);
        newStep.setEtapePK(stepPk);
        steps.add(newStep);

        recipeCreationModel.setNewStep(new Etape());
        FacesMessage msg = new FacesMessage("Succès !", "Nouvelle étape ajoutée");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteStep() {
        recipeCreationModel.getSteps().remove(recipeCreationModel.getSelectedStep());
        recipeCreationModel.setSelectedStep(null);
    }

    public void addIngredientInfos() {
        List<Contenir> ingredientsInfos = recipeCreationModel.getIngredientsInfos();

        Ingredients newIngredient = recipeCreationModel.getNewIngredient();
        newIngredient.setNumIngredient(ingredientDao.getNumByName(newIngredient.getNomIngredient()));

        if (newIngredient.getNumIngredient() == null) {
            newIngredient = ingredientDao.insert(newIngredient);
        }

        Contenir newIngredientInfos = recipeCreationModel.getNewIngredientInfos();
        newIngredientInfos.setIngredients(newIngredient);
        newIngredientInfos.setUnite(Measures.getEnumNameByLabel(newIngredientInfos.getUnite()));

        ContenirPK ingredientInfosPk = new ContenirPK();
        ingredientInfosPk.setNumIngredient(newIngredient.getNumIngredient());
        newIngredientInfos.setContenirPK(ingredientInfosPk);

        ingredientsInfos.add(newIngredientInfos);

        recipeCreationModel.setNewIngredient(new Ingredients());
        recipeCreationModel.setNewIngredientInfos(new Contenir());
        FacesMessage msg = new FacesMessage("Succès !", "Nouvel ingrédient ajouté");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteIngredientInfos() {
        recipeCreationModel.getIngredientsInfos().remove(recipeCreationModel.getSelectedIngredientInfos());
        recipeCreationModel.setSelectedIngredientInfos(null);
    }
}
