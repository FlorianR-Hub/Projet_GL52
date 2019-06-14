/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view.recipe;

import com.utbm.projet.ihm.controller.RecipeCreationController;
import com.utbm.projet.ihm.model.RecipeCreationModel;
import com.utbm.projet.ihm.view.GenericView;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * View class of the RecipeCreation page.
 */
@ManagedBean
@Scope("session")
public class RecipeCreationView extends GenericView {

    @Autowired
    private RecipeCreationController recipeCreationController;

    @Autowired
    private RecipeCreationModel recipeCreationModel;

    @Override
    public void initView() {
        // The initView() method is called for each AJAX call.
        // We only want to call it when we load the page.
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            return;
        }

        recipeCreationController.initModel();
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public void onSave() {
        recipeCreationController.saveRecipe();
    }

    public void onAddNewStep() {
        recipeCreationController.addStep();
    }

    public void onDeleteStep() {
        recipeCreationController.deleteStep();
    }

    public void onAddNewIngredientInfos() {
        recipeCreationController.addIngredientInfos();
    }

    public void onDeleteIngredientInfos() {
        recipeCreationController.deleteIngredientInfos();
    }

    public String getNextStepNum() {
        return Integer.toString(recipeCreationModel.getSteps().size() + 1);
    }

    public void upload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        byte[] contents = uploadedFile.getContents();

        recipeCreationModel.getRecipe().setImageRecette(contents);
    }
}
