/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.controller;

import com.utbm.projet.dao.data.Administrateur;
import com.utbm.projet.dao.data.Allergenes;
import com.utbm.projet.dao.data.Carences;
import com.utbm.projet.dao.data.Nutritionniste;
import com.utbm.projet.dao.data.UserAuth;
import com.utbm.projet.dao.data.Utilisateur;
import com.utbm.projet.dao.interf.AdminDao;
import com.utbm.projet.dao.interf.AllergyDao;
import com.utbm.projet.dao.interf.DeficiencyDao;
import com.utbm.projet.dao.interf.NutritionistDao;
import com.utbm.projet.dao.interf.UserDao;
import com.utbm.projet.ihm.model.ProfileModel;
import com.utbm.projet.ihm.model.TemplateModel;
import com.utbm.projet.util.AccountTypes;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Controller class of the Profile page.
 */
@ManagedBean
@Scope("session")
public class ProfileController extends GenericController {

    @Autowired
    private ProfileModel profileModel;

    @Autowired
    private TemplateModel templateModel;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AllergyDao allergyDao;

    @Autowired
    private DeficiencyDao deficiencyDao;

    @Autowired
    private NutritionistDao nutritionistDao;

    @Override
    public void initModel() {
        UserAuth userAuth = templateModel.getUserAuth();
        Long userAuthId = userAuth.getId();

        if (userAuth.getAccountType() == AccountTypes.ADMINISTRATEUR.getId()) {
            Administrateur admin = adminDao.getByUserAuthId(userAuthId);
            admin.setId(userAuth);

            profileModel.setAdmin(admin);
        }

        if (userAuth.getAccountType() == AccountTypes.NUTRITIONNISTE.getId()) {
            Nutritionniste nutritionist = nutritionistDao.getByUserAuthId(userAuthId);
            nutritionist.setId(userAuth);

            profileModel.setNutritionist(nutritionist);
        }

        if (userAuth.getAccountType() == AccountTypes.UTILISATEUR.getId()) {
            Utilisateur user = userDao.getByUserAuthId(userAuthId);
            user.setId(userAuth);
            profileModel.setUser(user);

            List<String> allergiesName = new ArrayList<>();
            List<Allergenes> allergies = allergyDao.getAll();
            if (allergies != null) {
                for (Allergenes allergy : allergies) {
                    allergiesName.add(allergy.getNomAllergene());
                }
            }
            profileModel.setAllergiesName(allergiesName);

            List<String> deficienciesName = new ArrayList<>();
            List<Carences> deficiencies = deficiencyDao.getAll();
            if (deficiencies != null) {
                for (Carences deficiency : deficiencies) {
                    deficienciesName.add(deficiency.getNomCarence());
                }
            }
            profileModel.setDeficienciesName(deficienciesName);

            List<String> allergiesNameSelected = new ArrayList<>();
            if (user.getAllergenesList() != null) {
                for (Allergenes allergy : user.getAllergenesList()) {
                    allergiesNameSelected.add(allergy.getNomAllergene());
                }
            }
            profileModel.setAllergiesNameSelected(allergiesNameSelected);

            List<String> deficienciesNameSelected = new ArrayList<>();
            if (user.getCarencesList() != null) {
                for (Carences deficiency : user.getCarencesList()) {
                    deficienciesNameSelected.add(deficiency.getNomCarence());
                }
            }
            profileModel.setDeficienciesNameSelected(deficienciesNameSelected);
        }
    }

    public void updatePerson() {
        FacesMessage message = null;

        try {
            int accountType = templateModel.getUserAuth().getAccountType();

            switch (accountType) {
                case 2:
                    updateNutritionist();
                    break;
                case 1:
                    updateAdmin();
                    break;
                case 0:
                    updateUser();
                    break;
                default:
                    break;
            }

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès !", "Les informations ont bien été mises à jour");
        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur !", "Erreur lors de la mise à jour des informations");
        } finally {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void updateAdmin() throws Exception {
        adminDao.update(profileModel.getAdmin());
    }

    public void updateNutritionist() throws Exception {
        nutritionistDao.update(profileModel.getNutritionist());
    }

    public void updateUser() throws Exception {
        Utilisateur user = profileModel.getUser();

        List<String> allergiesNameSelected = profileModel.getAllergiesNameSelected();
        List<Allergenes> allergies = new ArrayList<>();

        if (allergiesNameSelected != null) {
            for (String allergyName : allergiesNameSelected) {
                allergies.add(allergyDao.getByName(allergyName));
            }
        }
        user.setAllergenesList(allergies);

        List<String> deficienciesNameSelected = profileModel.getDeficienciesNameSelected();
        List<Carences> deficiencies = new ArrayList<>();

        if (deficienciesNameSelected != null) {
            for (String deficiencyName : deficienciesNameSelected) {
                deficiencies.add(deficiencyDao.getByName(deficiencyName));
            }
        }
        user.setCarencesList(deficiencies);

        userDao.update(user);
    }
}
