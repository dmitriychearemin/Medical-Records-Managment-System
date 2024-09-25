package Interfaces;

public interface SearchableMedicalRepository<T> extends SortableMedicalRepository<T> {

    public T SearchRecording(String date, String fullName);


}
