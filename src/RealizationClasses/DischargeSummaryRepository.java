package RealizationClasses;

import Entities.DischargeSummary;
import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import Interfaces.SearchableMedicalRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DischargeSummaryRepository implements SearchableMedicalRepository<DischargeSummary> {


    private List<DischargeSummary> ListDishargeSummary = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    EnterFullName enterFullName;
    EnterDate enterDate;

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

                   DischargeSummary temp = ListDishargeSummary.get(j);
                    ListDishargeSummary.set(j, ListDishargeSummary.get(j + 1));
                    ListDishargeSummary.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void UpdateRecording() {

        String date = enterDate.enterDate();

        String fullName =  enterFullName.enterFullName();

        DischargeSummary dischargeSummary = SearchRecording(date,fullName);

        System.out.print("Обновлённая запись: ");
        date = enterDate.enterDate();
        fullName = scanner.nextLine();
        System.out.print("Введите результаты выписки: ");
        String commentaries = scanner.nextLine();

        dischargeSummary.setDate(date);
        dischargeSummary.setCommentaries(commentaries);
        dischargeSummary.setFullName(fullName);


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
            System.out.println("Номер выписки: " + i + ListDishargeSummary.get(i).toString());
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

            String date = enterDate.enterDate();

            String fullName =  enterFullName.enterFullName();

            DischargeSummary dischargeSummary = SearchRecording(date,fullName);

            if(dischargeSummary != null){
                ListDishargeSummary.remove(dischargeSummary);
            }
            else{
                System.out.println("Элемент не был найден");
            }

        }

    }
}
