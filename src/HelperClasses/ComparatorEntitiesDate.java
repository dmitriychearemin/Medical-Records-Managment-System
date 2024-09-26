package HelperClasses;

import Interfaces.EntitiesInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Scanner;

public class ComparatorEntitiesDate implements Comparator<EntitiesInterface> {

    @Override
    public int compare(EntitiesInterface record1, EntitiesInterface record2) {
        LocalDate date1 = LocalDate.parse(record1.getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate date2 = LocalDate.parse(record2.getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date2.compareTo(date1);

    }
}

