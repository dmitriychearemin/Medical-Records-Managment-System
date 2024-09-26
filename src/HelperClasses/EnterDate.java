package HelperClasses;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EnterDate {

    public String enterDate(){
        Scanner scanner = new Scanner(System.in);
        String date;
        while (true){
             System.out.print("Введите дату (ДД.ММ.ГГГГ): ");
             date = scanner.nextLine();
             if(isValidDate(date)){
                 return date;
             }
             else{
                 System.out.print("Некорректная дата, повторите попытку: ");
             }
        }


    }

    public static boolean isValidDate(String dateString) {

        String pattern = "^\\d{2}\\.\\d{2}\\.\\d{4}$";
        return Pattern.matches(pattern, dateString);
    }
}
