/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.controller;

import com.utbm.projet.dao.data.Allergenes;
import com.utbm.projet.dao.data.Anc;
import com.utbm.projet.dao.data.Contenir;
import com.utbm.projet.dao.data.ContenirPK;
import com.utbm.projet.dao.data.Etape;
import com.utbm.projet.dao.data.EtapePK;
import com.utbm.projet.dao.data.Ingredients;
import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.interf.AllergyDao;
import com.utbm.projet.dao.interf.AncDao;
import com.utbm.projet.dao.interf.IngredientDao;
import com.utbm.projet.ihm.model.RecipeCreationModel;
import com.utbm.projet.service.interf.RecipeService;
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
    private RecipeService recipeService;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private AllergyDao allergyDao;

    @Autowired
    private AncDao ancDao;

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

        List<String> allergiesName = new ArrayList<>();
        List<Allergenes> allergies = allergyDao.getAll();
        if (allergies != null) {
            for (Allergenes allergy : allergies) {
                allergiesName.add(allergy.getNomAllergene());
            }
        }
        recipeCreationModel.setAllergiesName(allergiesName);

        List<String> ancsName = new ArrayList<>();
        List<Anc> ancs = ancDao.getAll();
        if (ancs != null) {
            for (Anc anc : ancs) {
                ancsName.add(anc.getNomAnc());
            }
        }
        recipeCreationModel.setAncsName(ancsName);
    }

    public void saveRecipe() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            Recette recipe = recipeCreationModel.getRecipe();

            List<String> allergiesNameSelected = recipeCreationModel.getAllergiesNameSelected();
            List<Allergenes> allergens = new ArrayList<>();

            if (allergiesNameSelected != null) {
                for (String allergyName : allergiesNameSelected) {
                    allergens.add(allergyDao.getByName(allergyName));
                }
            }
            recipe.setAllergenesList(allergens);

            List<String> ancsNameSelected = recipeCreationModel.getAncsNameSelected();
            List<Anc> ancs = new ArrayList<>();

            if (ancsNameSelected != null) {
                for (String ancName : ancsNameSelected) {
                    ancs.add(ancDao.getByName(ancName));
                }
            }
            recipe.setAncList(ancs);

            Recette recipeSaved = recipeService.createRecipe(recipe);
            List<Etape> steps = recipeCreationModel.getSteps();
            List<Contenir> ingredientsInfos = recipeCreationModel.getIngredientsInfos();

            for (Etape step : steps) {
                step.getEtapePK().setNumRecette(recipeSaved.getNumRecette());
            }

            for (Contenir ingredientInfos : ingredientsInfos) {
                ingredientInfos.setUnite(Measures.getEnumNameByLabel(ingredientInfos.getUnite()));
            }

            for (Contenir ingredientInfos : ingredientsInfos) {
                ingredientInfos.getContenirPK().setNumRecette(recipeSaved.getNumRecette());
            }

            recipeSaved.setEtapeList(steps);
            recipeSaved.setContenirList(ingredientsInfos);;
            recipeService.updateRecipe(recipeSaved);

            context.getExternalContext().redirect("recipe.xhtml?num=" + recipeSaved.getNumRecette());
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "La recette n'a pas pu être ajoutée");
            context.addMessage(null, message);
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
