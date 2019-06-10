/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.model;

import com.utbm.projet.dao.data.Contenir;
import com.utbm.projet.dao.data.Etape;
import com.utbm.projet.dao.data.Ingredients;
import com.utbm.projet.dao.data.Recette;
import java.util.List;
import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 * Model class of the RecipeCreation page.
 */
@ManagedBean
@Scope("session")
public class RecipeCreationModel {

    private Recette recipe;

    private Etape newStep;

    private Etape selectedStep;

    private List<Etape> steps;

    private Ingredients newIngredient;

    private List<String> ingredients;

    private Contenir newIngredientInfos;

    private Contenir selectedIngredientInfos;

    private List<Contenir> ingredientsInfos;

    private List<String> measures;

    public Recette getRecipe() {
        return recipe;
    }

    public void setRecipe(Recette recipe) {
        this.recipe = recipe;
    }

    public Etape getNewStep() {
        return newStep;
    }

    public void setNewStep(Etape newStep) {
        this.newStep = newStep;
    }

    public Etape getSelectedStep() {
        return selectedStep;
    }

    public void setSelectedStep(Etape selectedStep) {
        this.selectedStep = selectedStep;
    }

    public List<Etape> getSteps() {
        return steps;
    }

    public void setSteps(List<Etape> steps) {
        this.steps = steps;
    }

    public Ingredients getNewIngredient() {
        return newIngredient;
    }

    public void setNewIngredient(Ingredients newIngredient) {
        this.newIngredient = newIngredient;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Contenir getNewIngredientInfos() {
        return newIngredientInfos;
    }

    public void setNewIngredientInfos(Contenir newIngredientInfos) {
        this.newIngredientInfos = newIngredientInfos;
    }

    public Contenir getSelectedIngredientInfos() {
        return selectedIngredientInfos;
    }

    public void setSelectedIngredientInfos(Contenir selectedIngredientInfos) {
        this.selectedIngredientInfos = selectedIngredientInfos;
    }

    public List<Contenir> getIngredientsInfos() {
        return ingredientsInfos;
    }

    public void setIngredientsInfos(List<Contenir> ingredientsInfos) {
        this.ingredientsInfos = ingredientsInfos;
    }

    public List<String> getMeasures() {
        return measures;
    }

    public void setMeasures(List<String> measures) {
        this.measures = measures;
    }

}
