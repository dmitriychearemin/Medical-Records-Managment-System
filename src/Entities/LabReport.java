package Entities;

import Interfaces.EntitiesInterface;

public class LabReport implements EntitiesInterface {

    private String Date;
    private String FullNamePatient;
    private String AnalysResult;

    public LabReport(String date, String fullName, String analysResult){
        Date = date;
        FullNamePatient = fullName;
        AnalysResult = analysResult;
    }


    public void setAnalysResult(String analysResult) {
        AnalysResult = analysResult;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setFullNamePatient(String fullNamePatient) {
        FullNamePatient = fullNamePatient;
    }

    @Override
    public void setCommentaries(String commentory) {
        AnalysResult = commentory;
    }

    public String getDate() {
        return Date;
    }

    public String getAnalysResult() {
        return AnalysResult;
    }

    public String getFullNamePatient() {
        return FullNamePatient;
    }

    public String toString() {
        String string = " Дата анализа: " + Date +
                " ФИО: " + FullNamePatient + " Результаты анализа: " + AnalysResult;
        return string;
    }
}
