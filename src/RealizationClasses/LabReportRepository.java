package RealizationClasses;

import Entities.DischargeSummary;
import Entities.LabReport;
import Entities.Prescription;
import Interfaces.SearchableMedicalRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LabReportRepository implements SearchableMedicalRepository<LabReport> {


    private List<LabReport> ListLabReport = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);


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

        System.out.print("Введите дату анализа (ДД.ММ.ГГГГ): ");
        String date = scanner.nextLine();

        System.out.print("Введите полное имя пациента: ");
        String name = scanner.nextLine();

        LabReport labReport = SearchRecording(date,name);

        System.out.print("Введите старую или изменённую дату анализа (ДД.ММ.ГГГГ): ");
        date = scanner.nextLine();

        System.out.print("Введите старую или изменённое ФИО пациента: ");
        name = scanner.nextLine();

        System.out.print("Введите старые или изменённые результаты анализа: ");
        String analys = scanner.nextLine();

        labReport.setDate(date);
        labReport.setAnalysResult(analys);
        labReport.setFullNamePatient(name);

    }

    @Override
    public void AddNewRecording() {
        System.out.print("Введите дату выписки (ДД.ММ.ГГГГ): ");
        String date = scanner.nextLine();

        System.out.print("Введите полное имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите результаты анализа: ");
        String analysResult = scanner.nextLine();

        LabReport labReport = new LabReport(date,name,analysResult);
        ListLabReport.add(labReport);

        System.out.println("Вы ввели:");
        System.out.println("Дата выписки: " + date);
        System.out.println("Имя: " + name);
        System.out.println("Комментарий: " + analysResult);
    }

    @Override
    public void ReadRecordings() {
        System.out.println("Все Анализы");
        for(int i =0; i<ListLabReport.size();i++){
            System.out.println("Номер анализа: " + i + "Дата анализа: " + ListLabReport.get(i).getDate() +
                    "ФИО: " + ListLabReport.get(i).getFullNamePatient() + "Результат анализов: " + ListLabReport.get(i).getAnalysResult());

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
            System.out.print("Введите дату анализа (ДД.ММ.ГГГГ): ");
            String date = scanner.nextLine();

            System.out.print("Введите полное имя: ");
            String name = scanner.nextLine();

            LabReport labReport = SearchRecording(date,name);

            if(labReport != null){
                ListLabReport.remove(labReport);
            }
            else{
                System.out.println("Элемент не был найден");
            }

        }


    }
}
