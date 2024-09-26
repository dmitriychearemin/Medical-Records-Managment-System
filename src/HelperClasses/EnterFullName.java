package HelperClasses;

import java.util.Scanner;

public class EnterFullName {

    public String enterFullName(){
    Scanner scanner = new Scanner(System.in);
    String fullname;

        while(true){
            System.out.print("Введите ФИО: ");
            fullname = scanner.nextLine();
            if(hasAtLeastTwoWords(fullname)){
                return fullname;
            }
            else{
                System.out.print("Вы ввели некорректные ФИО: ");
            }
        }
    }

    public  boolean hasAtLeastTwoWords(String text) {

        String[] words = text.split("\\s+");
        return words.length >= 2;
    }

}
