/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view;

import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.ihm.model.HomeModel;
import java.io.ByteArrayInputStream;
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
public class HomeImage {

    @Autowired
    private HomeModel homeModel;

    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            Long num = Long.valueOf(context.getExternalContext().getRequestParameterMap().get("num"));

            Recette recipe = null;
            for (Recette rec : homeModel.getRecettes()) {
                if (rec.getNumRecette() == num) {
                    recipe = rec;
                }
            }

            if (recipe != null) {
                return new DefaultStreamedContent(new ByteArrayInputStream(recipe.getImageRecette()), "image/jpg");
            }

            return null;
        }
    }
}
