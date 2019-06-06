/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view;

import com.utbm.projet.ihm.controller.HomeController;
import com.utbm.projet.ihm.model.HomeModel;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * View class of the Home page.
 */
@ManagedBean
@Scope("session")
public class HomeView extends GenericView {

    @Autowired
    private HomeController homeController;

    @Autowired
    private HomeModel homeModel;

    @Override
    public void initView() {
        // The initView() method is called for each AJAX call.
        // We only want to call it when we load the page.
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            return;
        }

        homeController.initModel();
    }

}
