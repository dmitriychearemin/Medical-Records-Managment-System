package Entities;

public class LabReport {

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

    public String getDate() {
        return Date;
    }

    public String getAnalysResult() {
        return AnalysResult;
    }

    public String getFullNamePatient() {
        return FullNamePatient;
    }
}
