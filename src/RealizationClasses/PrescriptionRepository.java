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

public class PrescriptionRepository implements SearchableMedicalRepository<Prescription> {

    private List<Prescription> ListPrescription = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    EnterFullName enterFullName = new EnterFullName() ;
    EnterDate enterDate = new EnterDate();

    @Override
    public Prescription SearchRecording(String date, String fullName) {
        for (Prescription prescription: ListPrescription){
            if(Objects.equals(prescription.getDate(), date) && Objects.equals(prescription.getFullNamePatient(), fullName)){
                System.out.println(prescription.toString());
                return prescription;
            }
        }
        return null;
    }

    @Override
    public void SearchRecordingToName(String name) {

        for (Prescription prescription : ListPrescription){
            if( Objects.equals(prescription.getFullNamePatient(),name)){
                System.out.println(prescription.toString());
            }
        }

    }

    @Override
    public void SearchRecordingToDate(String date) {

        for (Prescription prescription : ListPrescription){
            if( Objects.equals(prescription.getDate(),date)){
                System.out.println(prescription.toString());
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
                Collections.sort(ListPrescription,new ComparatorEntitiesName());
                break;
            case 2:
                Collections.sort(ListPrescription,new ComparatorEntitiesDate());
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

        Prescription prescription = SearchRecording(date,fullName);

        if(prescription!=null){
            System.out.print("Запись была найдена: \n");
            System.out.print("Ввод обновлённой записи: ");
            date = enterDate.enterDate();
            fullName =  enterFullName.enterFullName();
            System.out.print("Введите рецепт: ");
            String recipe = scanner.nextLine();

            prescription.setDate(date);
            prescription.setRecipe(recipe);
            prescription.setFullNamePatient(fullName);
        }

        else{
            System.out.print("Такой записи не существует: ");
        }

    }

    @Override
    public void AddNewRecording() {

        String date = enterDate.enterDate();
        String fullName =  enterFullName.enterFullName();

        System.out.print("Введите рецепт: ");
        String recipe = scanner.nextLine();

        Prescription prescription = new Prescription(date,fullName,recipe);
        ListPrescription.add(prescription);

        System.out.println("Вы ввели:");
        System.out.println("Дата выписки: " + date);
        System.out.println("Имя: " + fullName);
        System.out.println("Комментарий: " + recipe);

    }

    @Override
    public void ReadRecordings() {
        System.out.println("Все Рецепты");
        for(int i =0; i<ListPrescription.size();i++){
            System.out.println("Номер рецепта: " + (i+1) + ListPrescription.get(i).toString());
        }
    }

    @Override
    public void DeleteRecording() {
        int opredelitel = 0;
        System.out.println("Если хотите удалить рецепт по номеру - 1");
        System.out.println("Если хотите удалить рецепт по ФИО и Дате - 2");
        opredelitel = scanner.nextInt();

        switch (opredelitel){

            case  1:
                System.out.println("Введите номер рецепта");
                int number;
                number = scanner.nextInt();
                if(number > 0 && number <= ListPrescription.size()){
                    ListPrescription.remove(number-1);
                }
                else{
                    System.out.println("Элемент не был найден");
                }
                break;

            case 2:
                String date = enterDate.enterDate();
                String fullName =  enterFullName.enterFullName();
                Prescription prescription = SearchRecording(date,fullName);
                if(prescription != null){
                    System.out.println( "Удалён");
                    ListPrescription.remove(prescription);
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
