package Entities;

import Interfaces.EntitiesInterface;

public class DischargeSummary implements EntitiesInterface {

    private String Date;
    private String FullName;
    private String Commentaries;

    public DischargeSummary(String date, String fullName, String commentaries){
        Date = date;
        FullName = fullName;
        Commentaries = commentaries;
    }

    public void setDate(String date){
        Date = date;
    }

    public void setCommentaries(String commentaries) {
        Commentaries = commentaries;
    }

    public void setFullNamePatient(String fullName) {
        FullName = fullName;
    }

    public String getCommentaries() {
        return Commentaries;
    }

    public String getDate() {
        return Date;
    }

    public String getFullNamePatient() {
        return FullName;
    }

    @Override
    public String toString() {
        String string = " Дата выписки: " + Date +
                " ФИО: " + FullName + " Комментарий к выписке: " + Commentaries;
        return string;
    }
}
