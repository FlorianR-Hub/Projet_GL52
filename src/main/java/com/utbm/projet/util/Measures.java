/*
 * Projet GL52
 *
 * FENG Shunli - GRAF Pierrick - RIFFLART Florian
 *
 * UTBM P2019
 */
package com.utbm.projet.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public enum Measures {
    G("grammes (g)"),
    KG("kilogrammes (kg)"),
    L("litres (l)"),
    ML("millilitres (ml)"),
    CL("centilitres (cl)"),
    CAFE("c. à café "),
    SOUPE("c. à soupe"),
    THE("c. à thé");

    private String label;

    private Measures(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static List<String> getLabels() {
        List<String> values = new ArrayList<>();
        for (Measures typeEnum : values()) {
            values.add(typeEnum.getLabel());
        }

        return values;
    }

    public static String getEnumNameByLabel(String name) {

        for (Measures argEnum : Measures.values()) {
            if (argEnum.getLabel().equalsIgnoreCase(name)) {
                return argEnum.name().toLowerCase();
            }
        }

        return "";
    }

    public static Measures getByEnumName(String name) {

        for (Measures argEnum : Measures.values()) {
            if (argEnum.name().equalsIgnoreCase(name)) {
                return argEnum;
            }
        }

        return null;
    }
}
