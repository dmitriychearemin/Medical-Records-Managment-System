package RealizationClasses;

import Entities.DischargeSummary;
import Entities.LabReport;
import Entities.Prescription;
import HelperClasses.ComparatorEntitiesDate;
import HelperClasses.ComparatorEntitiesName;
import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import Interfaces.SearchableMedicalRepository;

import java.util.*;

public class LabReportRepository implements SearchableMedicalRepository<LabReport> {


    private List<LabReport> ListLabReport = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    EnterFullName enterFullName = new EnterFullName();
    EnterDate enterDate = new EnterDate();

    @Override
    public LabReport SearchRecording(String date, String fullName) {
        for (LabReport labReport : ListLabReport){
            if(Objects.equals(labReport.getDate(), date) && Objects.equals(labReport.getFullNamePatient(), fullName)){
                System.out.println(labReport.toString());
                return labReport;
            }
        }
        return null;
    }

    @Override
    public void SearchRecordingToName(String name) {

        for (LabReport labReport : ListLabReport){
            if( Objects.equals(labReport.getFullNamePatient(),name)){
                System.out.println(labReport.toString());
            }
        }

    }

    @Override
    public void SearchRecordingToDate(String date) {

        for (LabReport labReport : ListLabReport){
            if( Objects.equals(labReport.getDate(),date)){
                System.out.println(labReport.toString());
            }
        }
    }

    @Override
    public void SortRecordings() {

        scanner = new Scanner(System.in);
        System.out.println("Сортировка по имени - 1");
        System.out.println("Сортировка по дате - 2");
        int opredelitel = scanner.nextInt();

        switch (opredelitel){
            case 1:
                Collections.sort(ListLabReport,new ComparatorEntitiesName());
                break;
            case 2:
                Collections.sort(ListLabReport,new ComparatorEntitiesDate());
                break;

            default:
                System.out.println("Некорректный номер функции повторите попытку");
                break;

        }

    }

    @Override
    public void UpdateRecording(LabReport labReport) {

            System.out.print("Ввод обновлённой записи: ");
            String date = enterDate.enterDate();
            String fullName =  enterFullName.enterFullName();
            scanner.nextLine();
            System.out.print("Введите результаты анализа: ");
            String analys = scanner.nextLine();

            labReport.setDate(date);
            labReport.setAnalysResult(analys);
            labReport.setFullNamePatient(fullName);

    }

    @Override
    public void AddNewRecording(LabReport labReport) {
       ListLabReport.add(labReport);
    }

    @Override
    public List<LabReport> ReadRecordings() {

        return ListLabReport;
    }

    @Override
    public void DeleteRecording(LabReport labReport) {
        ListLabReport.remove(labReport);
    }
}
