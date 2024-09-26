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
    public void UpdateRecording() {

        String date = enterDate.enterDate();
        String fullName =  enterFullName.enterFullName();

        LabReport labReport = SearchRecording(date,fullName);

        if(labReport!=null){
            System.out.print("Запись была найдена: \n");
            System.out.print("Ввод обновлённой записи: ");
            date = enterDate.enterDate();
            fullName =  enterFullName.enterFullName();

            System.out.print("Введите результаты анализа: ");
            String analys = scanner.nextLine();

            labReport.setDate(date);
            labReport.setAnalysResult(analys);
            labReport.setFullNamePatient(fullName);
        }
        else{
            System.out.print("Такой записи не существует: ");
        }


    }

    @Override
    public void AddNewRecording() {
        String date = enterDate.enterDate();
        String fullName =  enterFullName.enterFullName();

        System.out.print("Введите результаты анализа: ");
        String analysResult = scanner.nextLine();

        LabReport labReport = new LabReport(date,fullName,analysResult);
        ListLabReport.add(labReport);

        System.out.println("Вы ввели:");
        System.out.println("Дата выписки: " + date);
        System.out.println("Имя: " + fullName);
        System.out.println("Комментарий: " + analysResult);
    }

    @Override
    public void ReadRecordings() {
        System.out.println("Все Анализы");
        for(int i =0; i<ListLabReport.size();i++){
            System.out.println("Номер анализа: " + (i+1) + ListLabReport.get(i).toString());

        }

    }

    @Override
    public void DeleteRecording() {
        int opredelitel = 0;
        System.out.println("Если хотите удалить анализ по номеру - 1");
        System.out.println("Если хотите удалить анализ по ФИО и Дате - 2");
        opredelitel = scanner.nextInt();

        switch (opredelitel){
            case 1:
                System.out.println("Введите номер анализа");
                int number;
                number = scanner.nextInt();
                if(number > 0 && number <= ListLabReport.size()){
                    ListLabReport.remove(number-1);
                }
                else{
                    System.out.println("Элемент не был найден");
                }
                break;


            case 2:
                String date = enterDate.enterDate();
                String fullName =  enterFullName.enterFullName();
                LabReport labReport = SearchRecording(date,fullName);

                if(labReport != null){
                    System.out.println( "Удалён");
                    ListLabReport.remove(labReport);
                }
                else{
                    System.out.println("Элемент не был найден");
                }
                break;

            default:
                System.out.println("Некорректный номер функции повторите попытку");
                break;
        }

    }
}
