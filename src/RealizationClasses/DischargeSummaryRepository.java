package RealizationClasses;

import Entities.DischargeSummary;
import HelperClasses.ComparatorEntitiesDate;
import HelperClasses.ComparatorEntitiesName;
import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import Interfaces.SearchableMedicalRepository;

import java.util.*;

public class DischargeSummaryRepository implements SearchableMedicalRepository<DischargeSummary> {


    private List<DischargeSummary> ListDishargeSummary = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    EnterFullName enterFullName = new EnterFullName();
    EnterDate enterDate = new EnterDate();

    @Override
    public DischargeSummary SearchRecording(String date, String fullName) {

        for (DischargeSummary dischargeSummary : ListDishargeSummary){
            if(Objects.equals(dischargeSummary.getDate(), date) && Objects.equals(dischargeSummary.getFullNamePatient(), fullName)){
                System.out.println(dischargeSummary.toString());
                return dischargeSummary;
            }
        }
        return null;
    }

    @Override
    public void SearchRecordingToName(String name) {

        for (DischargeSummary dischargeSummary : ListDishargeSummary){
            if( Objects.equals(dischargeSummary.getFullNamePatient(),name)){
                System.out.println(dischargeSummary.toString());
            }
        }

    }

    @Override
    public void SearchRecordingToDate(String date) {

        for (DischargeSummary dischargeSummary : ListDishargeSummary){
            if( Objects.equals(dischargeSummary.getDate(),date)){
                System.out.println(dischargeSummary.toString());
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
                Collections.sort(ListDishargeSummary,new ComparatorEntitiesName());
                break;
            case 2:
                Collections.sort(ListDishargeSummary,new ComparatorEntitiesDate());
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

        DischargeSummary dischargeSummary = SearchRecording(date,fullName);

        if(dischargeSummary!=null) {
            System.out.print("Запись была найдена: \n");
            System.out.print("Ввод обновлённой записи: ");

            System.out.print("Обновлённая запись: ");
            date = enterDate.enterDate();
            fullName = enterFullName.enterFullName();
            System.out.print("Введите результаты выписки: ");
            String commentaries = scanner.nextLine();

            dischargeSummary.setDate(date);
            dischargeSummary.setCommentaries(commentaries);
            dischargeSummary.setFullNamePatient(fullName);
        }
        else{
            System.out.print("Такой записи не существует: ");
        }

    }

    @Override
    public void AddNewRecording() {

       String date = enterDate.enterDate();
        String fullName =  enterFullName.enterFullName();

        System.out.print("Введите комментарий: ");
        String commentary = scanner.nextLine();

        DischargeSummary dischargeSummary = new DischargeSummary(date,fullName,commentary);
        ListDishargeSummary.add(dischargeSummary);

        System.out.println("Вы ввели:");
        System.out.println("Дата выписки: " + date);
        System.out.println("Имя: " + fullName);
        System.out.println("Комментарий: " + commentary);

    }

    @Override
    public void ReadRecordings() {
        System.out.println("Все выписки");
        for(int i =0; i<ListDishargeSummary.size();i++){
            System.out.println("Номер выписки: " + (i+1) + ListDishargeSummary.get(i).toString());
        }
    }

    @Override
    public void DeleteRecording() {

        int opredelitel = 0;
        System.out.println("Если хотите удалить выписку по номеру - 1");
        System.out.println("Если хотите удалить выписку по ФИО и Дате - 2");
        opredelitel = scanner.nextInt();

        switch (opredelitel){
            case 1:
                System.out.println("Введите номер выписки");
                int number;
                number = scanner.nextInt();
                if(number > 0 && number <= ListDishargeSummary.size()){
                    ListDishargeSummary.remove(number-1);
                }
                else{
                    System.out.println("Элемент не был найден");
                }
                break;

            case 2:
                String date = enterDate.enterDate();
                String fullName =  enterFullName.enterFullName();

                DischargeSummary dischargeSummary = SearchRecording(date,fullName);

                if(dischargeSummary != null){
                    System.out.println( "Удалён");
                    ListDishargeSummary.remove(dischargeSummary);
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
