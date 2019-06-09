/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.ihm.model;

import java.util.List;
import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;

/**
 * Model class of the Profile page.
 */
@ManagedBean
@Scope("session")
public class ProfileModel {

    private String firstname;

    private String lastname;

    private String email;

    private String address;

    private Integer age;

    private Integer weight;

    private Integer height;

    private List<String> allergies;

    private List<String> deficiencies;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getDeficiencies() {
        return deficiencies;
    }

    public void setDeficiencies(List<String> deficiencies) {
        this.deficiencies = deficiencies;
    }

}
