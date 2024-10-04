package Entities;

import Interfaces.EntitiesInterface;

public class Prescription implements EntitiesInterface {

    private String Date;
    private String FullNamePatient;
    private String Recipe;

    public Prescription(String date, String fullName, String recipe){
        Date = date;
        FullNamePatient = fullName;
        Recipe = recipe;
    }


    public void setFullNamePatient(String fullNamePatient) {
        FullNamePatient = fullNamePatient;
    }

    @Override
    public void setCommentaries(String commentory) {
        Recipe = commentory;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public String getFullNamePatient() {
        return FullNamePatient;
    }

    public String getDate() {
        return Date;
    }

    public String getRecipe() {
        return Recipe;
    }

    public String toString() {
        String string = " Дата рецепта: " + Date +
                " ФИО: " + FullNamePatient + " Рецепт: " + Recipe;
        return string;
    }
}

