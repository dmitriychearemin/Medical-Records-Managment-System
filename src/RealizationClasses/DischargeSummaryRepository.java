package RealizationClasses;

import Entities.DischargeSummary;
import Entities.LabReport;
import Interfaces.SearchableMedicalRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DischargeSummaryRepository implements SearchableMedicalRepository<DischargeSummary> {


    private List<DischargeSummary> ListDishargeSummary = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public DischargeSummary SearchRecording(String date, String fullName) {

        for (DischargeSummary dischargeSummary : ListDishargeSummary){
            if(dischargeSummary.getDate() == date && dischargeSummary.getFullName() == fullName){
                return dischargeSummary;
            }
        }
        return null;
    }

    @Override
    public void SortRecordings() {

        for (int i = 0; i < ListDishargeSummary.size() - 1; i++) {
            for (int j = 0; j < ListDishargeSummary.size() - i - 1; j++) {
                if (ListDishargeSummary.get(j).getFullName().compareTo(ListDishargeSummary.get(j + 1).getFullName()) > 0) {
                    // Меняем местами элементы, если они в неправильном порядке
                   DischargeSummary temp = ListDishargeSummary.get(j);
                    ListDishargeSummary.set(j, ListDishargeSummary.get(j + 1));
                    ListDishargeSummary.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void UpdateRecording() {
        System.out.print("Введите дату выписки (ДД.ММ.ГГГГ): ");
        String date = scanner.nextLine();

        System.out.print("Введите полное имя пациента: ");
        String name = scanner.nextLine();

        DischargeSummary dischargeSummary = SearchRecording(date,name);

        System.out.print("Введите старую или изменённую дату выписки (ДД.ММ.ГГГГ): ");
        date = scanner.nextLine();

        System.out.print("Введите старое или изменённое ФИО пациента: ");
        name = scanner.nextLine();

        System.out.print("Введите старые или изменённые результаты выписки: ");
        String commentaries = scanner.nextLine();

        dischargeSummary.setDate(date);
        dischargeSummary.setCommentaries(commentaries);
        dischargeSummary.setFullName(name);


    }

    @Override
    public void AddNewRecording() {

        System.out.print("Введите дату выписки (ДД.ММ.ГГГГ): ");
        String date = scanner.nextLine();

        System.out.print("Введите полное имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите комментарий: ");
        String commentary = scanner.nextLine();

        DischargeSummary dischargeSummary = new DischargeSummary(date,name,commentary);
        ListDishargeSummary.add(dischargeSummary);

        System.out.println("Вы ввели:");
        System.out.println("Дата выписки: " + date);
        System.out.println("Имя: " + name);
        System.out.println("Комментарий: " + commentary);

    }

    @Override
    public void ReadRecordings() {
        System.out.println("Все выписки");
        for(int i =0; i<ListDishargeSummary.size();i++){
            System.out.println("Номер выписки: " + i + "Дата выписки: " + ListDishargeSummary.get(i).getDate() +
                    "ФИО: " + ListDishargeSummary.get(i).getFullName() + "Комментарий к выписке: " + ListDishargeSummary.get(i).getCommentaries());

        }
    }

    @Override
    public void DeleteRecording() {

        int opredelitel = 0;
        System.out.println("Если хотите удалить выписку по номеру - 1");
        System.out.println("Если хотите удалить выписку по ФИО и Дате - 2");
        scanner.nextInt(opredelitel);

        if(opredelitel == 1){
            System.out.println("Введите номер выписки");
            int number = 0;
            scanner.nextInt(number);
            if(ListDishargeSummary.get(number) != null){
                ListDishargeSummary.remove(number);
            }
            else{
                System.out.println("Элемент не был найден");
            }
        }

        else if(opredelitel == 2){
            System.out.print("Введите дату выписки (ДД.ММ.ГГГГ): ");
            String date = scanner.nextLine();

            System.out.print("Введите полное имя: ");
            String name = scanner.nextLine();

            DischargeSummary dischargeSummary = SearchRecording(date,name);

            if(dischargeSummary != null){
                ListDishargeSummary.remove(dischargeSummary);
            }
            else{
                System.out.println("Элемент не был найден");
            }

        }

    }
}
