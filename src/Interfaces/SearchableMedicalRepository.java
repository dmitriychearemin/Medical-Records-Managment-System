package Interfaces;

import java.util.List;

public interface SearchableMedicalRepository<T> extends SortableMedicalRepository<T> {

    public T SearchRecording(String date, String fullName);

    void SearchRecordingToName(String name);

    void SearchRecordingToDate(String date);


}
