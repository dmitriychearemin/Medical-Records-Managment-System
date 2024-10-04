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
    public void UpdateRecording(Prescription prescription) {

            System.out.print("Ввод обновлённой записи: ");
            String date = enterDate.enterDate();
            String fullName =  enterFullName.enterFullName();
            System.out.print("Введите рецепт: ");
            String recipe = scanner.nextLine();

            prescription.setDate(date);
            prescription.setRecipe(recipe);
            prescription.setFullNamePatient(fullName);


    }

    @Override
    public void AddNewRecording(Prescription prescription) {

        ListPrescription.add(prescription);

    }

    @Override
    public List<Prescription> ReadRecordings() {
        return ListPrescription;
    }

    @Override
    public void DeleteRecording(Prescription prescription) {
        ListPrescription.remove(prescription);
    }


}
