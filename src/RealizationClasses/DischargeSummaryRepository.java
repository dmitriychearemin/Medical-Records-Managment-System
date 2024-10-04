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
    public void UpdateRecording(DischargeSummary dischargeSummary) {

        System.out.print("Ввод обновлённой записи: ");
        System.out.print("Обновлённая запись: ");
        String date = enterDate.enterDate();
        String fullName = enterFullName.enterFullName();
        System.out.print("Введите результаты выписки: ");
        String commentaries = scanner.nextLine();

        dischargeSummary.setDate(date);
        dischargeSummary.setCommentaries(commentaries);
        dischargeSummary.setFullNamePatient(fullName);


    }

    @Override
    public void AddNewRecording(DischargeSummary dischargeSummary) {

        ListDishargeSummary.add(dischargeSummary);

    }

    @Override
    public List<DischargeSummary> ReadRecordings() {

        return ListDishargeSummary;


    }

    @Override
    public void DeleteRecording(DischargeSummary dischargeSummary) {

        ListDishargeSummary.remove(dischargeSummary);
    }



}
