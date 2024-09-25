package RealizationClasses;

import Entities.DischargeSummary;
import Entities.LabReport;
import Entities.Prescription;
import Interfaces.SearchableMedicalRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrescriptionRepository implements SearchableMedicalRepository<Prescription> {

    private List<Prescription> ListPrescription = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public Prescription SearchRecording(String date, String fullName) {
        for (Prescription prescription : ListPrescription){
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
        System.out.print("Введите дату рецепта (ДД.ММ.ГГГГ): ");
        String date = scanner.nextLine();

        System.out.print("Введите полное имя пациента: ");
        String name = scanner.nextLine();

        Prescription prescription = SearchRecording(date,name);

        System.out.print("Введите старую или изменённую дату рецепта (ДД.ММ.ГГГГ): ");
        date = scanner.nextLine();

        System.out.print("Введите старое или изменённое ФИО пациента: ");
        name = scanner.nextLine();

        System.out.print("Введите старый или изменённый рецепт: ");
        String recipe = scanner.nextLine();

        prescription.setDate(date);
        prescription.setRecipe(recipe);
        prescription.setFullNamePatient(name);
    }

    @Override
    public void AddNewRecording() {

        System.out.print("Введите дату выписки (ДД.ММ.ГГГГ): ");
        String date = scanner.nextLine();

        System.out.print("Введите полное имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите результаты анализа: ");
        String recipe = scanner.nextLine();

        Prescription prescription = new Prescription(date,name,recipe);
        ListPrescription.add(prescription);

        System.out.println("Вы ввели:");
        System.out.println("Дата выписки: " + date);
        System.out.println("Имя: " + name);
        System.out.println("Комментарий: " + recipe);

    }

    @Override
    public void ReadRecordings() {
        System.out.println("Все Рецепты");
        for(int i =0; i<ListPrescription.size();i++){
            System.out.println("Номер рецепта: " + i + "Дата рецепта: " + ListPrescription.get(i).getDate() +
                    "ФИО: " + ListPrescription.get(i).getFullNamePatient() + "Рецепт: " + ListPrescription.get(i).getRecipe());

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
            System.out.print("Введите дату рецепта (ДД.ММ.ГГГГ): ");
            String date = scanner.nextLine();

            System.out.print("Введите полное имя: ");
            String name = scanner.nextLine();

            Prescription prescription = SearchRecording(date,name);

            if(prescription != null){
                ListPrescription.remove(prescription);
            }
            else{
                System.out.println("Элемент не был найден");
            }

        }


    }
}
