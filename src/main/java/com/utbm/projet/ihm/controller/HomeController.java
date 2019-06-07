package com.utbm.projet.ihm.controller;

/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
import com.utbm.projet.dao.data.Recette;
import com.utbm.projet.dao.interf.RecipeDao;
import com.utbm.projet.ihm.model.HomeModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Controller class of the Home page.
 */
@ManagedBean
@Scope("session")
public class HomeController extends GenericController {

    @Autowired
    private HomeModel homeModel;

    @Autowired
    private RecipeDao recipeDao;

    @Override
    public void initModel() {
        homeModel.setHeartClass("heart");
        homeModel.setRecettes(list());

        Recette r = new Recette(1L, "Cookie", "Dessert", "Facile", "Cookie Desc", 10, 0, new byte[1]);
        File file = new File("/Users/neid/heart.svg");
        byte[] picInBytes = new byte[(int) file.length()];

        FileInputStream fileInputStream;
        try {
            System.err.println("TRY TO INSERT");
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(picInBytes);
            fileInputStream.close();
            r.setImageRecette(picInBytes);
            recipeDao.insert(r);
            System.out.println(r);
        } catch (FileNotFoundException ex) {
            System.err.println("FileNotFoundException");
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Recette> list() {
        List<Recette> l = new ArrayList<>();
        Recette r1 = new Recette(1L, "Cookie", "Dessert", "Facile", "Cookie Desc", 10, 0, new byte[1]);
        Recette r2 = new Recette(1L, "Muffin", "Dessert", "Facile", "Muffin Desc", 30, 0, new byte[1]);
        Recette r3 = new Recette(1L, "Cookie", "Dessert", "Facile", "Cookie Desc", 40, 0, new byte[1]);
        Recette r4 = new Recette(1L, "Muffin", "Dessert", "Facile", "Muffin Desc", 20, 0, new byte[1]);
        Recette r5 = new Recette(1L, "Cookie", "Dessert", "Facile", "Cookie Desc", 15, 0, new byte[1]);
        Recette r6 = new Recette(1L, "Muffin", "Dessert", "Facile", "Muffin Desc", 55, 0, new byte[1]);
        l.add(r1);
        l.add(r2);
        l.add(r3);
        l.add(r4);
        l.add(r5);
        l.add(r6);
        return l;
    }

    public void addToFavorite() {
        System.out.println("com.utbm.projet.ihm.view.HomeView.addToFavorite()");
        if ("heart".equals(homeModel.getHeartClass())) {
            homeModel.setHeartClass("red-heart");
        } else {
            homeModel.setHeartClass("heart");
        }
    }

}
