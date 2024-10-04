


/*Система должна поддерживать
создание, чтение, обновление и удаление записей, а также их сортировку и поиск по
различным параметрам.
*/


import Entities.DischargeSummary;
import Entities.LabReport;
import Entities.Prescription;
import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import Interfaces.EntitiesInterface;
import Interfaces.MedicalRepository;
import Interfaces.SearchableMedicalRepository;
import RealizationClasses.DischargeSummaryRepository;
import RealizationClasses.LabReportRepository;
import RealizationClasses.PrescriptionRepository;
//import jline.console.ConsoleReader;
import java.io.Console;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        DischargeSummaryRepository dischargeSummaryRepository = new DischargeSummaryRepository();
        LabReportRepository labReportRepository = new LabReportRepository();
        PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

        UserInterface(dischargeSummaryRepository, labReportRepository, prescriptionRepository);

    }


    static void UserInterface(DischargeSummaryRepository dischargeSummaryRepository,
                              LabReportRepository labReportRepository,
                              PrescriptionRepository prescriptionRepository) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int opredelitel1, opredelitel2;
        EnterDate enterDate = new EnterDate();
        EnterFullName enterFullName = new EnterFullName();
        SearchableMedicalRepository repository = null;
        EntitiesInterface entitie = null;
        String date, fullName, commentary;


        while (true) {
            System.out.println("Работа с рецептами - 1");
            System.out.println("Работа с выписками - 2");
            System.out.println("Работа с анализами - 3");
            opredelitel1 = scanner.nextInt();

            switch (opredelitel1) {
                case 1:
                    repository = prescriptionRepository;
                    entitie = new Prescription("","","");
                    break;
                case 2:
                    repository = dischargeSummaryRepository;
                     entitie = new DischargeSummary("","","");
                    break;

                case 3:
                    repository = labReportRepository;
                    entitie = new LabReport("","","");
                    break;
                default:
                    System.out.println("Некорректный номер функции повторите попытку");
                    break;
            }

            System.out.println("Создать запись - 1");
            System.out.println("Прочитать записи - 2");
            System.out.println("Обновить запись - 3");
            System.out.println("Удалить запись - 4");
            System.out.println("Найти запись - 5");
            System.out.println("Сортировка записей - 6");

            opredelitel2 = scanner.nextInt();
            int opredelitel;
                    switch (opredelitel2) {
                        case 1:
                            date = enterDate.enterDate();
                            fullName =  enterFullName.enterFullName();
                            scanner.nextLine();
                            System.out.print("Введите комментарий: ");
                            commentary = scanner.nextLine();
                            entitie.setDate(date);
                            entitie.setFullNamePatient(fullName);
                            entitie.setCommentaries(commentary);
                            repository.AddNewRecording(entitie);
                            break;

                        case 2:
                            System.out.println("Все выписки");
                            for(int i =0; i<repository.ReadRecordings().size();i++){
                                System.out.println("Номер выписки: " + (i+1) + repository.ReadRecordings().get(i).toString());
                            }
                            break;

                        case 3:
                            date = enterDate.enterDate();
                            fullName =  enterFullName.enterFullName();
                            entitie = (EntitiesInterface) repository.SearchRecording(date,fullName);
                            if(entitie!=null) {
                                System.out.print("Запись была найдена: \n");
                                repository.UpdateRecording(entitie);

                            }
                            else{
                                System.out.print("Такой записи не существует: ");
                            }

                            break;
                        case 4:
                            opredelitel = 0;
                            System.out.println("Если хотите удалить выписку по номеру - 1");
                            System.out.println("Если хотите удалить выписку по ФИО и Дате - 2");
                            opredelitel = scanner.nextInt();

                            switch (opredelitel){
                                case 1:
                                    System.out.println("Введите номер выписки");
                                    int number;
                                    number = scanner.nextInt();
                                    if(number > 0 && number <= repository.ReadRecordings().size()){
                                        repository.ReadRecordings().remove(number-1);
                                    }
                                    else{
                                        System.out.println("Элемент не был найден");
                                    }
                                    break;

                                case 2:
                                    date = enterDate.enterDate();
                                    fullName =  enterFullName.enterFullName();

                                    entitie = (EntitiesInterface) repository.SearchRecording(date,fullName);

                                    if(entitie != null){
                                        System.out.println( "Удалён");
                                        repository.DeleteRecording(entitie);
                                    }
                                    else{
                                        System.out.println("Элемент не был найден");
                                    }
                                    break;

                                default:
                                    System.out.println("Некорректный номер функции повторите попытку");
                                    break;
                            }

                            break;
                        case 5:
                            System.out.println("Поиск по датам - 1");
                            System.out.println("Поиск по имени - 2");
                            System.out.println("Поиск по имени и дате - 3");
                            opredelitel = scanner.nextInt();
                            switch (opredelitel) {
                                case 1:
                                    date = enterDate.enterDate();
                                    repository.SearchRecordingToDate(date);
                                    break;
                                case 2:
                                    fullName = enterFullName.enterFullName();
                                    repository.SearchRecordingToName(fullName);
                                    break;

                                case 3:
                                    date = enterDate.enterDate();
                                    fullName = enterFullName.enterFullName();
                                    repository.SearchRecording(date, fullName);
                                    break;

                                default:
                                    System.out.println("Некорректный номер функции повторите попытку");
                                    break;
                            }
                            break;

                        case 6:
                            repository.SortRecordings();
                            break;
                        default:
                            System.out.println("Некорректный номер функции повторите попытку");
                            break;
                    }
        }
    }

}