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

public class PrescriptionRepository implements SearchableMedicalRepository<Prescription> {

    private List<Prescription> ListPrescription = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    EnterFullName enterFullName;
    EnterDate enterDate;

    @Override
    public Prescription SearchRecording(String date, String fullName) {
        for (Prescription prescription: ListPrescription){
            if(prescription.getDate() == date && prescription.getFullNamePatient() == fullName){
                return prescription;
            }
        }
        return null;

    }

    @Override
    public void SortRecordings() {
        for (int i = 0; i < ListPrescription.size() - 1; i++) {
            for (int j = 0; j < ListPrescription.size() - i - 1; j++) {
                if (ListPrescription.get(j).getFullNamePatient().compareTo(ListPrescription.get(j + 1).getFullNamePatient()) > 0) {
                    // Меняем местами элементы, если они в неправильном порядке
                    Prescription temp = ListPrescription.get(j);
                    ListPrescription.set(j, ListPrescription.get(j + 1));
                    ListPrescription.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void UpdateRecording() {

        String date = enterDate.enterDate();
        String fullName =  enterFullName.enterFullName();

        Prescription prescription = SearchRecording(date,fullName);

        System.out.print("Обновлённая запись: ");
        date = enterDate.enterDate();
        fullName =  enterFullName.enterFullName();
        System.out.print("Введите рецепт: ");
        String recipe = scanner.nextLine();

        prescription.setDate(date);
        prescription.setRecipe(recipe);
        prescription.setFullNamePatient(fullName);
    }

    @Override
    public void AddNewRecording() {

        String date = enterDate.enterDate();

        String fullName =  enterFullName.enterFullName();

        System.out.print("Введите результаты анализа: ");
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
            System.out.println("Номер рецепта: " + i + ListPrescription.get(i).toString());
        }
    }

    @Override
    public void DeleteRecording() {
        int opredelitel = 0;
        System.out.println("Если хотите удалить рецепт по номеру - 1");
        System.out.println("Если хотите удалить рецепт по ФИО и Дате - 2");
        scanner.nextInt(opredelitel);

        if(opredelitel == 1){
            System.out.println("Введите номер рецепта");
            int number = 0;
            scanner.nextInt(number);
            if(ListPrescription.get(number) != null){
                ListPrescription.remove(number);
            }
            else{
                System.out.println("Элемент не был найден");
            }
        }

        else if(opredelitel == 2){
            String date = enterDate.enterDate();
            String fullName =  enterFullName.enterFullName();

            Prescription prescription = SearchRecording(date,fullName);

            if(prescription != null){
                ListPrescription.remove(prescription);
            }
            else{
                System.out.println("Элемент не был найден");
            }

        }


    }
}
