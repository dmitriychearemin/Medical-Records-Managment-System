package Entities;

public class DischargeSummary {

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

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getCommentaries() {
        return Commentaries;
    }

    public String getDate() {
        return Date;
    }

    public String getFullName() {
        return FullName;
    }

    @Override
    public String toString() {
        String string = " Дата выписки: " + Date +
                " ФИО: " + FullName + " Комментарий к выписке: " + Commentaries;
        return string;
    }
}
