/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view.recipe;

import com.utbm.projet.ihm.model.RecipeCreationModel;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@ManagedBean
@ApplicationScoped
public class RecipeCreationImage {

    @Autowired
    private RecipeCreationModel recipeCreationModel;

    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else if (recipeCreationModel.getRecipe().getImageRecette() != null) {
            return new DefaultStreamedContent(new ByteArrayInputStream(recipeCreationModel.getRecipe().getImageRecette()), "image/jpg");
        } else {
            InputStream inputStream;
            try {
                inputStream = new URL("https://i.imgur.com/voGu0IC.png").openStream();
                return new DefaultStreamedContent(inputStream, "image/png");
            } catch (MalformedURLException ex) {
                Logger.getLogger(RecipeCreationImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RecipeCreationImage.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }
    }
}
