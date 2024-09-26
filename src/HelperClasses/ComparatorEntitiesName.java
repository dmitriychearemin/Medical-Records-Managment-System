package HelperClasses;

import Interfaces.EntitiesInterface;

import java.util.Comparator;

public class ComparatorEntitiesName implements Comparator<EntitiesInterface> {

    @Override
    public int compare(EntitiesInterface record1, EntitiesInterface record2) {
        return record1.getFullNamePatient().compareTo(record2.getFullNamePatient());
    }
}
