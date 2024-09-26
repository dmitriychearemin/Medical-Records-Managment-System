package RealizationClasses;

import Entities.DischargeSummary;
import Entities.LabReport;
import Entities.Prescription;
import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import Interfaces.SearchableMedicalRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LabReportRepository implements SearchableMedicalRepository<LabReport> {


    private List<LabReport> ListLabReport = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    EnterFullName enterFullName;
    EnterDate enterDate;

    @Override
    public LabReport SearchRecording(String date, String fullName) {
        for (LabReport labReport : ListLabReport){
            if(labReport.getDate() == date && labReport.getFullNamePatient() == fullName){
                return labReport;
            }
        }
        return null;
    }

    @Override
    public void SortRecordings() {

        for (int i = 0; i < ListLabReport.size() - 1; i++) {
            for (int j = 0; j < ListLabReport.size() - i - 1; j++) {
                if (ListLabReport.get(j).getFullNamePatient().compareTo(ListLabReport.get(j + 1).getFullNamePatient()) > 0) {
                    // Меняем местами элементы, если они в неправильном порядке
                    LabReport temp = ListLabReport.get(j);
                    ListLabReport.set(j, ListLabReport.get(j + 1));
                    ListLabReport.set(j + 1, temp);
                }
            }
        }

    }


    @Override
    public void UpdateRecording() {

        String date = enterDate.enterDate();

        String fullName =  enterFullName.enterFullName();

        LabReport labReport = SearchRecording(date,fullName);


        System.out.print("Обновлённая запись: ");

        date = enterDate.enterDate();

        fullName =  enterFullName.enterFullName();

        System.out.print("Введите результаты анализа: ");
        String analys = scanner.nextLine();

        labReport.setDate(date);
        labReport.setAnalysResult(analys);
        labReport.setFullNamePatient(fullName);

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
            System.out.println("Номер анализа: " + i + ListLabReport.get(i).toString());

        }

    }

    @Override
    public void DeleteRecording() {
        int opredelitel = 0;
        System.out.println("Если хотите удалить анализ по номеру - 1");
        System.out.println("Если хотите удалить анализ по ФИО и Дате - 2");
        scanner.nextInt(opredelitel);

        if(opredelitel == 1){
            System.out.println("Введите номер анализа");
            int number = 0;
            scanner.nextInt(number);
            if(ListLabReport.get(number) != null){
                ListLabReport.remove(number);
            }
            else{
                System.out.println("Элемент не был найден");
            }
        }

        else if(opredelitel == 2){
            String date = enterDate.enterDate();
            String fullName =  enterFullName.enterFullName();
            LabReport labReport = SearchRecording(date,fullName);

            if(labReport != null){
                ListLabReport.remove(labReport);
            }
            else{
                System.out.println("Элемент не был найден");
            }

        }


    }
}
