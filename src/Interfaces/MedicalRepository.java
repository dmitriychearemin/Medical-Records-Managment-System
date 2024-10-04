package Interfaces;

import java.util.List;

public interface MedicalRepository <T>{

        public void UpdateRecording(T obj);

        public void AddNewRecording(T obj);

        public List<T> ReadRecordings();

        public void DeleteRecording(T obj);


}
