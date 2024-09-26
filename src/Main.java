


/*Система должна поддерживать
создание, чтение, обновление и удаление записей, а также их сортировку и поиск по
различным параметрам.
*/


import HelperClasses.EnterDate;
import HelperClasses.EnterFullName;
import RealizationClasses.DischargeSummaryRepository;
import RealizationClasses.LabReportRepository;
import RealizationClasses.PrescriptionRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DischargeSummaryRepository dischargeSummaryRepository = new DischargeSummaryRepository();
        LabReportRepository labReportRepository = new LabReportRepository();
        PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

        UserInterface(dischargeSummaryRepository,labReportRepository,prescriptionRepository);






    }



    static void UserInterface(DischargeSummaryRepository dischargeSummaryRepository,
                              LabReportRepository labReportRepository,
                              PrescriptionRepository prescriptionRepository){

        Scanner scanner = new Scanner(System.in);
        int opredelitel1 = 0, opredelitel2 = 0;
        EnterDate enterDate = new EnterDate();
        EnterFullName enterFullName = new EnterFullName();

        while(true){

            System.out.println("Создать запись - 1");
            System.out.println("Прочитать записи - 2");
            System.out.println("Обновить запись - 3");
            System.out.println("Удалить запись - 4");
            System.out.println("Найти запись - 5");
            System.out.println("Сортировка записей - 6");
            scanner.nextInt(opredelitel1);

            System.out.println("Работа с рецептами - 1");
            System.out.println("Работа с выписками - 2");
            System.out.println("Работа с анализами - 3");
            scanner.nextInt(opredelitel2);

            switch (opredelitel2){
                case 1:
                    switch (opredelitel2) {
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

                            prescriptionRepository.SearchRecording(date,name);
                            break;

                        case 6:
                            prescriptionRepository.SortRecordings();
                            break;
                    }
                    break;

                case 2:
                    switch (opredelitel2) {
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
                            dischargeSummaryRepository.SearchRecording(date,name);
                            break;
                        case 6:
                            dischargeSummaryRepository.SortRecordings();
                            break;
                    }
                    break;

                case 3:
                    switch (opredelitel2) {
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
                            labReportRepository.SearchRecording(date, name);
                            break;
                        case 6:
                            labReportRepository.SortRecordings();
                            break;
                    }
                    break;
            }


        }

    }

}