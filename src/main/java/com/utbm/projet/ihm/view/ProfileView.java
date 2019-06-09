/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view;

import com.utbm.projet.ihm.controller.ProfileController;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * View class of the Profile page.
 */
@ManagedBean
@Scope("session")
public class ProfileView extends GenericView {

    @Autowired
    private ProfileController profileController;

    @Override
    public void initView() {
        // The initView() method is called for each AJAX call.
        // We only want to call it when we load the page.
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            return;
        }

        profileController.initModel();
    }

    public void onValidationSuccess() {
        profileController.updateUser();
    }
}
