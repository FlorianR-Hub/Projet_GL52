/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.view;

import com.utbm.projet.ihm.controller.TemplateController;
import com.utbm.projet.ihm.model.TemplateModel;
import java.io.IOException;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * View class for the template of each pages.
 */
@ManagedBean
@Scope("session")
public class TemplateView extends GenericView {

    @Autowired
    private TemplateController templateController;

    @Autowired
    private TemplateModel templateModel;

    @Override
    public void initView() {
        // The initView() method is called for each AJAX call.
        // We only want to call it when we load the page.
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            return;
        }

        if (!templateModel.isLogged()) {
            templateController.initModel();
            PrimeFaces.current().executeScript("PF('dlg').show();");
        }

    }

    /**
     * Call the login() method of the controller class.
     */
    public void onLogin() throws IOException {
        templateController.login();
    }

    /**
     * Call the register() method of the controller class.
     *
     * @throws IOException
     */
    public void onRegister() throws IOException {
        templateController.register();
    }

    /**
     * Call the signOut() method of the controller class.
     *
     * @throws java.io.IOException
     */
    public void onSignOut() throws IOException {
        templateController.signOut();
    }

    /**
     * Call the signIn() method of the controller class.
     *
     * @throws java.io.IOException
     */
    public void onSignIn() throws IOException {
        templateController.signIn();
    }

    /**
     * Call the signUp() method of the controller class.
     *
     * @throws IOException
     */
    public void onSignUp() throws IOException {
        templateController.signUp();
    }

}
