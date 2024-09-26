


/*Система должна поддерживать
создание, чтение, обновление и удаление записей, а также их сортировку и поиск по
различным параметрам.
*/


import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import RealizationClasses.DischargeSummaryRepository;
import RealizationClasses.LabReportRepository;
import RealizationClasses.PrescriptionRepository;
//import jline.console.ConsoleReader;
import java.io.Console;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        DischargeSummaryRepository dischargeSummaryRepository = new DischargeSummaryRepository();
        LabReportRepository labReportRepository = new LabReportRepository();
        PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

        UserInterface(dischargeSummaryRepository,labReportRepository,prescriptionRepository);

    }



    static void UserInterface(DischargeSummaryRepository dischargeSummaryRepository,
                              LabReportRepository labReportRepository,
                              PrescriptionRepository prescriptionRepository) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int opredelitel1, opredelitel2;
        EnterDate enterDate = new EnterDate();
        EnterFullName enterFullName = new EnterFullName();
        //ConsoleReader reader = new ConsoleReader();
        while(true){

            System.out.println("Создать запись - 1");
            System.out.println("Прочитать записи - 2");
            System.out.println("Обновить запись - 3");
            System.out.println("Удалить запись - 4");
            System.out.println("Найти запись - 5");
            System.out.println("Сортировка записей - 6");
            System.out.println("Очистка консоли - 7");
            opredelitel1 = scanner.nextInt();

            /*if(opredelitel1 ==7){
                reader.clearScreen();
                continue;
            }*/

            System.out.println("Работа с рецептами - 1");
            System.out.println("Работа с выписками - 2");
            System.out.println("Работа с анализами - 3");
            opredelitel2 = scanner.nextInt();

            switch (opredelitel2){
                case 1:
                    switch (opredelitel1) {
                        case 1:
                            prescriptionRepository.AddNewRecording();
                            break;
                        case 2:
                            prescriptionRepository.ReadRecordings();
                            break;
                        case 3:
                            prescriptionRepository.UpdateRecording();
                            break;
                        case 4:
                            prescriptionRepository.DeleteRecording();
                            break;
                        case 5:
                            String date = enterDate.enterDate();
                            String name = enterFullName.enterFullName();
                            System.out.println(prescriptionRepository.SearchRecording(date,name));
                            break;

                        case 6:
                            prescriptionRepository.SortRecordings();
                            break;
                        default:
                            System.out.println("Некорректный номер функции повторите попытку");
                            break;
                    }
                    break;

                case 2:
                    switch (opredelitel1) {
                        case 1:
                            dischargeSummaryRepository.AddNewRecording();
                            break;
                        case 2:
                            dischargeSummaryRepository.ReadRecordings();
                            break;
                        case 3:
                            dischargeSummaryRepository.UpdateRecording();
                            break;
                        case 4:
                            dischargeSummaryRepository.DeleteRecording();
                            break;
                        case 5:
                            String date = enterDate.enterDate();
                            String name = enterFullName.enterFullName();
                            System.out.println(dischargeSummaryRepository.SearchRecording(date,name).toString());
                            break;
                        case 6:
                            dischargeSummaryRepository.SortRecordings();
                            break;
                        default:
                            System.out.println("Некорректный номер функции повторите попытку");
                            break;
                    }
                    break;

                case 3:
                    switch (opredelitel1) {
                        case 1:
                            labReportRepository.AddNewRecording();
                            break;
                        case 2:
                            labReportRepository.ReadRecordings();
                            break;
                        case 3:
                            labReportRepository.UpdateRecording();
                            break;
                        case 4:
                            labReportRepository.DeleteRecording();
                            break;
                        case 5:
                            String date = enterDate.enterDate();
                            String name = enterFullName.enterFullName();
                            System.out.println(labReportRepository.SearchRecording(date, name).toString());

                            break;
                        case 6:
                            labReportRepository.SortRecordings();
                            break;
                        default:
                            System.out.println("Некорректный номер функции повторите попытку");
                            break;
                    }
                    break;

                default:
                    System.out.println("Некорректный номер функции повторите попытку");
                    break;
            }


        }

    }

}